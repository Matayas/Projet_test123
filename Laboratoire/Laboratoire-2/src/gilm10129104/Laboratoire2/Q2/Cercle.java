package gilm10129104.Laboratoire2.Q2;

/**
 * Created by gilm101291 on 2018-02-06.
 */
public class Cercle {

    public Point centre;
    private double rayon;


    public Cercle() {

        this(1);
    }

    public Cercle(double rayon) {

        this(rayon ,new Point());

    }

    public Cercle(double rayon,Point centre) {

        this.setRayon(rayon);
        this.centre = centre;
    }



    public void setRayon(double rayon)
    {

        if (rayon > 0) {
            this.rayon = rayon;
        } else {
            this.rayon = 1.0;
        }
    }


    public Point getCentre()
    {
        return this.centre;
    }

    public double getRayon()
    {
        return this.rayon;
    }

    public double getAire()
    {
        return Math.PI*(rayon*rayon) ;
    }

    public double getCirconference()
    {
        return Math.PI * 2 * rayon;
    }

    public void deplacer(double dx , double dy)
    {
       this.centre.deplacer(dx,dy);
    }
}
