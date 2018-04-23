package gilm10129104.laboratoire6;

/**
 * Created by gilm101291 on 2018-03-06.
 */
public abstract class Joueur {

    enum Main{
        ROCHE,PAPIER,CISEAUX
    }
    private String nom;
    private String prenom;

    protected Joueur(String nom,String prenom){
        this.nom = nom;
        this.prenom = prenom;
    }

    public abstract Main choisir();
}
