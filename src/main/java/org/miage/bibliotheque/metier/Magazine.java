package org.miage.bibliotheque.metier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.io.Serializable;

@Entity
@PrimaryKeyJoinColumn(name = "issn")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Magazine extends Oeuvre implements Serializable {

    private int numero;
}
