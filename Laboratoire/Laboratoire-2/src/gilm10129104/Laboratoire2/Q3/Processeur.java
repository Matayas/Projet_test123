package gilm10129104.Laboratoire2.Q3;

/**
 * Created by gilm101291 on 2018-02-12.
 */
public class Processeur {


    public float prix;
    public String modele;
    public double cadence;
    public int nbCoeur;

    public void Processeur(float prix, String modele, double cadence, int nbCoeur)
    {
        this.prix =prix;
        this.modele = modele;
        this.cadence = cadence;
        this.nbCoeur = nbCoeur;
    }

    public void afficher()
    {
        System.out.println("Modèle: " + this.modele);
        System.out.println("Cadence: " + this.cadence);
        System.out.println("Nombre de coeur: " + this.nbCoeur);
        System.out.println("Prix: " + this.prix);
    }

    public float getPrix()
    {
        return this.prix;
    }

    public void setPrix(float prix)
    {
        this.prix = prix;
    }
}
