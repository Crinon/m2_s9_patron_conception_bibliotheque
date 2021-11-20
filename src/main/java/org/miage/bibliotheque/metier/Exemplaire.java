package org.miage.bibliotheque.metier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exemplaire implements Serializable {

    private enum Etat {
        DISPONIBLE,
        INDISPONIBLE
    }

    @Id
    private String id;
    private Etat etat;
    @ManyToOne
    @JoinColumn(name = "oeuvre_isbn", nullable = false)
    private Oeuvre oeuvre;
    @OneToMany(mappedBy = "exemplaire")
    private List<Emprunt> emprunt;

    public Exemplaire e_identification(Oeuvre oeuvre){
        // TODO
        return this;
    }

}
