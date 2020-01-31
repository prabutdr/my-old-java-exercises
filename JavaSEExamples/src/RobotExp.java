/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Prabu
 */
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class RobotExp {
    public static void main(String[] args) {
        try {
            Robot robot = new Robot();
            BufferedImage bi = robot.createScreenCapture(new Rectangle(200, 200, 100, 100));
            ImageIO.write(bi, "jpg", new File("C:\\Prabu\\Practice\\Java\\JavaSEExamples\\imageoutput.jpg"));
        }
        catch(AWTException exp) {
            exp.printStackTrace();
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
