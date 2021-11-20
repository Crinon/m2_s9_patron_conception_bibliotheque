package org.miage.bibliotheque.metier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@OnDelete(action = OnDeleteAction.CASCADE)
public class Livre extends Oeuvre implements Serializable {

    private String auteur;

    public Livre(String isbn, String titre, LocalDate datePublication, int nbEmpruntEnCours, List<Exemplaire> exemplaires, List<Reservation> reservations, String auteur) {
        super(isbn, titre, datePublication, nbEmpruntEnCours, exemplaires, reservations);
        this.auteur = auteur;
    }
}
