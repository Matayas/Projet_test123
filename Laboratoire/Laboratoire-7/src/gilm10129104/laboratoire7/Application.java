package gilm10129104.laboratoire7;

import gilm10129104.laboratoire7.comparateur.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static gilm10129104.laboratoire7.Constantes.*;

/**
 * Created by GILM101291 on 2018-03-27.
 */
public class Application {
    public static void main(String[] args)throws FileNotFoundException {

        if (args.length == 0 ) {
            System.out.println("Aucun argument n'as été saisie");
        } else {


            Scanner scanner = new Scanner( new FileInputStream(args[0]));
            List<Personne> personnes = new ArrayList<>();
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                personnes.add(Personne.parsePersonne(line));
            }

            Comparateur comparateur = null;

            switch (args[1]) {

                case COURRIEL:
                    comparateur = new ComparateurCourriel();
                    break;
                case DEPARTEMENT:
                    comparateur = new ComparateurDepartement();
                    break;
                case NAISSANCE:
                    comparateur = new ComparateurNaissance();
                    break;
                case NOM:
                    comparateur = new ComparateurNom();
                    break;
                case PRENOM:
                    comparateur = new ComparateurPrenom();
                    break;
                case SEXE:
                    comparateur = new ComparateurSexe();
                    break;
                    default:
                        System.out.println(" commutateur de tri invalide");
                        return;
            }

            TriBulle triBulle = new TriBulle(comparateur);
            triBulle.trier(personnes);
            System.out.println(String.format("%-20s%-20s%-5s%-10s%-30s%-30s","Prénom","Nom","Âge","Sexe","Département", "Courriel")
                + System.lineSeparator() +
                  String.format("%0115d", 0).replace("0", "-"));

            for(Personne p : personnes){
                System.out.println(p);
            }

        }
    }
}
