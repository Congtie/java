import java.awt.Graphics;

/**
 * Cylinder is a cylinder which uses two tones of a randomly chosen color.
 * 
 * @author Gabriel Leite Savegnago
 * @id 1716255
 * @author Coman Ioan Alexandru
 * @id 1824694
 */
class Cylinder extends Dingus {
    protected int radius;
    protected boolean tone; // true: filled, false: outline

    /**
     * Create and initialize a new Cylinder.
     * 
     * @param maxX upper bound for the x coordinate of the position
     * @param maxY upper bound for the y coordinate of the position
     */
    public Cylinder(int maxX, int maxY) {
        // intialize randomly the Dingus properties, i.e., position and color
        super(maxX, maxY);
        // initialize randomly the Cylinder properties (radius and color tone)
        radius = random.nextInt(maxX / 4);
        tone = random.nextBoolean();

    }

    @Override
    void draw(Graphics g) {

        // Checkes what tone to set
        if (tone) {
            g.setColor(color.darker()); // Sets random color to an other tone
            g.fillRect(x, y + (radius / 2), radius, radius / 2); // Draws rectangle

            // Draws circle
            g.fillArc(x, y + (radius / 2), radius, radius, 0, 360);

            // Draws other circle and changes the color
            g.setColor(color);
            g.fillArc(x, y, radius, radius, 0, 360);
        } else {
            g.setColor(color.brighter()); // Sets random color to an other tone
            
            
            // Draws rectangle between both circles
            g.fillRect(x, y + (radius / 2), radius, radius / 2); 

            // Draws circle
            g.fillArc(x, y + (radius / 2), radius, radius, 0, 360);
            
            // Draws other circle and changes the color
            g.setColor(color);
            g.fillArc(x, y, radius, radius, 0, 360);

        }
    }
}