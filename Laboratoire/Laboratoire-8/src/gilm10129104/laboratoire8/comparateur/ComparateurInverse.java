package gilm10129104.laboratoire8.comparateur;

import gilm10129104.laboratoire8.Personne;

/**
 * Created by GILM101291 on 2018-03-29.
 */
public class ComparateurInverse implements Comparateur {
    private Comparateur comparateur;

    public ComparateurInverse(Comparateur comparateur) {
        this.comparateur = comparateur;
    }

    public int comparer(Personne a, Personne b) {
        return  comparateur.comparer(a,b) *-1;
    }
}
