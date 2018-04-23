package gilm10129104.laboratoire9;

import gilm10129104.laboratoire9.commande.Ajouter;
import gilm10129104.laboratoire9.commande.Commande;
import gilm10129104.laboratoire9.commande.Supprimer;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by GILM101291 on 2018-04-03.
 */
public class BaseDonnees {

    private List<Personne> personnes;

    public BaseDonnees(){
        this.personnes=new ArrayList<>();
    }

    private Personne creer() {
        String nom, prenom, sexe;
        Clavier clavier = Clavier.getInstance();
        System.out.println("NOM : ");
        nom = clavier.nextLine();
        System.out.println("Prénom : ");
        prenom = clavier.nextLine();
        System.out.println("Sexe : ");
        sexe = clavier.nextLine();

        return new Personne(nom, prenom, sexe);
    }

    private Personne creer(Personne p) {
        return new Personne(p.getNom(), p.getPrenom(), p.getSexe());
    }

    private Personne trouver(long id) {
        for (Personne p : personnes) {
            if (p.getId() == id) {
                return personnes.get((int)p.getId());
            }
        }
        return null;
    }

    public boolean afficher() {

        if(personnes.size()>0) {
            for (Personne p : personnes) {
                System.out.println(p);
            }
            return true;
        }else {
            return false;
        }

    }

    public Commande ajouter() {

        return new Ajouter(creer(), personnes);
    }

    public Commande supprimer() {
        Clavier clavier = Clavier.getInstance();
        long id = Long.parseLong(clavier.nextLine());
        return new Supprimer(trouver(id), personnes);
    }

    public Commande modifier() {
        return null;
    }

}
