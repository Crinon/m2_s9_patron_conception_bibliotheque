package org.miage.bibliotheque.metier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Oeuvre implements Serializable {

    @Id
    private String isbn;
    private String titre;
    private LocalDate datePublication;
    private int nbEmpruntEnCours;
    @OneToMany(mappedBy = "oeuvre", cascade = CascadeType.REMOVE)
    private List<Exemplaire> exemplaires;
    @OneToMany(mappedBy = "oeuvre")
    private List<Reservation> reservations;

    public Oeuvre e_identification(String titre){
        // TODO
        return this;
    }
}
