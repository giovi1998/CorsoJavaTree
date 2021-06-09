package immagini.Filtri;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.io.*;

public class Filtri {
    public static void main(String[] args) throws Exception {


        filtroInBiancoENero();
        filtroAspecchio();
        filtroGRB();
        filtroNegativo();
        filtroposterize();
    }






    public static void filtroAspecchio() throws Exception{
        //apre un immagine e la mette in immagineIniziale
        BufferedImage immagineIniziale = ImageIO.read(new File("C:\\Users\\Giovanni\\IdeaProjects\\CorsoJavaTree\\src\\immagini\\Filtri\\freaked.jpg"));

        BufferedImage immagineModificata = new BufferedImage(immagineIniziale.getWidth(), immagineIniziale.getHeight(), BufferedImage.TYPE_3BYTE_BGR);


        for (int x = 0; x < immagineModificata.getWidth(); x++) {
            for (int y = 0; y < immagineModificata.getHeight(); y++) {
                Color myColor = new Color(immagineIniziale.getRGB(x, y));
                //parto dall'ultima posizione e sottraggo ogni pixel fino all'ultimo (-1) solo per le x
                immagineModificata.setRGB((immagineIniziale.getWidth()-x-1),y,myColor.getRGB());
            }
        }
        ImageIO.write(immagineModificata, "jpg", new File("image/immagineFiltroaSpecchio.jpg"));
    }
    public static void filtroInBiancoENero() throws Exception{
        //crea immagine
        BufferedImage imageIniziale = ImageIO.read(new File("C:\\Users\\Giovanni\\IdeaProjects\\CorsoJavaTree\\src\\immagini\\Filtri\\freaked.jpg"));

        //scrive e salva l'imagine
        ImageIO.write(imageIniziale, "jpg", new File("image/FreakedNormale.jpg"));


        //in bianco in nero
        int y;
        int x;
        int red;
        int green;
        int blue;

        /*colore grigia*/
        for (y = 0; y < imageIniziale.getHeight(); y++){

            for(x = 0; x < imageIniziale.getWidth(); x++){

                Color color = new Color(imageIniziale.getRGB(x, y));

                red = (color.getRed() * 77) / 255;

                green = (color.getGreen() + 150) / 255;

                blue = (color.getBlue() + 28) / 255;

                Color newColor = new Color(red + green + blue, red + green + blue , red + green + blue);

                imageIniziale.setRGB(x, y, newColor.getRGB());

            }

        }
        ImageIO.write(imageIniziale, "jpg", new File("image/Freakedprova2.jpg"));
    }
    public static void filtroGRB() throws Exception{
        //crea immagine
        BufferedImage imageIniziale = ImageIO.read(new File("C:\\Users\\Giovanni\\IdeaProjects\\CorsoJavaTree\\src\\immagini\\Filtri\\freaked.jpg"));

        //scrive e salva l'imagine
        ImageIO.write(imageIniziale, "jpg", new File("image/FreakedNormale.jpg"));
        //in bianco in nero
        int y;
        int x;


        for (y = 0; y < imageIniziale.getHeight(); y++){

            for(x = 0; x < imageIniziale.getWidth(); x++){

                Color color = new Color(imageIniziale.getRGB(x, y));


                Color newColor = new Color(color.getBlue(), color.getGreen() , color.getRed());

                imageIniziale.setRGB(x, y, newColor.getRGB());

            }

        }
        ImageIO.write(imageIniziale, "jpg", new File("image/FreakedGRB.jpg"));
    }

    public static void filtroNegativo() throws Exception{
        //crea immagine
        BufferedImage imageIniziale = ImageIO.read(new File("C:\\Users\\Giovanni\\IdeaProjects\\CorsoJavaTree\\src\\immagini\\Filtri\\freaked.jpg"));

        //scrive e salva l'imagine
        ImageIO.write(imageIniziale, "jpg", new File("image/FreakedNormale.jpg"));
        //in bianco in nero
        int y;
        int x;


        for (y = 0; y < imageIniziale.getHeight(); y++){

            for(x = 0; x < imageIniziale.getWidth(); x++){

                Color color = new Color(imageIniziale.getRGB(x, y));


                Color newColor = new Color(255-color.getBlue(), 255-color.getGreen() , 255-color.getRed());

                imageIniziale.setRGB(x, y, newColor.getRGB());

            }

        }
        ImageIO.write(imageIniziale, "jpg", new File("image/FreakedNegativo.jpg"));
    }
    public static void filtroposterize() throws Exception{
        //crea immagine
        BufferedImage imageIniziale = ImageIO.read(new File("C:\\Users\\Giovanni\\IdeaProjects\\CorsoJavaTree\\src\\immagini\\Filtri\\freaked.jpg"));

        //scrive e salva l'imagine
        ImageIO.write(imageIniziale, "jpg", new File("image/FreakedNormale.jpg"));
        //in bianco in nero
        int y;
        int x;

        //num non puo essere superiore
        int num=10;
        int dim = 255 / num;
        for (y = 0; y < imageIniziale.getHeight(); y++){

            for(x = 0; x < imageIniziale.getWidth(); x++) {

                Color color = new Color(imageIniziale.getRGB(x, y));



                int r=getColorRedPosterize(color.getRed(),dim);
                int g=getColorGreenPosterize(color.getGreen(),dim);
                int b=getColorBluePosterize(color.getBlue(),dim);

                Color newColor = new Color(r , g , b);

                imageIniziale.setRGB(x, y, newColor.getRGB());

            }

        }
        ImageIO.write(imageIniziale, "jpg", new File("image/Freakedposterize.jpg"));

    }
    public static int getColorRedPosterize(int r,int dim) {
        int num = 0;
        for(int i=0;i<255;i++){//i=0 num=4 -> 0
            //i=1 dim ->dim
            //
            if (i*dim <=r ) {
                num = dim*i;

            }
        }
        return num;

    }
    public static int getColorGreenPosterize(int g,int dim) {
        int num = 0;
        for(int i=0;i<255;i++){//i=0 num=4 -> 0
            //i=1 dim ->dim
            //
            if (i*dim <=g ) {
                num = dim*i;

            }
        }
        return num;

    }

    public static int getColorBluePosterize(int b,int dim) {
        int num=0;
        for(int i=0;i<255;i++){//i=0 num=4 -> 0
            //i=1 dim ->dim
            //
            if (i*dim <=b ) {
                num = dim*i;
            }
        }
        return num;

    }
}
