package gilm10129104.Laboratoire2.Q2;

/**
 * Created by gilm101291 on 2018-02-06.
 */
public class Application {

    public static void main(String[] args) {
        Cercle c1 = new Cercle();
        Cercle c2 = new Cercle(4, new Point(2,5));
        Cercle c3 = new Cercle(12);
        Cercle c4 = new Cercle(12, new Point(3,4));

        c3.deplacer(10,11);
        c4.deplacer(2,3);

    }

}
