package org.miage.bibliotheque.repositories;

import org.miage.bibliotheque.metier.Exemplaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExemplaireResource extends JpaRepository<Exemplaire, String> {
}
