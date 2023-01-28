import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * Dingus represents an arbitraty shape.
 * 
 * @author Gabriel Leite Savegnago
 * @id 1716255
 * @author Coman Ioan Alexandru
 * @id 1824694
 */
abstract class Dingus {
    /**
     * Random generator to be used by all subclasses of Dingus.
     * DON'T CHANGE
     */
    Random random = Painting.RANDOM;
    /**
     * Postion of the shape (upper left corner).
     *
     */
    protected int x;
    protected int y;
    /**
     * Color used for drawing this shape.
     */
    protected Color color;
    protected Color clearColor;
    /**
     * Maximal coordinates; drawing area is (0,0)- (maxX,maxY).
     */
    int maxX;
    int maxY;

    /**
     * Initialize color and position to random values.
     *
     * @param maxX upper bound for the x coordinate of the position
     * @param maxY upper bound for the y coordinate of the position
     */
    public Dingus(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;

        // Initialize to a random position
        x = random.nextInt(maxX);
        y = random.nextInt(maxY);

        // New colors
        Color lightGreen = new Color(173, 255, 230);
        Color clearYellow = new Color(200, 200, 100);

        // A color array used to store colors
        Color[] colorList = { Color.gray, Color.gray.darker(), Color.gray.darker().darker(), Color.gray.brighter(),
                Color.gray.brighter().brighter(), Color.cyan, Color.CYAN.brighter(), Color.blue, Color.blue.darker(),
                Color.blue.darker().darker(), Color.blue.brighter(),
                Color.blue.brighter().brighter(), lightGreen, lightGreen.brighter(), clearYellow };

        // Random number used for the color
        int colorNumber = random.nextInt(colorList.length);

        // Checks if the random number is within the length of the color list
        if (colorNumber < colorList.length) {

            // Sets the color to a color depending on the random number
            color = colorList[colorNumber];
        }

        // The r,g,b values of the random color
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();

        clearColor = new Color(red, green, blue, 100);

    }

    abstract void draw(Graphics g);
}