package org.miage.bibliotheque.metier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation implements Serializable {

    @Id
    private String id;
    private Date dateReservation;
    private Date dateAnnulation;
    @ManyToOne
    @JoinColumn(name = "usager_id", nullable = false)
    private Usager usager;
    @ManyToOne
    @JoinColumn(name = "oeuvre_isbn", nullable = false)
    private Oeuvre oeuvre;

}
