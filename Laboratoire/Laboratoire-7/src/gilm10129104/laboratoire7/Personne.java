package gilm10129104.laboratoire7;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by GILM101291 on 2018-03-27.
 */
public class Personne {

    //Énummation sur le sexe de la personne homme ou femme
   public enum Sexe {
        M, F
    }

    private String prenom;
    private String nom;
    private String courriel;
    private Sexe sexe;
    private String departement;
    private LocalDate dateNaissance;


// ------------Constructor-------------


    public Personne(String prenom, String nom, String courriel, Sexe sexe, String departement, LocalDate dateNaissance) {
        this.prenom = prenom;
        this.nom = nom;
        this.courriel = courriel;
        this.sexe = sexe;
        this.departement = departement;
        this.dateNaissance = dateNaissance;
    }
//--------------Getters----------------
    public String getCourriel() {
        return courriel;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public String getDepartement() {
        return departement;
    }

//--------------Methode-------------------------------------
    public long getAge() {
        return ChronoUnit.YEARS.between(dateNaissance, LocalDate.now());
    }

    public  static Personne parsePersonne(String line){

        String elements[] = line.split(",");

        String naissance[]= elements[5].split("/");
        int annee = Integer.parseInt(naissance[0]);
        int mois = Integer.parseInt(naissance[1]);
        int jour = Integer.parseInt(naissance[2]);
        LocalDate date = LocalDate.of(annee, mois, jour);
        Sexe sexe = Personne.Sexe.valueOf(elements[3]);
        return  new Personne(elements[0],elements[1],elements[2],sexe ,elements[4],date);
    }

    public String toString(){
        return  String.format("%-20s%-20s%-5d%-10s%-30s%-30s", getPrenom(),getNom(),getAge(),getSexe(),getDepartement(),getCourriel());

    }
}

