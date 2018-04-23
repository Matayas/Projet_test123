package gilm10129104.laboratoire11;

import gilm10129104.laboratoire11.trivia.Trivia;
import gilm10129104.laboratoire11.questions.TriviaFactory;

public class Application {
    public static void main(String[] args) {
        // Initialiser les instances globales de Clavier et de Console.
        // Ces instances permettent de remplacer les System.out et System.in par défaut.
        // On continue d'utiliser System.out et System.in néanmoins normalement.
        Clavier.getInstance();
        Console.getInstance();

        boolean demanderFichier = args.length == 0;
        System.out.println("Bienvenu dans le jeu Trivia!");
        System.out.println("Pour quitter, appuyez conjointement sur CTRL-D");
        String fichier = null;
        if (demanderFichier) {
            fichier = Clavier.getInstance().nextLineNotEmpty("Indiquez le chemin du fichier contenant les questions > ");
        } else {
            fichier = args[0];
        }
        Jeu jeu = new Trivia();
        new TriviaFactory(jeu).restaurerQuestions(fichier);
        float resultat = jeu.jouer();
        System.out.println();
        System.out.println("Votre résultat : " + Math.round(resultat * 100) + "%");
        System.out.println("Au revoir!");
    }
}
