package gilm10129104.laboratoire4.peripherique;

import javax.sound.midi.Soundbank;

/**
 * Created by gilm101291 on 2018-02-22.
 */
public class Peripherique {

    protected String fabricant;
    protected String noModele;
    protected double prix;

    protected Peripherique(String fabricant, String noModele, double prix) {
        this.fabricant = fabricant;
        this.noModele = noModele;
        this.prix = prix;
    }

    public double getPrix() {
        return this.prix;
    }

    public String getNoModele() {
        return this.noModele;
    }

    public String getFabricant() {
        return this.fabricant;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    public String toString() {
        // @formatter:off
        return "Fabriquant               : " + this.fabricant+System.lineSeparator()+
               "No Modele                : " + this.noModele+System.lineSeparator()+
               "Prix                     : " + this.prix+System.lineSeparator();
        // @formatter:on
    }
}
