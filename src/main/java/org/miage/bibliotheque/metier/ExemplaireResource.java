package org.miage.bibliotheque.metier;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExemplaireResource extends JpaRepository<Exemplaire, String> {
}
