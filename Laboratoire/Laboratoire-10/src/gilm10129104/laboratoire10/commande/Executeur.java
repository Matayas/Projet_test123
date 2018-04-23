package gilm10129104.laboratoire10.commande;

import java.util.ArrayList;
import java.util.List;

public class Executeur {
    private List<Commande> commandes = new ArrayList<>();
    private List<Commande> executees = new ArrayList<>();

    public void executer() {
        for (Commande commande : commandes) {
            commande.executer();
            executees.add(commande);
        }
        commandes.clear();
    }

    public void ajouter(Commande commande) {
        if (commande != null) {
            commandes.add(commande);
        }
    }

    public void annuler() {
        if (!commandes.isEmpty()) {
            commandes.clear();
        } else if (!executees.isEmpty()) {
            Commande commande = executees.remove(executees.size() - 1);
            commande.annuler();
        }
    }

    public int enSuspend() {
        return commandes.size();
    }
}
