package gilm10129104.laboratoire11.trivia;

public abstract class Question {
    private int ponderation;
    private String enonce;

    protected Question(String enonce, int ponderation) {
        this.ponderation = ponderation;
        this.enonce = enonce;
    }

    public int getPonderation() {
        return ponderation;
    }

    @Override
    public String toString() {
        String txtPoints = ponderation > 1 ? " points" : " point";
        return enonce + " (" + ponderation + txtPoints + ")";
    }

    public abstract Resultat evaluer(String reponse);
}
