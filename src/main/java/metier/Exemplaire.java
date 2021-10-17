package metier;

public class Exemplaire {

    enum Etat {
        DISPONIBLE,
        INDISPONIBLE
    }

    private Etat etat;
    private int identifiant;
    private Oeuvre oeuvre;
    private Emprunt emprunt;

    public Exemplaire(int identifiant) {
        this.etat = Etat.DISPONIBLE;
        this.identifiant = identifiant;
    }

    public Exemplaire e_identification(Oeuvre oeuvre){
        // TODO
        return this;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

}
