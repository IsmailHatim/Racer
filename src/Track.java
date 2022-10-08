import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static java.awt.image.BufferedImage.*;

public class Track {
    int xstart;
    int ystart;
    static String track_image_filename;
    BufferedImage track_image;
    ArrayList<ArrayList<String>> track_map;
    JLabel tile_label;




    public Track(String filename,boolean pure, int xstart, int ystart) {
        try {
            this.track_image = ImageIO.read(new File(filename));
        } catch (IOException e){
            System.out.println(System.getProperty("user.dir"));
            System.out.println(e);
        }
        this.xstart = xstart;
        this.ystart = ystart;
        this.track_image_filename = filename;
        this.tile_label = new JLabel(new ImageIcon(track_image));
        this.track_map = generate_map_from_image(track_image, pure);

    }

    public void show(Graphics g){
        g.drawImage(track_image,0,0,null);
    }

    public static ArrayList<ArrayList<String>> generate_map_from_image(BufferedImage img, boolean pure){
        ArrayList<ArrayList<String>> map = new ArrayList<>();
        if (!pure){
            //purify by calculating apparent brightness of each pixel
        }
        for (int i = 0; i < img.getWidth(); i++){
            ArrayList<String> line = new ArrayList<>();
            for (int j = 0; j < img.getHeight(); j++){
                Color pix = new Color(img.getRGB(i,j));
                double avg = (pix.getRed() + pix.getBlue() + pix.getGreen())/3;
                if (avg < 128){
                    line.add("0");
                }
                else{
                    line.add("1");
                }
            }
            map.add(line);
        }

        return map;
    }

    public static BufferedImage generate_image_from_map(ArrayList<ArrayList<String>> map){
        BufferedImage img = new BufferedImage(Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT,TYPE_INT_ARGB);
        /*
        Eventually for a map creator
         */
        return img;
    }



    @Override
    public String toString(){

        return "Image :" + "\n" + track_image_filename + "\n" + "Map :" + "\n" + track_map;
    }

}
