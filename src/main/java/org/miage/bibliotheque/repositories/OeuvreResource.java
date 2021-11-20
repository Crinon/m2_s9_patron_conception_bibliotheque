package org.miage.bibliotheque.repositories;

import org.miage.bibliotheque.metier.Oeuvre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OeuvreResource extends JpaRepository<Oeuvre, String> {
}
