package gilm10129104.laboratoire4.peripherique;

/**
 * Created by gilm101291 on 2018-02-22.
 */
public class CarteGraphique extends Peripherique {

    private int memoire;

    public CarteGraphique(String fabricant, String noModele, double prix,int memoire)
    {
        super(fabricant,noModele,prix);
        this.memoire = memoire;
    }

    public int getMemoire(){
        return this.memoire;
    }


    public String toString(){
        // @formatter:off
        return "Carte Graphique"+ System.lineSeparator() +  super.toString()+
               "Memoire                  : " + this.memoire + System.lineSeparator()+ System.lineSeparator();
        // @formatter:on
    }
}
