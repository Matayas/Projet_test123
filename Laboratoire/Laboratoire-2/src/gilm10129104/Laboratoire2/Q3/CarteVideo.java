package gilm10129104.Laboratoire2.Q3;

/**
 * Created by gilm101291 on 2018-02-12.
 */
public class CarteVideo {

    public float prix;
    public String modele;
    public  int memoireRam;

     public void CarteVideo(float prix, String modele, int memoireRam )
     {
         this.prix = prix;
         this.modele = modele;
         this.memoireRam = memoireRam;
     }

    public void afficher()
    {
        System.out.println("Modèle: " + this.modele);
        System.out.println("Mémoire vive: " + this.memoireRam);
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
