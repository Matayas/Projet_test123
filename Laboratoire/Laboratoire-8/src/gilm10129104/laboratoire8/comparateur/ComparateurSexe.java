package gilm10129104.laboratoire8.comparateur;

import gilm10129104.laboratoire8.Personne;

/**
 * Created by GILM101291 on 2018-03-27.
 */
public class ComparateurSexe implements Comparateur {
    @Override
    public int comparer(Personne a, Personne b) {
        return a.getSexe().toString().compareTo(b.getSexe().toString());
    }
}