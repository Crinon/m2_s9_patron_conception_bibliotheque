package org.miage.bibliotheque.gestion;

import org.miage.bibliotheque.metier.Emprunt;
import org.miage.bibliotheque.metier.Exemplaire;
import org.miage.bibliotheque.metier.Reservation;
import org.miage.bibliotheque.repositories.*;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping(value = "emprunts")
public class EmpruntsController {

    private final EmpruntResource empruntResource;
    private final OeuvreResource oeuvreResource;
    private final UsagerResource usagerResource;
    private final ExemplaireResource exemplaireResource;
    private final ReservationResource reservationResource;

    public EmpruntsController(EmpruntResource empruntResource, OeuvreResource oeuvreResource, UsagerResource usagerResource, ExemplaireResource exemplaireResource, ReservationResource reservationResource) {
        this.empruntResource = empruntResource;
        this.oeuvreResource = oeuvreResource;
        this.usagerResource = usagerResource;
        this.exemplaireResource = exemplaireResource;
        this.reservationResource = reservationResource;
    }

    // GET
    @GetMapping
    public String getAllEmprunts(Model model) {
        model.addAttribute("emprunts", empruntResource.findAll());
        model.addAttribute("oeuvres", oeuvreResource.findAll());
        model.addAttribute("usagers", usagerResource.findAll());
        return "emprunts";
    }

    // POST
    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @Transactional
    public String addEmprunt(Emprunt emprunt, RedirectAttributes redirAttrs) {
        Optional<Exemplaire> exemplaireDispo = exemplaireResource.findFirstByOeuvre_IsbnAndEtat(emprunt.getOeuvre().getIsbn(), Exemplaire.Etat.DISPONIBLE);
        Optional<Reservation> resaUsager = reservationResource.findFirstByUsager_IdAndOeuvre_IsbnAndDateAnnulationNullOrderByDateReservationAsc(emprunt.getUsager().getId(), emprunt.getOeuvre().getIsbn());
        // On vérifie si un exemplaire est dispo
        if (exemplaireDispo.isPresent()) {
            // Si oui, on annule la réservation s'il y a en a une
            resaUsager.ifPresent(reservation -> reservation.setDateAnnulation(LocalDate.now()));
            // Puis on crée l'emprunt
            Emprunt emprunt2Save = new Emprunt(
                    UUID.randomUUID().toString(),
                    LocalDate.now(),
                    emprunt.getOeuvre(),
                    exemplaireDispo.get(),
                    emprunt.getUsager()
            );
            exemplaireDispo.get().setEtat(Exemplaire.Etat.INDISPONIBLE);
            empruntResource.save(emprunt2Save);
        } else {
            // Sinon, on alerte et on renvoie vers la page de création de réservations
            if (resaUsager.isPresent()) {
                redirAttrs.addFlashAttribute("errorMessage", "Aucun exemplaire n'est disponible. Une réservation est déjà en cours.");
            } else {
                redirAttrs.addFlashAttribute("reservationMessage", "Aucun exemplaire n'est disponible.");
            }
        }
        return "redirect:/emprunts";
    }

    // DELETE
    @DeleteMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @Transactional
    public String deleteExemplaire(@RequestParam String empruntId, @RequestParam String etat, RedirectAttributes redirAttrs) {
        Exemplaire ex2update = empruntResource.getById(empruntId).getExemplaire();
        empruntResource.deleteById(empruntId);
        if (etat.equals("abime")) {
            exemplaireResource.delete(ex2update);
            redirAttrs.addFlashAttribute("errorMessage", "L'exemplaire état en mauvais état et a donc été jeté.");
        } else {
            ex2update.setEtat(Exemplaire.Etat.DISPONIBLE);
        }
        return "redirect:/emprunts";
    }

}
