package org.miage.bibliotheque.metier;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MagazineResource extends JpaRepository<Magazine, String> {
}
