package org.miage.bibliotheque.gestion;

import org.miage.bibliotheque.metier.Livre;
import org.miage.bibliotheque.metier.Magazine;
import org.miage.bibliotheque.metier.Oeuvre;
import org.miage.bibliotheque.repositories.LivreResource;
import org.miage.bibliotheque.repositories.MagazineResource;
import org.miage.bibliotheque.repositories.OeuvreResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "oeuvres")
public class OeuvresController {

    private final OeuvreResource or;
    private final LivreResource lr;
    private final MagazineResource mr;

    public OeuvresController(OeuvreResource or, LivreResource lr, MagazineResource mr) {
        this.or = or;
        this.lr = lr;
        this.mr = mr;
    }

    // GET
    @GetMapping
    public String getAllOeuvres(Model model) {
        List<Oeuvre> oeuvres = or.findAll();
        List<Livre> livres = oeuvres.stream().filter(oeuvre -> oeuvre instanceof Livre).map(Livre.class::cast).collect(Collectors.toList());
        List<Magazine> magazines = oeuvres.stream().filter(oeuvre -> oeuvre instanceof Magazine).map(Magazine.class::cast).collect(Collectors.toList());
        model.addAttribute("livres", livres);
        model.addAttribute("magazines", magazines);
        return "oeuvres";
    }

    // POST
    @PostMapping(value = "/add/livre", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @Transactional
    public String addLivre(Livre livre) {
        Livre livre2Save = new Livre(
                UUID.randomUUID().toString(),
                livre.getTitre(),
                livre.getDatePublication(),
                0,
                new ArrayList<>(),
                new ArrayList<>(),
                livre.getAuteur()
        );
        lr.save(livre2Save);
        return "redirect:/oeuvres";
    }

    // POST
    @PostMapping(value = "/add/magazine", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @Transactional
    public String addMagazine(Magazine magazine) {
        Magazine magazine2Save = new Magazine(
                UUID.randomUUID().toString(),
                magazine.getTitre(),
                magazine.getDatePublication(),
                0,
                new ArrayList<>(),
                new ArrayList<>(),
                magazine.getNumero()
        );
        mr.save(magazine2Save);
        return "redirect:/oeuvres";
    }

    // DELETE
    @DeleteMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @Transactional
    public String deleteOeuvre(@RequestParam String isbn) {
        or.deleteById(isbn);
        return "redirect:/oeuvres";
    }

}
