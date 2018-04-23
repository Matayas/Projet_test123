package gilm10129104.Laboratoire2.Q1;

import java.time.LocalDate;

/**
 * Created by gilm101291 on 2018-02-06.
 */
public class Application {

public static void main(String[] args)

    {
        Personne p1 = new Personne("Tremblay", "Jean", LocalDate.of(1945,01,02));
        Personne p2 = new Personne("Doe", "John", LocalDate.of(1977,12,03));
        Personne p3 = new Personne("Binette", "Bob", LocalDate.of(2017,02,07));

        p1.afficher();
        p2.afficher();
        p3.afficher();
    }
}




