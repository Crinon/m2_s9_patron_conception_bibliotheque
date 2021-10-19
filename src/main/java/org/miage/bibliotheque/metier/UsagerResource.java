package org.miage.bibliotheque.metier;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsagerResource extends JpaRepository<Usager, String> {
}
