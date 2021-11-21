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

    public enum Etat {
        DISPONIBLE,
        INDISPONIBLE
    }

    @Id
    private String id;
    @Enumerated(EnumType.STRING)
    private Etat etat;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "oeuvre_isbn", nullable = false)
    private Oeuvre oeuvre;
    @OneToMany(mappedBy = "exemplaire")
    private List<Emprunt> emprunt;

    public Exemplaire e_identification(Oeuvre oeuvre){
        // TODO
        return this;
    }

}
