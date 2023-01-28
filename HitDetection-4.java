
import java.util.Scanner;
/**
 * Detects if a point hits any of two circles.
 * 
 * Usage:
 * First we enter the (X,Y) variables of the first circle then it's radius after we do the same for
 * the second circle, and in the end we enter the (X,Y) coordinates of the point.
 * example:
 * 0 0 2 0 4 2 0 1
 * You can't put a negative radius.
 * The program uses a formula to indicate weather the point is hitting a circle or not.
 * END
 * 
 * @author Coman Ioan Alexandru
 * @ID 1824694
 * 
 */



public class HitDetection {
 

    public void run() {
        Scanner scanner = new Scanner(System.in);
        double circlex1;
        double circley1;
        double circlex2;
        double circley2;
        double radius1;
        double radius2;
        double point1;
        double point2;
        boolean hitcircle1 = false;
        boolean hitcircle2 = false;

        circlex1 = scanner.nextDouble();
        circley1 = scanner.nextDouble();
        radius1 = scanner.nextDouble();
        circlex2 = scanner.nextDouble();
        circley2 = scanner.nextDouble();
        radius2 = scanner.nextDouble();
        point1 = scanner.nextDouble();
        point2 = scanner.nextDouble();
        scanner.close();
        if (radius1 < 0 || radius2 < 0) {
            System.out.println("input error");
            System.exit(0);
        }

        if (Math.sqrt((circlex1 - point1) * (circlex1 - point1) 
            + (circley1 - point2) * (circley1 - point2)) <= radius1) {
            hitcircle1 = true;
        }
        if (Math.sqrt((circlex2 - point1) * (circlex2 - point1)
            + (circley2 - point2) * (circley2 - point2)) <= radius2) {
            hitcircle2 = true;
        }
        if ((hitcircle1) && (hitcircle2)) {
            System.out.println("The point hits both circles");
        } else if ((!hitcircle1) && (hitcircle2)) {
            System.out.println("The point hits the second circle");
        } else if ((!hitcircle1)  && (!hitcircle2)) {
            System.out.println("The point does not hit either circle");
        } else if ((hitcircle1)  && (!hitcircle2)) {
            System.out.println("The point hits the first circle");
        }
    }

    public static void main(String[] agrs) {

        new HitDetection().run();

    }   
}
