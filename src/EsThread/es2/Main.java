package EsThread.es2;


import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class Main {

    public static void main(String[] args) throws Exception {


        long startTime = System.currentTimeMillis();//questo è per vedere il tempo

        //questo è per processare le immagini
        BufferedImage inputImage = null;
        try {
            inputImage = ImageIO.read(new File("C:\\Users\\Giovanni\\IdeaProjects\\CorsoJavaTree\\Image\\hello-world.png")); //caricamento immagine
        } catch (IOException e) {
        }


        BufferedImage outputImage = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), BufferedImage.TYPE_4BYTE_ABGR); // creazione immagine output
        // caso 4 Thread
        ThreadBordoReal t4 = new ThreadBordoReal(inputImage,outputImage,startTime,0,0,inputImage.getWidth()/2,inputImage.getHeight());
        ThreadBordoReal t5 = new ThreadBordoReal(inputImage,outputImage,startTime,inputImage.getWidth()/2,0,inputImage.getWidth(),inputImage.getHeight());
        ThreadBordoReal t6 = new ThreadBordoReal(inputImage,outputImage,startTime,0,0,inputImage.getWidth(),inputImage.getHeight()/2);
        ThreadBordoReal t7 = new ThreadBordoReal(inputImage,outputImage,startTime,0,inputImage.getHeight()/2,inputImage.getWidth(),inputImage.getHeight());

        //caso due Thread
        ThreadBordoReal t1 = new ThreadBordoReal(inputImage, outputImage, startTime, 0, 0, inputImage.getWidth(), inputImage.getHeight()/2);
        ThreadBordoReal t2 = new ThreadBordoReal(inputImage, outputImage, startTime, 0, inputImage.getHeight() / 2, inputImage.getWidth(), inputImage.getHeight());

        ThreadBordoReal t3 = new ThreadBordoReal(inputImage, outputImage, startTime, 0, 0, inputImage.getWidth(), inputImage.getHeight());

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
