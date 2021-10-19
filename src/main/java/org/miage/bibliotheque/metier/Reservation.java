package org.miage.bibliotheque.metier;

import java.util.Date;

public class Reservation {
    private Date dateReservation;

    public Date getDateAnnulation() {
        return dateAnnulation;
    }

    private Date dateAnnulation;

    private Usager usager;
    private Oeuvre oeuvre;

    public Reservation(Date dateReservation, Usager usager, Oeuvre oeuvre) {
        this.dateReservation = dateReservation;
        this.usager = usager;
        this.oeuvre = oeuvre;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public Usager getUsager() {
        return usager;
    }

    public void setUsager(Usager usager) {
        this.usager = usager;
    }

    public Oeuvre getOeuvre() {
        return oeuvre;
    }

    public void setOeuvre(Oeuvre oeuvre) {
        this.oeuvre = oeuvre;
    }

    public void annuler(Date date){
        this.dateAnnulation = date;
    }
}
