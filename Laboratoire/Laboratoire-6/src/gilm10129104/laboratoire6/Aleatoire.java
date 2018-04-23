package gilm10129104.laboratoire6;

import java.util.Date;
import java.util.Random;

public class Aleatoire {
    private Random random;
    private static Aleatoire instance = new Aleatoire();

    public static Aleatoire getInstance() {
        return instance;
    }

    private Aleatoire() {
        random = new Random();
        random.setSeed(new Date().getTime());
    }

    public int nextInt(int bound) {
        return random.nextInt(bound);
    }
}
