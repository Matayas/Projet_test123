package gilm10129104.laboratoire11.questions;

import gilm10129104.laboratoire11.trivia.Question;
import gilm10129104.laboratoire11.trivia.Resultat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static gilm10129104.laboratoire11.questions.Constantes.MESSAGE_BONNE_REPONSE;

public class QuestionChoixSimple extends Question {
    private char reponse;
    private List<String> choix;

    public QuestionChoixSimple(String enonce, int ponderation, String reponses) {
        super(enonce, ponderation);

        choix = new ArrayList<>(Arrays.asList(reponses.split(",")));

        // La réponse est toujours le premier choix.
        String reponse = choix.get(0);
        Collections.shuffle(choix);

        char c = 'A';
        for (int i = 0, j = 0; i < choix.size(); i++, c++) {
            if (choix.get(i).equals(reponse)) {
                this.reponse = c;
                break;
            }
        }
    }

    public String toString() {
        String choix = "";

        // numéroter les choix de A à ... et construire la chaîne de caractères des choix, un par ligne.
        char numerotation = 'A';
        for (String elem : this.choix) {
            choix += numerotation++ + " - " + elem + System.lineSeparator();
        }

        // on doit retirer le dernier saut de ligne résiduel.
        choix = choix.substring(0, choix.length() - System.lineSeparator().length());

        // l'énoncé est constitué du texte est des choix.
        return super.toString() + System.lineSeparator() + choix;
    }

    public Resultat evaluer(String reponse) {
        String msgErr = "Vous devez spécifier un choix parmi A-" + (char) (choix.size() + 'A' - 1);

        char lettre = reponse.toUpperCase().charAt(0);
        Resultat resultat;
        if (lettre == this.reponse) {
            resultat = new Resultat(MESSAGE_BONNE_REPONSE, getPonderation());
        } else {
            int pointage = 0;
            String msg = "La bonne réponse est " + this.reponse + ") " + choix.get(this.reponse - 'A');
            resultat = new Resultat(msg, pointage);
        }
        return resultat;
    }
}
