package gilm10129104.Laboratoire2.Q1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Created by gilm101291 on 2018-02-06.
 */
public class Personne {

    private String nom;
    private String prenom;
    private LocalDate naissance;

    public Personne(String nom, String prenom,LocalDate naissance)
    {
        this.nom=nom;
        this.prenom=prenom;
        this.naissance=naissance;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public LocalDate getDateNaissance() {
        return this.naissance;
    }

    public long getAge() {
        LocalDate today = LocalDate.now();
        return ChronoUnit.YEARS.between(this.naissance, today);

    }

    public void afficher() {
        String age = "an";
        // @formatter:off
        System.out.println(
                getPrenom() + " " +
                getNom() + " né le " +
                getDateNaissance().format(DateTimeFormatter.ofPattern("dd MMMM yyyy")) +
                " est agé de " + getAge() + " " + ( age = (getAge() > 0) ? "ans" : "an"));
         // @formatter:on
    }
}
