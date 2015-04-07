import com.sun.imageio.plugins.jpeg.JPEG;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by oksana on 4/7/15.
 */
public class ImageProcessor {

    public static void toGrayscale(BufferedImage image) {
    }

    public static void main(String[] args) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("/home/oksana/workspace/ImageProcessor/im.jpg"));
        } catch (IOException e) {
        }

        toGrayscale(img);

        try {
            File f = new File("/home/oksana/workspace/ImageProcessor/im1.jpg");
            ImageIO.write(img, "jpg", f);
        } catch (IOException e) {
        }
    }
}
