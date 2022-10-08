import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.TimerTask;

public class Game extends JPanel implements KeyListener{
    public static final Color BACKGROUND_COLOR = Color.black;
    public static final int WINDOW_WIDTH = 700;
    public static final int WINDOW_HEIGHT = 700;
    public static final int CAR_WIDTH = 20;
    public static final int CAR_HEIGHT = 30;
    public static final String TRACK_SPRITE_FILENAME = "src\\img\\tracktest.png";
    public static final String CAR_SPRITE_FILENAME = "src\\img\\car.png";

    private Track track;
    private Car player1;
    static boolean up_pressed;
    static boolean down_pressed;
    static boolean left_pressed;
    static boolean right_pressed;


    public Game(){
        super();
        track = new Track(Game.TRACK_SPRITE_FILENAME,true,Game.WINDOW_WIDTH/2, Game.WINDOW_HEIGHT/2);
        player1 = new Car(Game.CAR_SPRITE_FILENAME,track.xstart, track.ystart, 0);
    }



    public static void main(String args[]) {
        Window win = new Window("Racer", WINDOW_WIDTH, WINDOW_HEIGHT);
        java.util.Timer timer = new java.util.Timer();
        Game g = new Game();
        g.setLayout(null);
        g.setBackground(BACKGROUND_COLOR);

        win.add(g);
        win.addKeyListener(g);
        win.setVisible(true);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                g.repaint();
                g.player1.update();
            }
        },0,17);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        track.show(g);
        player1.show(g);
    }
    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP){
            up_pressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            down_pressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right_pressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            left_pressed = true;
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP){
            up_pressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            down_pressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right_pressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            left_pressed = true;
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP){
            up_pressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            down_pressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right_pressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            left_pressed = false;
        }

    }


}
