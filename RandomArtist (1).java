import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Main class for the homework assignment Random Artist.
 * 
 * This class doesn't need to change.
 * 
 *
 * @author Gabriel Leite Savegnago
 * @id 1716255
 * @author Coman Ioan Alexandru
 * @id 1824694
 */
public class RandomArtist {
    JFrame frame;
    Painting painting; // panel that provides the random painting
    JButton regenerateButton;
    JButton shotButton;

    /**
     * Create a new instance of the RandomArtist application.
     */
    RandomArtist() {
        // invokeLater: preferred way to create components
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                painting = new Painting();
                frame = new JFrame("Computer Assisted Random Artist");
                frame.add(painting, BorderLayout.CENTER);
                regenerateButton = new JButton("Regenerate");

                // painting provides reaction to buttonclick
                regenerateButton.addActionListener(painting);

                frame.add(regenerateButton, BorderLayout.SOUTH);
                shotButton = new JButton("Screenshot");
                shotButton.addActionListener(painting);
                frame.add(shotButton, BorderLayout.NORTH);
                frame.pack();
                painting.regenerate(); // can be done here since painting has a size!
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] arg) {
        new RandomArtist();
    }
}