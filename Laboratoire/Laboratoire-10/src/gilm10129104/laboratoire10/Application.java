package gilm10129104.laboratoire10;

import gilm10129104.laboratoire10.basedonees.BaseDonneesSimple;
import gilm10129104.laboratoire10.commande.Executeur;

public class Application {

    public static void main(String[] args) {

        try {
            BaseDonneesSimple bd = new BaseDonneesSimple();

            Console.getInstance().println("Les commandes sont: ");
            Console.getInstance().println(" ajouter, supprimer, modifier, annuler, parse");
            Console.getInstance().println(" CTRL-D pour quitter");

            Console.getInstance().println();
            Console.getInstance().print("(saisir votre commande) > ");

            Shell shell = new Shell(bd, new Executeur(), bd);


            // Le programme ne devrait planter dans aucun cas. Assurez-vous d'ajouter les gestionnaires d'exceptions
            // nécessaires. Faites-en sorte que les exceptions capturées soient précises de façon à indiquer une message
            // clair à l'utilisateur. Assurez-vous également de tout capturer pour ne pas laisser fuir une exception vers
            // la machine virtuelle qui ferait planter votre programme.
            while (Clavier.getInstance().hasNext()) {
                try{
                String ligne = Clavier.getInstance().nextLine();
                shell.parse(ligne);
                Console.getInstance().println();
                Console.getInstance().print("(saisir votre commande) > ");
            }catch(CommandeException e) {
                    System.out.println("Message( : " + e.getMessage());
                }
            Console.getInstance().println("Au revoir!");
        }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
