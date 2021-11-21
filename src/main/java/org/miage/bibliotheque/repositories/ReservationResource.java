package org.miage.bibliotheque.repositories;

import org.miage.bibliotheque.metier.Reservation;
import org.miage.bibliotheque.metier.Usager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ReservationResource extends JpaRepository<Reservation, String> {
    Optional<Reservation> findFirstByUsager_IdAndOeuvre_IsbnAndDateAnnulationNullOrderByDateReservationAsc(String id, String isbn);
}
