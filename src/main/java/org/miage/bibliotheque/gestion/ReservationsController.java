package org.miage.bibliotheque.gestion;

import org.miage.bibliotheque.metier.Reservation;
import org.miage.bibliotheque.repositories.OeuvreResource;
import org.miage.bibliotheque.repositories.ReservationResource;
import org.miage.bibliotheque.repositories.UsagerResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping(value = "reservations")
public class ReservationsController {
    private final ReservationResource reservationResource;
    private final UsagerResource usagerResource;
    private final OeuvreResource oeuvreResource;


    public ReservationsController(ReservationResource reservationResource, UsagerResource usagerResource, OeuvreResource oeuvreResource) {
        this.reservationResource = reservationResource;
        this.usagerResource = usagerResource;
        this.oeuvreResource = oeuvreResource;
    }

    // GET
    @GetMapping
    public String getAllReservartions(Model model) {
        model.addAttribute("reservations", reservationResource.findAll());
        model.addAttribute("usagers", usagerResource.findAll());
        model.addAttribute("oeuvres", oeuvreResource.findAll());
        return "reservations"; // nom du model HTML
    }

    // POST
    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @Transactional
    public String addReservartions(Reservation reservation) {
        Reservation reservation2Save = new Reservation(
                UUID.randomUUID().toString(),
                LocalDate.now(),
                null,
                reservation.getUsager(),
                reservation.getOeuvre()
        );
        reservationResource.save(reservation2Save);
        return "redirect:/reservations";
    }

    // PUT
    @PatchMapping
    @Transactional
    public String cancelReservation(@RequestParam String reservationID){
        Optional<Reservation> current = reservationResource.findById(reservationID);
        current.get().setDateAnnulation(LocalDate.now());
        reservationResource.save(current.get());
        return "redirect:/reservations";
    }


}
