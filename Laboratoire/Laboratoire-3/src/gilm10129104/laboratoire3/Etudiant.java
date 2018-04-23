package gilm10129104.laboratoire3;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static gilm10129104.laboratoire3.Constante.*;

/**
 * Created by gilm101291 on 2018-02-13.
 */
public class Etudiant {

    enum Sexe {
        Homme, Femme
    }

    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private Sexe sexe;

// ------------Constructor-------------

    public Etudiant(String nom, String prenom, LocalDate dateNaissance, Sexe sexe) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
    }
// --------------getter----------------

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public LocalDate getDateNaissance() {
        return this.dateNaissance;
    }

    public Sexe getSexe() {
        return this.sexe;
    }

    public long getAge() {
        LocalDate today = LocalDate.now();
        return ChronoUnit.YEARS.between(this.dateNaissance, today);
    }

    public String getCodePermanent() {
        int jour = dateNaissance.getDayOfMonth();
        int mois = dateNaissance.getMonthValue();
        int annee = dateNaissance.getYear();
        int anneeFormate;

        if (annee > 2000) {
            anneeFormate = annee - 2000;
        } else {
            anneeFormate = annee - 1900;
        }

        String nom3PL = this.nom.toUpperCase().substring(0, 3);
        String prenom1L = this.prenom.toUpperCase().substring(0, 1);
        int jourFormate = (annee > 2000 ? (jour += 62) : jour);
        int moisFormate = (this.sexe == Sexe.Femme ? (mois += 50) : mois);
// @formatter:off
        return nom3PL +
               prenom1L +
               jourFormate +
               (mois < 10 ? "0" + moisFormate : moisFormate) +
               (anneeFormate < 10 ? "0"+ anneeFormate : anneeFormate);
//@formatter:on
    }
//---------------Methode de formatage toString()----------------

    public String toString() {
        return "Nom:               " + this.nom + System.lineSeparator() +
            "Prenom:            " + this.prenom + System.lineSeparator() +
            "Sexe:              " + this.sexe + System.lineSeparator() +
            "Age:               " + this.getAge() + System.lineSeparator() +
            "Code Permanent     " + this.getCodePermanent() + System.lineSeparator();
    }

//---------------Désérialisation d'un étudiant-----------------------

    public static Etudiant parseEtu(String etuToString) {

        String prenom = "";
        int annee = 0;
        int mois = 0;
        int jour = 0;
        String nom = "";
        Sexe sexe = null;
        LocalDate naissance = null;
        String[] tokens = etuToString.split(";");

        for (String c : tokens) {
            String[] cv = c.split(":");
            switch (cv[0]) {
                case PRENOM:
                    prenom = cv[1];
                    break;
                case DATE_NAISSANCE:
                    annee = Integer.parseInt(cv[1]);
                    mois = Integer.parseInt(cv[2]);
                    jour = Integer.parseInt(cv[3]);
                    naissance = LocalDate.of(annee, mois, jour);
                    break;
                case NOM:
                    nom = cv[1];
                    break;
                case SEXE:
                    sexe = Sexe.valueOf(cv[1]);
            }
        }
        return new Etudiant(nom, prenom, naissance, sexe);
    }
}