package gilm10129104.laboratoire8.comparateur;

import gilm10129104.laboratoire8.Personne;

/**
 * Created by GILM101291 on 2018-03-27.
 */
public class ComparateurNom implements Comparateur {

    @Override
    public int comparer(Personne a, Personne b) {
        return  a.getNom().compareTo(b.getNom());
    }
}
