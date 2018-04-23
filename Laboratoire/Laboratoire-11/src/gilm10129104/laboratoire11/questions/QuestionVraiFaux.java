package gilm10129104.laboratoire11.questions;

import gilm10129104.laboratoire11.trivia.Question;
import gilm10129104.laboratoire11.trivia.Resultat;

public class QuestionVraiFaux extends Question {

    private boolean reponse;

    public QuestionVraiFaux(String enonce, int ponderation, boolean reponse) {
        super("Vrai ou faux ? " + System.lineSeparator() + enonce, ponderation);
        this.reponse = reponse;
    }

    public Resultat evaluer(String reponse)  {
        reponse = reponse.toUpperCase().replace("VRAI", "V")
                .replace("FAUX", "F");

        if (reponse.equals("V") || reponse.equals("F")) {
            Resultat resultat;
            boolean rep = "V".equals(reponse);
            if (rep == this.reponse) {
                resultat = new Resultat(Constantes.MESSAGE_BONNE_REPONSE, getPonderation());
            } else {
                resultat = new Resultat("La bonne réponse est : " +
                        (this.reponse ? "Vrai" : "Faux"), 0);
            }
            return resultat;
        } else {
            return null;
        }
    }
}
