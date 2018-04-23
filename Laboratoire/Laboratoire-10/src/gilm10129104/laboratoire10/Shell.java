package gilm10129104.laboratoire10;

import gilm10129104.laboratoire10.basedonees.BaseDonnees;
import gilm10129104.laboratoire10.commande.CommandeFactory;
import gilm10129104.laboratoire10.commande.Executeur;

public class Shell {
    private static final String AJOUTER = "ajouter";
    private static final String SUPPRIMER = "supprimer";
    private static final String AFFICHER = "afficher";
    private static final String MODIFIER = "modifier";
    private static final String ANNULER = "annuler";
    private static final String EXECUTER = "executer";
    private static final String SAUVEGARDER = "sauvegarder";
    private static final String CHARGER = "charger";
    private static final String HELP = "?";


    private BaseDonnees baseDonnees;
    private Executeur executeur;
    private CommandeFactory commandes;

    public Shell(BaseDonnees baseDonnees, Executeur executeur, CommandeFactory commandes) {
        this.baseDonnees = baseDonnees;
        this.executeur = executeur;
        this.commandes = commandes;
    }

    public void parse(String ligne) throws CommandeException {
        String[] tokens = ligne.trim().split(" ");

        switch (tokens[0].toLowerCase()) {
            case AJOUTER:
                executeur.ajouter(commandes.ajouter());
                break;
            case SUPPRIMER:
                executeur.ajouter(commandes.supprimer());
                break;
            case AFFICHER:
                baseDonnees.afficher();
                break;
            case MODIFIER:
                executeur.ajouter(commandes.modifier());
                break;
            case ANNULER:
                executeur.annuler();
                break;
            case EXECUTER:
                executeur.executer();
                break;
            case SAUVEGARDER:
                break;
            case CHARGER:

                baseDonnees.charger(tokens[1],(tokens[2]=="ignorer-erreurs"));
                break;
            case HELP:
                Console.getInstance().println(executeur.enSuspend() + " commande(s) en suspend");
                break;
            default:
                throw new CommandeException("Commande inconnue");
        }
    }
}
