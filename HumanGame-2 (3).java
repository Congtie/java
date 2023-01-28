import java.util.*; // For Scanner, Random, etc.
/** 
 * Number guessing game for humans.
 * 
 * Enter a seed number, and the computer will think of a number between 0 and
 * 99 that you have to guess in at most seven tries. Afterwards, you see your
 * guessing history so you can learn to better play the game.
 * 
 * @author TODO
 * @id     TODO
 * @author TODO
 * @id     TODO
 * @data   TODO
 */

public class HumanGame {

    Scanner sc = new Scanner(System.in);
    Random randomGenerator;
    static int t;

    public static String multiplyString(String repeat, int times){
        String output = "";
        for (int i = 0; i < times; i++) {
            output = output + repeat;

        }
        return output;

    }

    void run() {
        int guess;
        int[] history = new int[7];
        int count = 0;
        System.out.println("Type an arbitrary number");
        long seed = sc.nextLong();
        randomGenerator = new Random(seed);
        int n = randomGenerator.nextInt(100);
        System.out.println("Start guessing!");
        do {
            guess = sc.nextInt();
            history[count] = guess;
            count++;
            if (count == 7 && guess < n) {
                System.out.println("higher");
                System.out.println("No more guesses, you lost.");
                break;
            } else if (count == 7 && guess > n) {
                System.out.println("lower");
                System.out.println("No more guesses, you lost.");
                break;
            } else if (guess < n) {
                System.out.println("higher");
            } else if (guess > n) {
                System.out.println("lower");

            } else if (guess == n) {
                System.out.println("Good guess! You won.");
            }



        } while (guess != n);
        for(int i=0;i < 7; i++){
            if(history[i]<n){
                System.out.println(multiplyString(".",history[i]-1) + "X" + multiplyString(".", n - history[i]-1)+"|"+multiplyString(".",99-n));
            } else if(history[i]>n){
                System.out.println(multiplyString(".",n-1) +"|"+ multiplyString(".", history[i] - n-1)+"X"+multiplyString(".",99-history[i]));

            }else{
                System.out.println(multiplyString(".",n-1)+"X"+multiplyString(".",99-n));
                break;
            }
           
        }
        
        
        
        
        

    }

    public static void main(String[] args) {
        new HumanGame().run();

    }
}