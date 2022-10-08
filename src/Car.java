import javax.sound.sampled.Line;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class Car {
    public static double ROTATE_VELOCITY = 0.07;
    public static double ACCELERATION = 0.5;
    public static double MAX_VELOCITY = 4;
    public static int VISION_LINE_N = 5;
    protected double x;
    protected double y;
    protected double vx;
    protected double vy;
    protected double ax;
    protected double ay;
    protected int width;
    protected int height;
    protected double theta;
    protected ArrayList<VisionLine> vision_lines;
    protected Rectangle2D hitbox;
    protected BufferedImage carImage;


    public Car(String filename, double x, double y,double theta) {
        //this.carImage = ImageIO.read(new File(filename)); Throw IOException
        this.x = x;
        this.y = y;
        this.theta = theta;
        this.width = Game.CAR_WIDTH;
        this.height = Game.CAR_HEIGHT;
        this.hitbox = new Rectangle(0,0,width,height);
        for (int i = 0; i < VISION_LINE_N ; i++){

        }
    }

    public void update(){
        x += vx;
        y += vy;
        if (Game.up_pressed){
            //this.move(VELOCITY,true); Slow mode
            this.accelerate(ACCELERATION, true);
        }
        if (Game.down_pressed){
            //this.move(VELOCITY, false); same
            this.accelerate(ACCELERATION, false);
        }
        if (Game.right_pressed){
            this.rotate(ROTATE_VELOCITY,false);
        }
        if (Game.left_pressed){
            this.rotate(ROTATE_VELOCITY,true);
        }

    }

    public void rotate(double velocity, boolean dir){
        if (dir) {
            theta = (theta + velocity) % (2 * Math.PI);
        }
        else{
            theta = (theta - velocity) % (2 * Math.PI);
        }


    }

    public void move(double velocity, boolean dir){
        if (dir) {
            x -= velocity * Math.sin(theta);
            y -= velocity * Math.cos(theta);
        }
        else {
            x += velocity * Math.sin(theta);
            y += velocity * Math.cos(theta);
        }
    }

    public void accelerate(double acceleration, boolean dir){
        if (dir) {
            if (vx < MAX_VELOCITY && vy < MAX_VELOCITY) {
                vx -= acceleration * Math.sin(theta);
                vy -= acceleration * Math.cos(theta);
            }
        }
        else {
            if (vx < MAX_VELOCITY && vy < MAX_VELOCITY) {
                vx += acceleration * Math.sin(theta);
                vy += acceleration * Math.cos(theta);
            }
        }
    }

    public void show(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        int msc = (int) (height*Math.cos(theta)/2);
        int mss = (int) (height*Math.sin(theta)/2);

        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(width));
        //g.drawLine((int) (x - size*Math.sin(theta)),(int) (y - size*Math.cos(theta)),(int) (x + size*Math.sin(theta)),(int) (y + size*Math.cos(theta)));
        g2.draw(new Line2D.Double((int) x - mss,(int) y - msc, (int) x + mss, (int) y + msc));

    }



    public void show_vision(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

    }

}
