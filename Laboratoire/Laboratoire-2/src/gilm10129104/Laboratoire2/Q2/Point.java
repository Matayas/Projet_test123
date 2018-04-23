package gilm10129104.Laboratoire2.Q2;

/**
 * Created by gilm101291 on 2018-02-06.
 */
public class Point {

    double x;
    double y;

    public Point()
    {
      this(0,0);
    }
     public  Point(double x,double y)
     {
         this.x = x;
         this.y = y;
     }
    public double getX()
    {
        return this.x;
    }

    public double getY()
    {
        return this.y;
    }

    public void deplacer(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }
}
