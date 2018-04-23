package gilm10129104.Laboratoire2.Q3;

/**
 * Created by gilm101291 on 2018-02-12.
 */
public class CarteSon {

    public float prix;
    public String modele;
    public int nbCanaux;

    public CarteSon(float prix, String modele, int nbCanaux)
    {
        this.prix = prix;
        this.modele = modele;
        this.nbCanaux = nbCanaux;
    }

    public void afficher()
    {
        System.out.println("Modèle: " + this.modele);
        System.out.println("Nombre de canaux: " + this.nbCanaux);
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

