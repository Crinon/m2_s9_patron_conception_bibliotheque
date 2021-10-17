package metier;

import java.util.Date;

public class Emprunt {
    private Date dateEmprunt;
    private Oeuvre oeuvre;
    private Exemplaire exemplaire;
    private Usager usager;

    public Emprunt(Date dateEmprunt, Oeuvre oeuvre, Exemplaire exemplaire, Usager usager) {
        this.dateEmprunt = dateEmprunt;
        this.oeuvre = oeuvre;
        this.exemplaire = exemplaire;
        this.usager = usager;
    }

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public Oeuvre getOeuvre() {
        return oeuvre;
    }

    public void setOeuvre(Oeuvre oeuvre) {
        this.oeuvre = oeuvre;
    }

    public Exemplaire getExemplaire() {
        return exemplaire;
    }

    public void setExemplaire(Exemplaire exemplaire) {
        this.exemplaire = exemplaire;
    }

    public Usager getUsager() {
        return usager;
    }

    public void setUsager(Usager usager) {
        this.usager = usager;
    }
}
