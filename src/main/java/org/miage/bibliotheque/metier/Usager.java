package org.miage.bibliotheque.metier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usager implements Serializable {

    @Id
    private String id;
    private String nom;
    private String prenom;
    @OneToMany(mappedBy = "usager")
    private List<Emprunt> emprunts;


    public Usager e_identification(String nom){
        //TODO
        return this;
    }
}
