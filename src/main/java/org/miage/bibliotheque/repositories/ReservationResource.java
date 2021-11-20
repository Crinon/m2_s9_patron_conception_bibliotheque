package org.miage.bibliotheque.repositories;

import org.miage.bibliotheque.metier.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationResource extends JpaRepository<Reservation, String> {
}
