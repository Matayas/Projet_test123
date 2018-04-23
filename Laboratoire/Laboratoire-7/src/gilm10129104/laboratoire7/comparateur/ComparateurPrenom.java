package gilm10129104.laboratoire7.comparateur;

import gilm10129104.laboratoire7.Personne;

/**
 * Created by GILM101291 on 2018-03-27.
 */
public class ComparateurPrenom implements Comparateur {
    @Override
    public int comparer(Personne a, Personne b) {
        return  a.getPrenom().compareTo(b.getPrenom());
    }
}
