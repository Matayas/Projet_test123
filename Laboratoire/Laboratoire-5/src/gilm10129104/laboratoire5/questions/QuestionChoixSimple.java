package gilm10129104.laboratoire5.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static gilm10129104.laboratoire5.Constantes.MSG_ERR;
import static gilm10129104.laboratoire5.Constantes.MSG_ERR;
import static gilm10129104.laboratoire5.Constantes.REPONSE_INCORECT;

/**
 * Created by gilm101291 on 2018-02-27.
 */
public class QuestionChoixSimple extends Question {

    private List<String> choix;
    private char reponse;

    public QuestionChoixSimple(String enonce, int ponderation, String reponse) {
        super(enonce, ponderation);
        String[] monTableau = reponse.split(",");
        String temp = monTableau[0];
        choix = new ArrayList<>(Arrays.asList(monTableau));
        Collections.shuffle(choix);
        this.reponse = 'A';
        for (int i = 0; i < choix.size(); i++) {
            if (choix.get(i).equals(temp)) {
                break;
            }
            this.reponse++;
        }
    }

    public Resultat evaluer(String reponse) {
        int choixMax = choix.size() + 'A' - 1;
        char lettre = 'Z';
        Resultat resultat = null;
        if (reponse.length() == 1) {
            lettre = reponse.charAt(0);
            if (lettre >= 'A' && lettre <= choixMax) {
                if (lettre == this.reponse) {
                    return getResultatBonneReponse();
                } else {
                    return new Resultat(REPONSE_INCORECT + this.reponse + ")", 0);
                }
            } else {
                return new Resultat(MSG_ERR + (char) choixMax, -1);
            }
        } else {
            return new Resultat(MSG_ERR + (char) choixMax, -1);
        }
    }

    // @formatter:off
    public String toString(){
        return super.getEnonce()+ System.lineSeparator() + "A) "+ this.choix.get(0)+ System.lineSeparator()+
                                                           "B) "+ this.choix.get(1)+ System.lineSeparator()+
                                                           "C) "+ this.choix.get(2)+ System.lineSeparator()+
                                                           "D) " + this.choix.get(3)+System.lineSeparator();
    }
    // @formatter:on
}


