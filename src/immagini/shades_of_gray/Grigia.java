package immagini.shades_of_gray;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.io.*;

public class Grigia {
    public static void main(String[] args) throws Exception{
        //crea immagine
        BufferedImage outputImage = new BufferedImage(255, 255, BufferedImage.TYPE_3BYTE_BGR);

        //creare imagine

        for (int col = 0; col < outputImage.getWidth(); col++)
            for (int row = 0; row < outputImage.getHeight(); row++)
            {
                if(col<=row) {
                    Color pixel = new Color( row,  row, row);
                    outputImage.setRGB(col, row, pixel.getRGB());
                    continue;
                }
                    Color pixel = new Color(col, col, col);
                    outputImage.setRGB(col, row, pixel.getRGB());

            }

        ImageIO.write(outputImage, "jpg", new File("image/immaginegrigia.jpg"));
    }
}
