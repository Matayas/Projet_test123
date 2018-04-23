package gilm10129104.laboratoire11.questions;

import gilm10129104.laboratoire11.Jeu;
import gilm10129104.laboratoire11.trivia.Question;

import java.io.FileInputStream;
import java.util.Scanner;

public class TriviaFactory {

    private Jeu jeu;

    public TriviaFactory(Jeu jeu) {
        this.jeu = jeu;
    }

    private String nextLine(Scanner scanner) {
        String line = scanner.nextLine();
        while (line.trim().startsWith("#") && scanner.hasNext()) {
            line = scanner.nextLine();
        }
        return line;
    }

    public void restaurerQuestions(String fichier) {
        Scanner scanner = null;

        int noQuestion = 0;
        scanner = new Scanner(new FileInputStream(fichier));
        while (scanner.hasNext()) {

            noQuestion++;
            String[] args = new String[4];

            // Le type de la question (choix-simple, v/f ou reponse-courte).
            args[0] = nextLine(scanner);

            // La pondération de la question.
            args[1] = nextLine(scanner);

            // L'énoncé de la question.
            args[2] = nextLine(scanner);

            // La réponse à l'énoncé de la question
            args[3] = nextLine(scanner);

            Question question = creerQuestion(args);
            jeu.ajouter(question);
        }
        scanner.close();
    }

    //    public Question creerQuestion(String[] lignes) throws QuestionInconnueException {
    public Question creerQuestion(String[] lignes) {
        String type = lignes[0];

        // La pondération de la question.
        int ponderation = Integer.parseInt(lignes[1]);

        // L'énoncé de la question.
        String enonce = lignes[2];

        // La réponse à l'énoncé de la question.
        // Dépendant du type de question, on laisse donc le constructeur de la question déterminer comment
        // faire l'analyse syntaxique de la réponse.
        String reponse = lignes[3];

        Question question;
        switch (type) {
            case Constantes.CHOIX_SIMPLE:
                question = new QuestionChoixSimple(enonce, ponderation, reponse);
                break;

            case Constantes.REPONSE_COURTE:
                question = new QuestionReponseCourte(enonce, ponderation, reponse);
                break;

            case Constantes.VRAI_OU_FAUX:
                if (!reponse.equalsIgnoreCase("true") &&
                        !reponse.equalsIgnoreCase("false")) {
                    throw new IllegalArgumentException("True ou False attendu");
                }
                question = new QuestionVraiFaux(enonce, ponderation, Boolean.parseBoolean(reponse));
                break;

            default:
                question = null;
        }
        return question;
    }
}
