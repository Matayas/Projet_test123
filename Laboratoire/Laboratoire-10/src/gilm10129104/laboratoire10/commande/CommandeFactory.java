package gilm10129104.laboratoire10.commande;

public interface CommandeFactory {

    Commande modifier();

    Commande ajouter();

    Commande supprimer();
}
