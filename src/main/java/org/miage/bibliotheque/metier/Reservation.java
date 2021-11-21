package org.miage.bibliotheque.metier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation implements Serializable {

    @Id
    private String id;
    private LocalDate dateReservation;
    private LocalDate dateAnnulation;
    @ManyToOne
    @JoinColumn(name = "usager_id", nullable = false)
    private Usager usager;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "oeuvre_isbn", nullable = false)
    private Oeuvre oeuvre;
}
