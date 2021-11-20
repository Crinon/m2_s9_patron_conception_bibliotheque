package org.miage.bibliotheque.gestion;

import org.miage.bibliotheque.repositories.ExemplaireResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "exemplaires")
public class ExemplairesController {
    private static Logger LOG = Logger.getLogger(UsagersController.class.getName());
    private final ExemplaireResource exemplaireResource;

    public ExemplairesController(ExemplaireResource exemplaireResource){
        this.exemplaireResource=exemplaireResource;
    }

    // GET
    @GetMapping(value = "/{idcurrent}")
    public String getAllExemplaires(Model model, @PathVariable String idcurrent) {
        model.addAttribute("exemplairesFromOeuvre", exemplaireResource.findByOeuvre_Isbn(idcurrent));
        return "exemplaires"; // nom du template HTML
    }


    // DELETE
    @DeleteMapping(value="/{oeuvreid}",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @Transactional
    public String deleteUsager(@RequestParam String exemplaireID, @PathVariable String oeuvreid) {
        exemplaireResource.deleteById(exemplaireID);
        return "redirect:/exemplaires/"+oeuvreid;
    }

}
