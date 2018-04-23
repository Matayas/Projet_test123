package gilm10129104.laboratoire11.trivia;

import gilm10129104.laboratoire11.Clavier;
import gilm10129104.laboratoire11.Jeu;
import gilm10129104.laboratoire11.ReponseInvalideException;

import java.util.ArrayList;
import java.util.List;

public class Trivia implements Jeu {
    private int pointage = 0;
    private int total = 0;

    private List<Question> questions = new ArrayList<>();

    @Override
    public void ajouter(Question question) {
        questions.add(question);
    }

    private void poser(Question question) {
        boolean validInput = false;
        do {
            System.out.println();
            System.out.println(question);
            total += question.getPonderation();
            String reponse = Clavier.getInstance().nextLineNotEmpty("> ");
            try {
                Resultat resultat = question.evaluer(reponse);
                System.out.println(resultat);
                pointage += resultat.getPointage();
            } catch (ReponseInvalideException e) {

            }
        }while(!validInput);
    }

    @Override
    public float jouer() {
        for (Question question : questions) {
            poser(question);
        }
        return pointage / (float) total;
    }
}
