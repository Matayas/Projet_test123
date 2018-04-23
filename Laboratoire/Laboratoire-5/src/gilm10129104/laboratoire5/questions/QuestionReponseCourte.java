package gilm10129104.laboratoire5.questions;

import static gilm10129104.laboratoire5.Constantes.REPONSE_INCORECT;
import static gilm10129104.laboratoire5.Constantes.REPONSE_VIDE;

/**
 * Created by gilm101291 on 2018-02-27.
 */
public class QuestionReponseCourte extends Question {

    private String reponse;

    public QuestionReponseCourte(String enonce, int ponderation, String reponse) {
        super(enonce, ponderation);
        this.reponse = reponse;
    }

    public Resultat evaluer(String reponse) {

        if (reponse == null) {
            return new Resultat(REPONSE_VIDE, -1);
        } else if (!reponse.equals(this.reponse)) {
            return new Resultat(REPONSE_INCORECT + this.reponse, 0);
        } else {
            return getResultatBonneReponse();
        }
    }
}
