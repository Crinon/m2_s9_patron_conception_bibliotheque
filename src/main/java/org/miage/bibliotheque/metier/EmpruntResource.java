package org.miage.bibliotheque.metier;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpruntResource extends JpaRepository<Emprunt, String> {
}
