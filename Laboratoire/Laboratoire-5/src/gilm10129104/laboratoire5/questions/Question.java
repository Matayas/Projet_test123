package gilm10129104.laboratoire5.questions;


import static gilm10129104.laboratoire5.Constantes.REPONSE_VALIDE;

/**
 * Created by gilm101291 on 2018-02-27.
 */
public class Question {

    private String enonce;
    private int ponderation;
    private static String msgOk = REPONSE_VALIDE;

    protected Question(String enonce, int ponderation) {
        this.enonce = enonce;
        this.ponderation = ponderation;
    }

    protected Resultat getResultatBonneReponse() {
        return new Resultat(msgOk, this.ponderation);
    }


    public String getEnonce() {
        return enonce;
    }

    public int getPonderation() {
        return ponderation;
    }

    public String toString() {
        return enonce;
    }


}

