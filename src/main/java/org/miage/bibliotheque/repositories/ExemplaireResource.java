package org.miage.bibliotheque.repositories;

import org.miage.bibliotheque.metier.Exemplaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExemplaireResource extends JpaRepository<Exemplaire, String> {
    List<Exemplaire> findByOeuvre_Isbn(String isbn);
}
