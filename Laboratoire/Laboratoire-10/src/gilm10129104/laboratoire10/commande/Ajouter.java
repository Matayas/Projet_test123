package gilm10129104.laboratoire10.commande;

import gilm10129104.laboratoire10.personne.Personne;

import java.util.Collection;

public class Ajouter implements Commande {

    private Personne personne;
    private Collection<Personne> personnes;

    public Ajouter(Personne personne, Collection<Personne> personnes) {
        this.personne = personne;
        this.personnes = personnes;
    }

    @Override
    public void executer() {
        personnes.add(personne);
    }

    @Override
    public void annuler() {
        personnes.remove(personne);
    }
}
