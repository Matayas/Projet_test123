package gilm10129104.laboratoire5.questions;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by gilm101291 on 2018-02-27.
 */
public class Resultat {

    private String message;
    private int pointage;

    protected Resultat(String message, int pointage) {
        this.message = message;
        this.pointage = pointage;
    }

    public int getPointage() {
        return pointage;
    }

    public String toString() {
        return pointage >= 0 ? message + " (" + pointage + ")" : message + System.lineSeparator();
    }
}
