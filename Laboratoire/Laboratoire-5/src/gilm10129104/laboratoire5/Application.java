package gilm10129104.laboratoire5;

import java.io.FileNotFoundException;

/**
 * Created by gilm101291 on 2018-02-27.
 */
public class Application {

    public static void main(String[] args) throws FileNotFoundException {

        Trivia jeu = new Trivia(args[0]);
        jeu.jouer();
    }
}
