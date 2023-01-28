import java.awt.Graphics;

/**
 * Circle is a composite shape.
 * 
 * @author Gabriel Leite Savegnago
 * @id 1716255
 * @author Coman Ioan Alexandru
 * @id 1824694
 */
class Circle extends Dingus {
    protected int radius;
    protected boolean filled; // true: filled, false: outline

    /**
     * Create and initialize a new Circle.
     * 
     * @param maxX upper bound for the x coordinate of the position
     * @param maxY upper bound for the y coordinate of the position
     */
    public Circle(int maxX, int maxY) {
        // intialize randomly the Dingus properties, i.e., position and color
        super(maxX, maxY);

        // initialize randomly the Circle properties, i.e., radius and filledness
        radius = random.nextInt(maxX / 4);
        filled = random.nextBoolean();
    }

    @Override
    void draw(Graphics g) {
        g.setColor(color);
        if (filled) {
            g.fillArc(x, y, radius, radius, 180, 360);
        } else {
            g.drawArc(x, y, radius, radius, 180, 360);
        }
        g.setColor(color.brighter());
        if (filled) {
            g.fillArc(x, y, radius, radius, 0, 180);
        } else {
            g.drawArc(x, y, radius, radius, 0, 180);
        }
    }
}