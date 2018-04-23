package gilm10129104.laboratoire9;

/**
 * Created by GILM101291 on 2018-04-03.
 */
public class Personne {
    private static int indice = 0;
    private String nom;
    private String prenom;
    private String sexe;
    private long id;

    private Personne() {
        this(null, null, null);
    }

    public Personne(String nom, String prenom, String sexe) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.id = indice;
        indice++;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public long getId() {
        return id;
    }

    public void copy(Personne p) {

        this.nom = p.nom;
        this.prenom = p.prenom;
        this.sexe = p.sexe;

    }

    public Personne clone() {
        Personne p = new Personne();
        p.copy(this);
        return p;
    }

    boolean equals(Personne p){
        boolean resultat = false;

        resultat = this.id == p.getId();
        return resultat;
    }

    @Override
    public String toString() {
        return  String.format("%-3d%-20s%-20s%-10s",getId(), getNom(),getPrenom(),getSexe());
    }
}