package gilm10129104.laboratoire10.basedonees;

import gilm10129104.laboratoire10.personne.Personne;

import java.io.FileNotFoundException;

public interface BaseDonnees {
    void sauvegarder(String fichier);

    void charger(String fichier, boolean ignorerMauvaisesDonnees);

    void afficher();

    Personne rechercher(long id);
}
