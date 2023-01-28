import java.awt.Graphics;

/**
 * Rectangle is an example of a very simple Dingus.
 * 
 * @author Gabriel Leite Savegnago
 * @id 1716255
 * @author Coman Ioan Alexandru
 * @id 1824694
 */
class Rectangle extends Dingus {
    protected boolean filled; // true: filled, false: outline

    /**
     * Create and initialize a new Rectangle.
     * 
     * @param maxX upper bound for the x coordinate of the position
     * @param maxY upper bound for the y coordinate of the position
     */
    public Rectangle(int maxX, int maxY) {
        // intialize randomly the Dingus properties, i.e., position and color
        super(maxX, maxY);
        // initialize randomly the Rectangle properties, i.e., radius and filledness
        filled = random.nextBoolean();
    }

    @Override
    void draw(Graphics g) {
        g.setColor(clearColor); // Sets the color to a clearer random color

        // Checks what type of rectangle to draw
        if (filled) {
            g.fillRect(x, y, maxY, maxX);
        } else {
            g.drawRect(x, y, maxY, maxX);
        }
    }
}