package org.miage.bibliotheque.metier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

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

}
