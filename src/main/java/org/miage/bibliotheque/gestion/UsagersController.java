package org.miage.bibliotheque.gestion;

import org.miage.bibliotheque.metier.Usager;
import org.miage.bibliotheque.repositories.UsagerResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "usagers")
public class UsagersController {

    private static Logger LOG = Logger.getLogger(UsagersController.class.getName());
    private final UsagerResource ur;

    public UsagersController(UsagerResource ur) {
        this.ur = ur;
    }

    // GET
    @GetMapping
    public String getAllUsagers(Model model) {
        model.addAttribute("usagers", ur.findAll());
        return "usagers";
    }

    // POST
    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @Transactional
    public String addUsager(Usager usager, Model model) {
        Usager usager2Save = new Usager(
                UUID.randomUUID().toString(),
                usager.getNom(),
                usager.getPrenom(),
                new ArrayList<>()
        );
        ur.save(usager2Save);
        return getAllUsagers(model);
    }

    // DELETE
    @DeleteMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @Transactional
    public RedirectView deleteUsager(@RequestParam String usagerId) {
        ur.deleteById(usagerId);
        RedirectView rw = new RedirectView();
        rw.setUrl("usagers");
        return rw;
    }
}
