package gilm10129104.laboratoire4.peripherique;

/**
 * Created by gilm101291 on 2018-02-22.
 */
public class Moniteur extends Peripherique{

    private int taille;

    public Moniteur(String fabricant, String noModele, double prix, int taille) {
        super(fabricant, noModele, prix);
        this.taille = taille;
    }

    public int getTaille() {
        return taille;
    }

    public String toString(){
        // @formatter:off
        return "Moniteur"+  System.lineSeparator() +  super.toString()+
               "Taille                   : " + this.taille + System.lineSeparator()+ System.lineSeparator();
        // @formatter:on
    }
}
