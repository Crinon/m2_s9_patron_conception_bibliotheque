package org.miage.bibliotheque.metier;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationResource extends JpaRepository<Reservation, String> {
}
