package org.miage.bibliotheque.repositories;

import org.miage.bibliotheque.metier.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreResource extends JpaRepository<Livre, String> {
}
