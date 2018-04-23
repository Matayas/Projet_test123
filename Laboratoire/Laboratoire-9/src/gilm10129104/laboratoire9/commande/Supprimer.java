package gilm10129104.laboratoire9.commande;

import gilm10129104.laboratoire9.Personne;

import java.util.List;

/**
 * Created by GILM101291 on 2018-04-03.
 */
public class Supprimer implements Commande{
    Personne personne;
    private List<Personne> personnes;

    public Supprimer(Personne personne, List<Personne> personnes) {
        this.personne = personne;
        this.personnes = personnes;
    }

    public void executer(){

        personnes.remove(personne);

    }
    public void annuler(){
        personnes.add(personne);
    }
}
