package gilm10129104.laboratoire8;


import gilm10129104.laboratoire8.comparateur.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static gilm10129104.laboratoire8.Constantes.*;

/**
 * Created by GILM101291 on 2018-03-27.
 */
public class Application {
    public static void main(String[] args) throws FileNotFoundException {

        if (args.length == 0) {
            System.out.println("Aucun argument n'as été saisie");
        } else {


            Scanner scanner = new Scanner(new FileInputStream(args[0]));
            List<Personne> personnes = new ArrayList<>();
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                personnes.add(Personne.parsePersonne(line));
            }


            Comparateur comparateur = new ComparateurNoOp();
            String sens;

            for (int i = 1; i < args.length; i++) {
                String[] jetons = args[i].trim().toLowerCase().split(":");
                String champs = jetons[0];
                sens = (jetons.length == 1 ? "asc" : jetons[1]);
                Comparateur comparateurB = new ComparateurSurChamps(champs);
                if (sens.equals("desc")) {
                    comparateurB = new ComparateurInverse(comparateurB);
                }
                comparateur = new ComparateurCombine(comparateur, comparateurB);
            }


            TriBulle triBulle = new TriBulle(comparateur);
            triBulle.trier(personnes);
            System.out.println(String.format("%-20s%-20s%-5s%-10s%-30s%-30s", "Prénom", "Nom", "Âge", "Sexe", "Département", "Courriel")
                + System.lineSeparator() +
                String.format("%0115d", 0).replace("0", "-"));

            for (Personne p : personnes) {
                System.out.println(p);
            }

        }
    }
}
