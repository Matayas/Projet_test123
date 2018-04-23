package gilm10129104.Laboratoire2.Q3;

/**
 * Created by gilm101291 on 2018-02-12.
 */
public class Ordinateur {
    public    CarteVideo carteVideo;
    public    CarteSon carteSon;
    private   Processeur processeur;
    private   CarteMere carteMere;


    public Ordinateur(CarteVideo carteVideo, CarteSon carteSon, Processeur processeur, CarteMere carteMere )
    {
        this.carteVideo = carteVideo;
        this.carteSon = carteSon;
        this.processeur = processeur;
        this.carteMere = carteMere;
    }

    public CarteVideo getCarteVideo()
    {
        return this.carteVideo;
    }

    public  CarteSon getCarteSon()
    {
        return this.carteSon;
    }

    public  Processeur getProcesseur()
    {
        return this.processeur;
    }

    public  CarteMere getCarteMere()
    {
        return this.carteMere;
    }

    public void afficher()
    {
        System.out.println("--------------------");
        System.out.println( "Ordinateur:");
        System.out.println("--------------------");

        System.out.println("Carte Mère : " + this.carteMere);
        this.carteMere.afficher();
        System.out.println("Processeur : " + this.processeur);
        this.processeur.afficher();
        System.out.println("Carte de son : " + this.carteSon);
        this.carteSon.afficher();
        System.out.println("Carte Video : " + this.carteVideo);
        this.carteVideo.afficher();
        System.out.println("--------------------");
        System.out.println("Prix : " + getPrix());

    }

    public float getPrix()
    {
        return this.carteMere.getPrix()+ this.processeur.getPrix()+ this.carteSon.getPrix()+ this.carteVideo.getPrix();
    }

}

