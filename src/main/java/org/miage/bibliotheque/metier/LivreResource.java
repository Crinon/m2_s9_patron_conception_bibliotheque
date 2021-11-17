package org.miage.bibliotheque.metier;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreResource extends JpaRepository<Livre, String> {
}
