package gilm10129104.laboratoire9;

import gilm10129104.laboratoire9.commande.Commande;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by GILM101291 on 2018-04-03.
 */
public class Executeur {
    private List<Commande> commandes;
    private List<Commande> executees;

    public Executeur(){
        this.commandes =  new ArrayList<>();
        this.executees = new ArrayList<>();
    }

    public void ajouter(Commande commande) {
        commandes.add(commande);
    }

    public void executer() {
        if (!commandes.isEmpty()) {
            for (Commande c : commandes) {
                c.executer();
                this.executees.add(c);
            }
            commandes.clear();
        }
    }

    public void annuler() {
        if (!commandes.isEmpty()) {
            commandes.clear();
        } else {
            commandes.get(commandes.size() - 1).annuler();
            commandes.remove(commandes.size() - 1);
        }
    }
}
