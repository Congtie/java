import java.awt.Graphics;

/**
 * Triangle is an example of a very simple Dingus.
 * 
 * @author Gabriel Leite Savegnago
 * @id 1716255
 * @author Coman Ioan Alexandru
 * @id 1824694
 */
class Triangle extends Dingus {
    int [] myIntArray, myIntArray2;

    /**
     * Create and initialize a new Triangle.
     * 
     * @param maxX upper bound for the x coordinate of the position
     * @param maxY upper bound for the y coordinate of the position
     */
    public Triangle (int maxX, int maxY) {
        super(maxX, maxY);
        myIntArray = new int[3];
        myIntArray2 = new int[3];

        // intialize randomly the Dingus properties, i.e., position
        for(int i = 0; i < 3;i++ ){
            myIntArray[i] = random.nextInt(maxX);
            myIntArray2[i] = random.nextInt(maxY);
        }
    }

    @Override
    void draw(Graphics g) {
        g.setColor(color); // Sets random color
        g.fillPolygon(myIntArray,myIntArray2 ,3);
  
    }
}