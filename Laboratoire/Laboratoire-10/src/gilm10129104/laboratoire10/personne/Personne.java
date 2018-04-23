package gilm10129104.laboratoire10.personne;

public class Personne implements Comparable {


    public enum Sexe {
        Homme, Femme
    }

    private Sexe sexe;
    private String nom;
    private String prenom;
    private long id;

    public static long IDS = 0;

    public Sexe getSexe() {
        return sexe;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    private Personne() {
    }

    public Personne(String nom, String prenom, Sexe sexe) {
        this(IDS++, nom, prenom, sexe);
    }

    public Personne(long id, String nom, String prenom, Sexe sexe) {
        this.sexe = sexe;
        this.nom = nom;
        this.prenom = prenom;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String toString() {
        return String.format("%02d %-20s%-20s%-10s", id, prenom, nom, getSexe());
    }

    public String serialise() {
        return String.format("%d,%s,%s,%s", id, prenom, nom, getSexe());
    }

    @Override
    public int compareTo(Object o) {
        Personne personne = (Personne) o;
        return Long.compare(getId(), personne.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personne personne = (Personne) o;
        return id == personne.id;
    }

    public void copy(Personne personne) {
        this.sexe = personne.sexe;
        this.nom = personne.nom;
        this.prenom = personne.prenom;
    }

    public Personne clone() {
        Personne personne = new Personne();
        personne.copy(this);
        return personne;
    }

}
