package org.miage.bibliotheque.metier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "issn")
@Data
@AllArgsConstructor
@NoArgsConstructor
@OnDelete(action = OnDeleteAction.CASCADE)
public class Magazine extends Oeuvre implements Serializable {

    private int numero;

    public Magazine(String isbn, String titre, LocalDate datePublication, int nbEmpruntEnCours, List<Exemplaire> exemplaires, List<Reservation> reservations, int numero) {
        super(isbn, titre, datePublication, nbEmpruntEnCours, exemplaires, reservations);
        this.numero = numero;
    }
}
