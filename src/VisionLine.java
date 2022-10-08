import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class VisionLine extends Line2D {
    private double x;
    private double y;
    private double theta;
    private boolean two_sided;



    public VisionLine(double x, double y, double theta, boolean two_sided){
        super();
        this.x = x;
        this.y = y;
        this.theta = theta;
        this. two_sided = two_sided;

    }

    @Override
    public double getX1() {
        return x;
    }

    @Override
    public double getY1() {
        return y;
    }

    @Override
    public Point2D getP1() {
        return new Point2D.Double(x,y);
    }

    @Override
    public double getX2() {
        return 0;
    }

    @Override
    public double getY2() {
        return 0;
    }

    @Override
    public Point2D getP2() {
        return null;
    }

    @Override
    public void setLine(double x1, double y1, double x2, double y2) {
        // ICI
    }


    @Override
    public Rectangle2D getBounds2D() {
        return null;
    }

    public void show(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.YELLOW);
        g2.draw(this);
    }

}
