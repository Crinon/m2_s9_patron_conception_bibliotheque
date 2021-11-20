package org.miage.bibliotheque.repositories;

import org.miage.bibliotheque.metier.Magazine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagazineResource extends JpaRepository<Magazine, String> {
}
