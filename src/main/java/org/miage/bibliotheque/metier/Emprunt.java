package org.miage.bibliotheque.metier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emprunt implements Serializable {

    @Id
    private String id;
    private LocalDate dateEmprunt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "oeuvre_isbn", nullable = false)
    private Oeuvre oeuvre;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exemplaire_id", nullable = false)
    private Exemplaire exemplaire;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usager_id", nullable = false)
    private Usager usager;
}
