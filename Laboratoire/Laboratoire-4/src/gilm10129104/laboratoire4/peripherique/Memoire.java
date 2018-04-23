package gilm10129104.laboratoire4.peripherique;

/**
 * Created by gilm101291 on 2018-02-22.
 */
public class Memoire extends Peripherique {
    private int capacite;
    private boolean correctionErreur;

    public Memoire(String fabricant, String noModele, double prix,int capacite,boolean correctionErreur)
    {
        super(fabricant,noModele,prix);
        this.correctionErreur = correctionErreur;
    }

    public int getCapacite(){
        return this.capacite;
    }

    public String getCorrectionErreur(){
       return  (this.correctionErreur==true ? "Oui" : "Non");
    }
    public String toString(){
        // @formatter:off
        return "Mémoire Vive"+  System.lineSeparator() + super.toString()+
               "Capacité                 : " + this.capacite + System.lineSeparator()+
               "Correction d'erreur      : " + this.getCorrectionErreur() + System.lineSeparator()+ System.lineSeparator();
        // @formatter:on
    }
}
