import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Painting.
 * 
 * Paint with Dinguses, i.e., generate a new painting by making a random
 * composition of Dingus shapes.
 *
 *
 * @author Gabriel Leite Savegnago
 * @id 1716225
 * @author Coman Ioan Alexandru
 * @id 1824694
 */
public class Painting extends JPanel implements ActionListener {

    /*---- Randomness ----*/

    /**
     * Seed for the random number generator.
     * 
     * You can change the variable SEED if you like. The same program with the same
     * SEED will generate exactly the same sequence of pictures.
     */
    static final long SEED = 37;

    // DON'T CHANGE the following three lines:
    // RANDOM is the random number generator used and shared by all classes in your
    // program.
    static final Random RANDOM = new Random(SEED);
    int numberOfRegenerates = 0;

    // ---- Screenshots ----
    // DON'T CHANGE the following two lines:
    char current = '0';
    String filename = "randomshot_"; // prefix

    /*---- Dinguses ----*/
    ArrayList<Dingus> shapes;

    /**
     * Create a new painting.
     */
    public Painting() {
        setPreferredSize(new Dimension(800, 450)); // make panel 800 by 450 pixels.
        // ...

    }

    @Override
    protected void paintComponent(Graphics g) { // draw all your shapes
        super.paintComponent(g); // clears the panel
        shapes = new ArrayList<Dingus>();
        boolean more = false;

        for (int i = 0; i < 7; i++) { // Adds every shape to the ArrayList 3 times
            shapes.add(new Cylinder(800, 450));
            shapes.add(new Circle(800, 450));
        }
        shapes.add(new Triangle(800, 450));

        for (int i = 0; i < 25; i++) { // Loops from 0 to 20 (20 times)
            more = RANDOM.nextBoolean(); // Sets boolean value to a random boolean value

            // If the variable is true, then it adds an other shape to the ArrayList
            if (more) {
                shapes.add(new Rectangle(800, 450)); // Adds shape to the arrayList
            }
        }

        // Drawing the shapes
        for (int i = 0; i < shapes.size(); i++) { // Loops through the ArrayList
            shapes.get(i).draw(g); // Draws the shape
        }
    }

    /**
     * Reaction to button press.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Regenerate".equals(e.getActionCommand())) {
            regenerate();
            repaint();
        } else { // screenshot
            saveScreenshot(this, filename + current++); // ++ to show of compact code :-)
        }
    }

    /**
     * Regenerate this painting.
     */
    void regenerate() {
        numberOfRegenerates++; // do not change

        // clear the shapes list
        if (numberOfRegenerates > 1) { // Checks if the button was clicked
            shapes.removeAll(shapes); // Removes everything from the ArrayList
        }

        // create random shapes
        if (numberOfRegenerates > 1) { // Checks if the button was clicked
            // Changes the random
            RANDOM.setSeed(SEED + (1 * numberOfRegenerates));
        }

    }

    /**
     * Saves a screenshot of this painting to disk.
     * 
     * DON'T CHANGE this method
     * 
     * Note. This action will overide existing files!
     *
     * @param component Component to be saved
     * @param name      filename of the screenshot, followed by a sequence number
     * 
     */
    void saveScreenshot(Component component, String name) {
        // minus 1 because the initial picture should not count
        String randomInfo = "" + SEED + "+" + (numberOfRegenerates - 1);
        System.out.println(SwingUtilities.isEventDispatchThread());
        BufferedImage image = new BufferedImage(
                component.getWidth(),
                component.getHeight(),
                BufferedImage.TYPE_INT_RGB);

        // call the Component's paint method, using
        // the Graphics object of the image.
        Graphics graphics = image.getGraphics();
        component.paint(graphics); // alternately use .printAll(..)
        graphics.drawString(randomInfo, 0, component.getHeight());

        try {
            ImageIO.write(image, "PNG", new File(name + ".png"));
            System.out.println("Saved screenshot as " + name);
        } catch (IOException e) {
            System.out.println("Saving screenshot failed: " + e);
        }
    }
}