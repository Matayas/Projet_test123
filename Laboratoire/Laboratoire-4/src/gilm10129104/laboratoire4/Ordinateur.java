package gilm10129104.laboratoire4;

import gilm10129104.laboratoire4.peripherique.Peripherique;

import java.util.Arrays;

/**
 * Created by gilm101291 on 2018-02-22.
 */
public class Ordinateur {

    private Peripherique[] peripherique;
    private int cpt = 0;

    public Ordinateur() {
        this.peripherique = new Peripherique[0];
    }

    public double getPrix() {
        double prixTotal = 0;
        for (Peripherique cv : this.peripherique) {
            if(cv!=null) prixTotal += cv.getPrix();
        }
        return prixTotal;
    }

    public void ajouter(Peripherique peripherique) {
        if (this.peripherique.length == cpt) {
            this.peripherique = Arrays.copyOf(this.peripherique, cpt + 10);
        }
        this.peripherique[cpt] = peripherique;
        cpt++;
    }

    public void retirer(Peripherique peripherique) {
        for (int i = 0; i < this.peripherique.length; i++) {
            if (this.peripherique[i] == peripherique) {
                this.peripherique[i] = this.peripherique[this.peripherique.length - 1];
            }
        }
    }

    public String toString() {
        String chaine = "Ordinateur :" + System.lineSeparator()+System.lineSeparator();
        for (Peripherique cv : this.peripherique) {
            if (cv != null)
                chaine += cv.toString();
        }
        chaine += System.lineSeparator() + this.getPrix()+System.lineSeparator();

        return chaine;
    }

}
