package immagini.Timelapse_Webcam;

import com.github.sarxos.webcam.Webcam;

import javax.imageio.ImageIO;
import java.io.File;

public class Hello {
    public static void main(String[] args) throws Exception {
        Webcam webcam = Webcam.getDefault();
        webcam.open();
        ImageIO.write(webcam.getImage(), "PNG", new File("image/hello-world.png"));
        webcam.close();
    }
}
