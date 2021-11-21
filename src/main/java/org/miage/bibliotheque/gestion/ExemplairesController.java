package org.miage.bibliotheque.gestion;

import org.miage.bibliotheque.metier.Exemplaire;
import org.miage.bibliotheque.repositories.ExemplaireResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.UUID;
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
    @GetMapping(value = "/{idCurrent}")
    public String getAllExemplaires(Model model, @PathVariable String idCurrent) {
        model.addAttribute("exemplairesFromOeuvre", exemplaireResource.findByOeuvre_Isbn(idCurrent));
        model.addAttribute("oeuvreId", idCurrent);
        return "exemplaires"; // nom du template HTML
    }


    // DELETE
    @DeleteMapping(value="/{oeuvreId}",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @Transactional
    public String deleteExemplaire(@RequestParam String exemplaireID, @PathVariable String oeuvreId) {
        exemplaireResource.deleteById(exemplaireID);
        return "redirect:/exemplaires/"+oeuvreId;
    }

    // POST
    @PostMapping(value = "/{oeuvreId}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @Transactional
    public String addExemplaire(Exemplaire exemplaire, @PathVariable String oeuvreId) {
        Exemplaire ex2Save = new Exemplaire(
                UUID.randomUUID().toString(),
                Exemplaire.Etat.DISPONIBLE,
                exemplaire.getOeuvre(),
                new ArrayList<>()
        );
        exemplaireResource.save(ex2Save);
        return "redirect:/exemplaires/"+oeuvreId;
    }

}
