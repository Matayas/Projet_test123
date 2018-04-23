package gilm10129104.laboratoire10.commande;

import gilm10129104.laboratoire10.personne.Personne;

import java.util.Collection;

public class Supprimer implements Commande {
    private Personne personne;
    private Collection<Personne> personnes;

    public Supprimer(Personne personne, Collection<Personne> personnes) {
        this.personne = personne;
        this.personnes = personnes;
    }
    @Override
    public void executer() {
        personnes.remove(personne);
    }

    @Override
    public void annuler() {
        personnes.add(personne);
    }
}
