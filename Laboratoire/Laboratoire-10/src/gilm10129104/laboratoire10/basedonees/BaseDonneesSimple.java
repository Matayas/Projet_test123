package gilm10129104.laboratoire10.basedonees;

import gilm10129104.laboratoire10.Clavier;
import gilm10129104.laboratoire10.commande.*;
import gilm10129104.laboratoire10.personne.Personne;
import gilm10129104.laboratoire10.personne.PersonneFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class BaseDonneesSimple implements CommandeFactory, PersonneFactory, BaseDonnees {

    private Set<Personne> personnes = new TreeSet<>();

    private static boolean demanderOuiNon(String message) {
        String saisie;
        do {
            gilm10129104.laboratoire10.Console.getInstance().print(message + "? > ");
            saisie = Clavier.getInstance().nextLine().toUpperCase()
                .replace("OUI", "O")
                .replace("NON", "N");
        } while (!saisie.equals("N") && !saisie.equals("O"));
        return "O".equals(saisie);
    }

    @Override
    public void sauvegarder(String fichier) {

        File monFichier = new File(fichier);
        String reponse = null;
        if (monFichier.exists()) {
            System.out.println("Le fichier existe déja voulez-vous l'écraser ? (OUI/NON)");
            reponse = Clavier.getInstance().nextLine().toUpperCase();
        }

        if (reponse.equals("OUI")) {
            return;
        } else {
            try {
                PrintWriter monWriter = new PrintWriter(new File(fichier));
                for (Personne p : personnes) {
                    monWriter.println(p.serialise());
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }


    @Override
    public void charger(String fichier, boolean ignorerMauvaisesDonnees) {
        try {
            Scanner monScanner = new Scanner(new FileInputStream(fichier));
            while (monScanner.hasNextLine()) {
                String ligne = monScanner.nextLine();
                String[] tokens = ligne.trim().split(",");
                boolean unique = personnes.add(new Personne(Long.parseLong(tokens[0]), tokens[1], tokens[2], Personne.Sexe.valueOf(tokens[3])));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Personne creer(Personne prototype) {

        gilm10129104.laboratoire10.Console.getInstance().print("Nom (" + prototype.getNom() + "): ");
        String nom = Clavier.getInstance().nextLineOrDefault(prototype.getNom());
        gilm10129104.laboratoire10.Console.getInstance().print("Prénom (" + prototype.getPrenom() + "): ");
        String prenom = Clavier.getInstance().nextLineOrDefault(prototype.getPrenom());
        Personne.Sexe sexe = null;
        boolean validInput = false;

        do {
            try {
                gilm10129104.laboratoire10.Console.getInstance().print("Sexe (" + prototype.getSexe() + "): ");
                sexe = Personne.Sexe.valueOf(Clavier.getInstance().nextLineOrDefault(prototype.getSexe().toString()));
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Message : " + "Le sexe doit être dans le format Homme/Femme");
            }

        } while (!validInput);
        return new Personne(nom, prenom, sexe);
    }

    @Override
    public Personne creer() {
        String nom = Clavier.getInstance().nextLineNotEmpty("Nom: ");
        String prenom = Clavier.getInstance().nextLineNotEmpty("Prénom: ");
        Personne.Sexe sexe = null;
        boolean validInput = false;
        do {
            try {
                sexe = Personne.Sexe.valueOf(Clavier.getInstance().nextLineNotEmpty("Sexe: "));
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Message : " + "Le sexe doit être dans le format Homme/Femme");
            }
        } while (!validInput);
        return new Personne(nom, prenom, sexe);
    }

    @Override
    public Commande ajouter() {
        Personne personne = creer();
        return new Ajouter(personne, personnes);
    }

    @Override
    public void afficher() {
        gilm10129104.laboratoire10.Console.getInstance().println();
        if (personnes.isEmpty()) {
            gilm10129104.laboratoire10.Console.getInstance().println("La base de données est vide");
            return;
        }
        gilm10129104.laboratoire10.Console.getInstance().println(String.format("%-3s%-20s%-20s%-10s", "id", "prenom", "nom", "sexe"));
        for (Personne p : personnes) {
            gilm10129104.laboratoire10.Console.getInstance().println(p);
        }
        gilm10129104.laboratoire10.Console.getInstance().println(personnes.size() + " personne(s)");
        gilm10129104.laboratoire10.Console.getInstance().println();
    }

    @Override
    public Personne rechercher(long id) {
        Personne personne = null;
        for (Personne p : personnes) {
            if (p.getId() == id) {
                personne = p;
                break;
            }
        }
        if (personne == null) {
            gilm10129104.laboratoire10.Console.getInstance().println("personne non trouvée");
            return null;
        } else {
            return personne;
        }
    }

    private Personne demanderEtRechercher() {
        boolean validInput = false;
        long id=0;
        do {
            try {
                gilm10129104.laboratoire10.Console.getInstance().print("Indiquez le numéro d'id > ");
                id = Long.parseLong(Clavier.getInstance().nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Message : " + "ID doit être un nombre entier");
            }
        } while (!validInput);
        return rechercher(id);
    }

    @Override
    public Commande supprimer() {
        Personne personne = demanderEtRechercher();
        if (personne == null) {
            return null;
        }
        return new Supprimer(personne, personnes);
    }

    @Override
    public Commande modifier() {
        Personne personne = demanderEtRechercher();
        if (personne == null) {
            return null;
        }
        Personne modifiee = creer(personne);
        return new Modifier(personne, modifiee);
    }


}
