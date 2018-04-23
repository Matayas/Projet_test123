package gilm10129104.Laboratoire2.Q3;

/**
 * Created by gilm101291 on 2018-02-12.
 */
public class CarteMere {

    public  float prix;
    public String modele;
    public String socket;

    public void CarteMere(float prix, String modele, String socket)
    {
        this.prix = prix;
        this.modele = modele;
        this.socket = socket;
    }

    public void afficher()
    {
        System.out.println("Modèle: " + this.modele );
        System.out.println("Socket: " + this.socket);
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
