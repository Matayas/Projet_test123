package gilm10129104.laboratoire8.comparateur;

import gilm10129104.laboratoire8.Personne;

import static gilm10129104.laboratoire8.Constantes.*;
import static gilm10129104.laboratoire8.Constantes.PRENOM;
import static gilm10129104.laboratoire8.Constantes.SEXE;

/**
 * Created by GILM101291 on 2018-03-29.
 */
public class ComparateurSurChamps implements Comparateur{

    private Comparateur comparateur;

    public ComparateurSurChamps(String nomChamp)  {

        switch (nomChamp) {

            case COURRIEL:
                comparateur = new ComparateurCourriel();
                break;
            case DEPARTEMENT:
                comparateur = new ComparateurDepartement();
                break;
            case NAISSANCE:
                comparateur = new ComparateurNaissance();
                break;
            case NOM:
                comparateur = new ComparateurNom();
                break;
            case PRENOM:
                comparateur = new ComparateurPrenom();
                break;
            case SEXE:
                comparateur = new ComparateurSexe();
                break;
        }
    }

    public int comparer(Personne a, Personne b) {
        return  comparateur.comparer(a,b);
    }
}
