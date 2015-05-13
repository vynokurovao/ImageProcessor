import com.sun.imageio.plugins.jpeg.JPEG;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by oksana on 4/7/15.
 */
public class ImageProcessor {

    public static void toGrayscale(BufferedImage image) {

        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                int rgb = image.getRGB(j, i);

                int alpha = (rgb >> 24) & 0xff;
                int red = (rgb >> 16) & 0xff;
                int green = (rgb >> 8) & 0xff;
                int blue = rgb & 0xff;

                int newRgb = (int)(0.2126 * red + 0.7152 * green + 0.0722 * blue);

                alpha = (alpha << 24);
                red = (newRgb << 16);
                green = (newRgb << 8);
                blue = newRgb;

                rgb = alpha + red + green + blue;

                image.setRGB(j, i, rgb);
            }
        }
    }

    public static void main(String[] args) {

        if (args.length < 2){
            System.out.println("Not enough data received");
        }

        BufferedImage img = null;

        try {
            img = ImageIO.read(new File(args[0]));
        } catch (IOException e) {
        }

        toGrayscale(img);

        try {
            ImageIO.write(img, "jpg", new File(args[1]));
        } catch (IOException e) {
        }
    }
}
