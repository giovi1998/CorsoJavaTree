package immagini.Green_Screen;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.io.*;

public class GreeScreen {
    public static void main(String[] args) throws Exception {
        BufferedImage imageIniziale = ImageIO.read(new File("C:\\Users\\Giovanni\\IdeaProjects\\CorsoJavaTree\\src\\immagini\\Green_Screen\\zeb89.jpg"));
        BufferedImage imageaot = ImageIO.read(new File("C:\\Users\\Giovanni\\IdeaProjects\\CorsoJavaTree\\src\\immagini\\Green_Screen\\aot.jpg"));
        //BufferedImage immagineFinale = new BufferedImage(imageIniziale.getWidth(), imageIniziale.getHeight(), BufferedImage.TYPE_3BYTE_BGR);


        int y;
        int x;


        for (y = 0; y < imageIniziale.getHeight(); y++) {

            for (x = 0; x < imageIniziale.getWidth(); x++) {

                Color color = new Color(imageIniziale.getRGB(x, y));
                Color daModificare = new Color(imageaot.getRGB(x, y));
                //image Aot
                int r = daModificare.getRed();
                int g = daModificare.getGreen();
                int b = daModificare.getBlue();

                //image Iniziale
                int rI = color.getRed();
                int gI = color.getGreen();
                int bI = color.getBlue();

                //48,255,17

                Color newColor;
                if (Distanza(rI, bI, gI, 48, 17, 255) <=170) {
                    //System.out.println("jasns");
                    newColor = new Color(r, g, b);
                } else {
                    newColor = new Color(rI, gI, bI);

                }
                imageIniziale.setRGB(x, y, newColor.getRGB());

            }


            ImageIO.write(imageIniziale, "jpg", new File("image/Green.jpg"));

        }
    }
    public static int Distanza(int r, int b, int g, int rI, int bI, int gI) {

        int distanza = (int) Math.sqrt(Math.pow(r - rI, 2) + Math.pow(b - bI, 2) + Math.pow(g - gI, 2));
        return distanza;
    }

}
