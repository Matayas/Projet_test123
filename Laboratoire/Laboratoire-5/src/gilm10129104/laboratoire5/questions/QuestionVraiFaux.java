package gilm10129104.laboratoire5.questions;

import static gilm10129104.laboratoire5.Constantes.REPONSE_INCORECT;

/**
 * Created by gilm101291 on 2018-02-27.
 */
public class QuestionVraiFaux extends Question {

    private boolean reponse;

    public QuestionVraiFaux(String enonce, int ponderation, boolean reponse) {

        super(enonce, ponderation);
        this.reponse = reponse;
    }

    public Resultat evaluer(String reponse) {
        reponse = reponse.toUpperCase().replace("VRAI", "V").replace("FAUX", "F");
        if (reponse.equals("V") || reponse.equals("F")) {
            boolean rep = reponse.equals("V");
            if (rep == this.reponse) {
                return getResultatBonneReponse();
            } else {
                return new Resultat(REPONSE_INCORECT + (this.reponse == true ? "VRAI" : "FAUX"), 0);
            }
        } else {
            return new Resultat("Vous devez repondre Vrai ou Faux", -1);
        }

    }


    public String toString() {
        return "Vrai ou faux ? " + System.lineSeparator() + super.getEnonce();
    }
}
