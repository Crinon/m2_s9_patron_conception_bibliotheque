package org.miage.bibliotheque.metier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usager implements Serializable {

    @Id
    private String id;
    private String nom;
    private String prenom;

    public Usager e_identification(String nom){
        //TODO
        return this;
    }
}
