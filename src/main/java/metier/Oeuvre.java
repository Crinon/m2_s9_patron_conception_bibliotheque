package metier;

import java.util.ArrayList;
import java.util.Date;

public class Oeuvre extends Livre {
    private int ISBN;
    private String titre;
    private String auteur;
    private Date datePuplication;
    private int nbEmpruntEnCours;
    private ArrayList<Exemplaire> exemplaires;
    private ArrayList<Reservation> reservations;

    public Oeuvre(int ISBN, String titre, String auteur, Date datePuplication, int nbEmpruntEnCours) {
        this.ISBN = ISBN;
        this.titre = titre;
        this.auteur = auteur;
        this.datePuplication = datePuplication;
        this.nbEmpruntEnCours = nbEmpruntEnCours;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public Date getDatePuplication() {
        return datePuplication;
    }

    public void setDatePuplication(Date datePuplication) {
        this.datePuplication = datePuplication;
    }

    public int getNbEmpruntEnCours() {
        return nbEmpruntEnCours;
    }

    public void setNbEmpruntEnCours(int nbEmpruntEnCours) {
        this.nbEmpruntEnCours = nbEmpruntEnCours;
    }

    public ArrayList<Exemplaire> getExemplaires() {
        return exemplaires;
    }

    public void setExemplaires(ArrayList<Exemplaire> exemplaires) {
        this.exemplaires = exemplaires;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Oeuvre e_identification(String titre){
        // TODO
        return this;
    }
}
