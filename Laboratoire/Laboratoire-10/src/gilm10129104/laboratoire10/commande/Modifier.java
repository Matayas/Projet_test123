package gilm10129104.laboratoire10.commande;

import gilm10129104.laboratoire10.personne.Personne;

public class Modifier implements Commande {
    private Personne personne;
    private Personne modifiee;
    private Personne originale;

    public Modifier(Personne personne, Personne modifiee) {
        this.personne = personne;
        this.modifiee = modifiee;
        originale = personne.clone();
    }

    @Override
    public void executer() {
        personne.copy(modifiee);
    }

    @Override
    public void annuler() {
        personne.copy(originale);
    }
}
