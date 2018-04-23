package gilm10129104.laboratoire4;

import gilm10129104.laboratoire4.peripherique.*;

import java.io.FileNotFoundException;

/**
 * Created by gilm101291 on 2018-02-22.
 */
public class Application {
    public static void main(String[] args) {

        Ordinateur ordiGameur = new Ordinateur();

        CarteGraphique Gtx1080 = new CarteGraphique("Asus", "1080", 899, 8);

        ordiGameur.ajouter(Gtx1080);
        ordiGameur.ajouter(new CarteReseau("Intel", "Wifi++", 129.99, 800));
        ordiGameur.ajouter(new Memoire("G.Skill", "TridentZ", 199.99,16, true));
        ordiGameur.ajouter(new DisqueDur("MG inc", "09823320-A2", 99.99, 1000));
        ordiGameur.ajouter(new Moniteur("Asus", "Rog", 734.99, 24));

        System.out.println(ordiGameur);

        ordiGameur.retirer(Gtx1080);

        System.out.println(ordiGameur);
    }
}