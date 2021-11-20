package org.miage.bibliotheque.gestion;

import org.miage.bibliotheque.metier.Livre;
import org.miage.bibliotheque.metier.Magazine;
import org.miage.bibliotheque.metier.Oeuvre;
import org.miage.bibliotheque.repositories.OeuvreResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "oeuvres")
public class OeuvresController {

    private final OeuvreResource or;

    public OeuvresController(OeuvreResource or) {
        this.or = or;
    }

    @GetMapping
    public String getAllOeuvres(Model model) {
        List<Oeuvre> oeuvres = or.findAll();
        List<Livre> livres = oeuvres.stream().filter(oeuvre -> oeuvre instanceof Livre).map(Livre.class::cast).collect(Collectors.toList());
        List<Magazine> magazines = oeuvres.stream().filter(oeuvre -> oeuvre instanceof Magazine).map(Magazine.class::cast).collect(Collectors.toList());
        model.addAttribute("livres", livres);
        model.addAttribute("magazines", magazines);
        return "oeuvres";
    }
}
