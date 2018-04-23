package gilm10129104.laboratoire9.commande;

import gilm10129104.laboratoire9.Personne;

import java.util.List;

/**
 * Created by GILM101291 on 2018-04-03.
 */
public class Ajouter implements Commande {

    Personne personne;
    private List<Personne> personnes;

    public Ajouter(Personne personne,List<Personne> personnes ) {
        this.personne = personne;
        this.personnes = personnes;
    }

    public void executer(){
        personnes.add(personne);
    }
    public void annuler(){
        personnes.remove(personne);

    }

}
