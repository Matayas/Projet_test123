package gilm10129104.laboratoire4.peripherique;

/**
 * Created by gilm101291 on 2018-02-22.
 */
public class DisqueDur extends Peripherique {

    private int capacite;

    public DisqueDur(String fabricant, String noModele, double prix,int capacite)
    {
        super(fabricant,noModele,prix);
        this.capacite = capacite;
    }

    public int getCapacite() {
        return this.capacite;
    }

    public String toString(){
        // @formatter:off
        return "Disque dur"+  System.lineSeparator() +  super.toString()+
               "Capacite                 : " + this.capacite + System.lineSeparator()+ System.lineSeparator();
        // @formatter:on
    }
}
