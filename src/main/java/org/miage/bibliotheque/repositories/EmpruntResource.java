package org.miage.bibliotheque.repositories;

import org.miage.bibliotheque.metier.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpruntResource extends JpaRepository<Emprunt, String> {
}
