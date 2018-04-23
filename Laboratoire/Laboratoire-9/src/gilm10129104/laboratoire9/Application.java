package gilm10129104.laboratoire9;

import java.io.FileNotFoundException;

import static gilm10129104.laboratoire9.Constantes.*;

/**
 * Created by GILM101291 on 2018-04-03.
 */
public class Application {

    public static void main(String[] args) throws FileNotFoundException {

        BaseDonnees bd = new BaseDonnees();
        Executeur exe = new Executeur();

        System.out.println("Les commandes sont : " + System.lineSeparator() +
            "Ajouter, Supprimer, modifier, annuler, executer, afficher" + System.lineSeparator() +
            "CTRL-D pour quitter");

        System.out.println("Saisir votre commande");
        System.out.print(">");

        while (Clavier.getInstance().hasNext()) {
            String commande = Clavier.getInstance().nextLine().toUpperCase();
            System.out.println(" ");
            switch (commande) {
                case AJOUTER:
                   exe.ajouter(bd.ajouter());
                    break;
                case SUPPRIMER:
                    bd.supprimer();
                    break;
                case MODIFIER:
                    break;
                case ANNULER:
                    exe.annuler();
                    break;
                case EXECUTER:
                    exe.executer();
                    break;
                case AFFICHER:
                    boolean msg = bd.afficher();
                    if (!msg) {
                        System.out.println("La base de données est vide");
                    }
            }
            System.out.println("Saisir votre commande");
            System.out.print(">");
        }


    }

}
