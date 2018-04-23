package gilm10129104.laboratoire11.questions;

import gilm10129104.laboratoire11.trivia.Question;
import gilm10129104.laboratoire11.trivia.Resultat;

import static gilm10129104.laboratoire11.questions.Constantes.MESSAGE_BONNE_REPONSE;

public class QuestionReponseCourte extends Question {
    private String reponse;

    public QuestionReponseCourte(String enonce, int ponderation, String reponse) {
        super(enonce, ponderation);
        this.reponse = reponse;
    }

    public Resultat evaluer(String reponse)  {
        Resultat resultat;
        if (!this.reponse.equalsIgnoreCase(reponse)) {
            resultat = new Resultat("La bonne réponse est " + this.reponse, 0);
        } else {
            resultat = new Resultat(MESSAGE_BONNE_REPONSE, getPonderation());
        }
        return resultat;
    }
}
