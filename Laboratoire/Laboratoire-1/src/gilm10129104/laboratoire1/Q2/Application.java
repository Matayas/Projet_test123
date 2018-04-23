package gilm10129104.laboratoire1.Q2;

import sun.security.util.BitArray;

/**
 * Created by gilm101291 on 2018-02-01.
 */
public class Application {

    public static void main(String[] args) {

        if (args.length <= 0) System.out.println("Aucun nombre n'a été saisie !!!");

        else {

            for (int i = 0; i < args.length; i++) {
                int n = Integer.parseInt(args[i]);
                boolean trame[] = obtenirTrame(n);
                for (int j = 0; j < trame.length; j++) {
                    System.out.print(trame[j] ? "1" : "0");
                }
                System.out.println();
            }
        }
    }

    public static boolean[] obtenirTrame(int nombre) {
        boolean[] trame = new boolean[32];

        for (int i = 0, j = 0; i < 32; j <<= 1) {
            trame[i] = (nombre & j) != 0;
        }

        return trame;
    }
}

