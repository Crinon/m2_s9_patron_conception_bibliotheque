package metier;

import java.util.ArrayList;

public class Usager {
    private String nom;
    private String prenom;
    private ArrayList<Reservation> reservations;
    private ArrayList<Emprunt> emprunts;

    public Usager(String nom, String prenom, ArrayList<Reservation> reservations, ArrayList<Emprunt> emprunts) {
        this.nom = nom;
        this.prenom = prenom;
        this.reservations = reservations;
        this.emprunts = emprunts;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }

    public ArrayList<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(ArrayList<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }

    public Usager e_identification(String nom){
        //TODO
        return this;
    }
}
