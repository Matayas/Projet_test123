package gilm10129104.laboratoire4.peripherique;

/**
 * Created by gilm101291 on 2018-02-22.
 */
public class CarteReseau extends Peripherique {

    private int vitesseTransfert;

    public CarteReseau(String fabricant, String noModele, double prix,int vitesseTransfert)
    {
        super(fabricant,noModele,prix);
        this.vitesseTransfert = vitesseTransfert;
    }

    public int getVitesseTransfert(){
        return this.vitesseTransfert;
    }

    public String toString(){
        // @formatter:off
        return "Carte Réseau"+  System.lineSeparator() +  super.toString()+
               "Vitesse de transfert     : " + this.vitesseTransfert + System.lineSeparator()+ System.lineSeparator();
        // @formatter:on
    }
}
