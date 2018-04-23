package gilm10129104.laboratoire11.trivia;

public class Resultat {
    private int pointage;
    private String message;

    public Resultat(String message, int pointage) {
        this.pointage = pointage;
        this.message = message;
    }

    public int getPointage() {
        return pointage;
    }

    @Override
    public String toString() {
        String txtPoints = pointage > 1 ? " points" : " point";
        return message + (pointage >= 0 ? " (" + pointage + txtPoints + ")" : "");
    }
}
