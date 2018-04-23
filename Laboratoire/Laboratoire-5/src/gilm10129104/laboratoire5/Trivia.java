package gilm10129104.laboratoire5;

import gilm10129104.laboratoire5.questions.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static gilm10129104.laboratoire5.Constantes.CHOIX_SIMPLE;
import static gilm10129104.laboratoire5.Constantes.REPONSE_COURTE;
import static gilm10129104.laboratoire5.Constantes.VRAI_FAUX;

/**
 * Created by gilm101291 on 2018-02-27.
 */
public class Trivia {

    private Scanner clavier;
    private Scanner trivia;
    private int pointage;
    private int total;

    public Trivia(String fichier) throws FileNotFoundException {

        trivia = new Scanner(new FileInputStream(fichier));
    }

    public float getResultat() {
        return 0;
    }

    public void jouer() {

        while (trivia.hasNext()) {
            //Lecture d'un block
            String type = this.nextLine();
            String ponderation = this.nextLine();
            String enonce = this.nextLine();
            String reponse = this.nextLine().toUpperCase();
            //Branchage du type de question
            Question question = null;
            switch (type) {
                case CHOIX_SIMPLE:
                    question = new QuestionChoixSimple(enonce, Integer.parseInt(ponderation), reponse);
                    break;
                case REPONSE_COURTE:
                    question = new QuestionReponseCourte(enonce, Integer.parseInt(ponderation), reponse);
                    break;
                case VRAI_FAUX:
                    question = new QuestionVraiFaux(enonce, Integer.parseInt(ponderation), Boolean.parseBoolean(reponse));
            }
            this.poser(question);
        }
    }

    private void poser(Question question) {
        int total = 0;
        Scanner clavier = new Scanner(System.in);
        System.out.println(question);
        total += this.pointage;
        Resultat resultat = null;
        while (resultat == null || resultat.getPointage() < 0) {
            System.out.println(">");
            String reponse = clavier.nextLine().toUpperCase();
            if (question instanceof QuestionReponseCourte) {
                resultat = ((QuestionReponseCourte) question).evaluer(reponse);
            } else if (question instanceof QuestionChoixSimple) {
                resultat = ((QuestionChoixSimple) question).evaluer(reponse);
            } else if (question instanceof QuestionVraiFaux) {
                resultat = ((QuestionVraiFaux) question).evaluer(reponse);
            }
            System.out.println(resultat);
        }
        this.pointage = resultat.getPointage();
    }

    private String nextLine() {

        String ligne = trivia.nextLine();
        while (ligne.trim().startsWith("#") && trivia.hasNext()) {
            ligne = trivia.nextLine();
        }
        return ligne;
    }
}
