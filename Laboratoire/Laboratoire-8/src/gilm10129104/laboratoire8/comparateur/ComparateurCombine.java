package gilm10129104.laboratoire8.comparateur;

import gilm10129104.laboratoire8.Personne;

/**
 * Created by GILM101291 on 2018-03-29.
 */
public class ComparateurCombine implements Comparateur {
    private Comparateur comparateurA;
    private Comparateur comparateurB;

    public ComparateurCombine(Comparateur comparateurA, Comparateur comparateurB) {
        this.comparateurA = comparateurA;
        this.comparateurB = comparateurB;
    }

    public int comparer(Personne a, Personne b) {
        int diff = comparateurA.comparer(a, b);
        if (diff == 0) {
            diff = comparateurB.comparer(a, b);
        }
        return diff;
    }
}
