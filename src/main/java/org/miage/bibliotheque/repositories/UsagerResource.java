package org.miage.bibliotheque.repositories;

import org.miage.bibliotheque.metier.Usager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsagerResource extends JpaRepository<Usager, String> {
}
