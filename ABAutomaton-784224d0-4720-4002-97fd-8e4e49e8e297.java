import java.util.Scanner;

/**
 * Automatons A and B
 * 
 * Usage: The user firstly inputs a A or B, depending on which set of rules the user want to
 * utilize. The user then inputs the generation length, followed by the amount of generations. In
 * addition, the user inputs init_start followed by a sequence of integers to tell the program where
 * the first generation should start. In order to start the program, the user has to input init_end.
 * 
 * @author Gabriel Leite Savegnago
 * @id 1716255
 * 
 * @author Coman Ioan Alexandru
 * @id 1824694
 * 
 */
class ABAutomaton {
    Scanner scanner = new Scanner(System.in);

    /*
     * The method newGen receives an array of Boolean values and changes them to true or false
     * through using a collection of if statement. The method decides if the value should; based on
     * the set of rules chosen by the user.
     */
    String genToString(boolean[] gen) {
        String generation = ""; // initializes a string which is used in the loop

        /*
         * Loop which checks the boolean array and adds content into the string depending on boolean
         * value of gen[i]
         */

        for (int i = 0; i < gen.length; i++) {
            if (gen[i] == false) { // Checks if i position in the array is true
                generation = generation + " "; // Adds " " to string value is false
            } else {
                generation = generation + "*"; // Adds "*" to string value is false
            }
        }
        return generation; // Returns the string which is used in the run() method
    }

    /*
     * The following method uses a boolean array known as gen[] and loops through it and applies a
     * set of rules.
     */

    boolean[] nextGenA(boolean[] gen) {
        boolean[] genA = new boolean[gen.length]; // Boolean Array used for the next generation

        // When there is only 1 input
        if (gen.length == 1) {
            return genA;
        }

        // Loop that sets every value to false in the loop
        for (int i = 0; i < gen.length; i++) {
            genA[i] = false;
        }

        int i = 0; // Variable used for the loop

        // Checks if the first value in gen[0] follows the set of rules.
        if (gen[i + 1] || (gen[i + 1] && gen[i])) {
            genA[i] = true; // Sets the first value in the array to true
            i++;
        } else {
            genA[i] = false;
            i++;
        }

        /*
         * Loop which checks if every value in the Boolean Array gen[] follows the set of rules. If
         * the specific value "i", follows the rules, then that value is set to true in genA[i].
         */
        while (i < gen.length - 1) {
            if ((gen[i + 1] || gen[i - 1]) && !gen[i]) {
                genA[i] = true;
                i++;
            } else if (((gen[i + 1] && gen[i]) && !gen[i - 1])
                    || ((gen[i - 1] && gen[i])) && !gen[i - 1]) {
                genA[i] = true;
                i++;

            } else {
                genA[i] = false;
                i++;
            }
        }

        // Checks if the last value follows the set of rules
        if ((gen[gen.length - 1] && gen[gen.length - 2]) || gen[gen.length - 2]) {
            genA[gen.length - 1] = true; // Sets the last value to true
        } else {
            genA[gen.length - 1] = false;
        }
        return genA;
    }

    /*
     * nextGenB in functions a similar way as nextGenA. Unlike nextGenA, nextGenB utilizes a
     * different set of rules; thus making the loops and if statements different.
     */

    boolean[] nextGenB(boolean[] gen) {
        boolean[] genB = new boolean[gen.length];

        // Where is only 1 input
        if (gen.length == 1) {
            if (!gen[0]) {
                genB[0] = false;
            } else if (gen[0]) {
                genB[0] = true;
            }
            return genB;
        }

        // Loop that sets every value to false in the loop
        for (int i = 0; i < gen.length; i++) {
            genB[i] = false;
        }

        int i = 0; // Variable used in the following loops and if statements.

        // Checks if the first value in gen[0] follows the set of rules.
        if (gen[i + 1] && !gen[i]) {
            genB[i] = true; // Sets the first value in the array to true
            i++;
        } else if (!gen[i + 1] && gen[i]) {
            genB[i] = true;
            i++;
        } else {
            genB[i] = false;
            i++;
        }

        /*
         * Loop which checks if every value in the Boolean Array gen[] follows the set of rules. If
         * the specific value "i", follows the rules, then that value is set to true in genB[i].
         */
        while (i < gen.length - 1) {
            if (gen[i] && !gen[i + 1]) {
                genB[i] = true;
                i++;
            } else if (!gen[i] && (gen[i + 1] && !gen[i - 1]) || (!gen[i + 1] && gen[i - 1])) {
                genB[i] = true;
                i++;
            } else {
                genB[i] = false;
                i++;
            }
        }

        // Checks if the last value follows the set of rules
        if (gen[gen.length - 1]) { // When last cell is true
            genB[gen.length - 1] = true;

        } else {
            if (gen[gen.length - 2]) {
                genB[gen.length - 1] = true;
            } else {
                genB[gen.length - 1] = false;
            }
        }
        return genB;
    }

    /*
     * redInitialGeneration method checks the user input to see where the first cell or cells should
     * start. It also checks when the user is finnished inputing the start postitions.
     */
    boolean[] readInitalGeneration(int length) {
        /*
         * Boolean array where all values are false and only the numbers chosen by the user is later
         * set to true.
         */
        boolean[] initial = new boolean[length];
        int[] userStartPostitions = new int[length];

        // Sets all the values in the array to false
        for (int i = 0; i < initial.length; i++) {
            initial[i] = false;
        }

        int w = 0; // Variable used in the loop
        int startValue = 0; // Integer that is changed by the user
        String StartPositions = "";

        // Boolean which tells the code when the user stopped inputting start values
        boolean userStart = false;

        // Allows user to input a string
        StartPositions = scanner.next();

        // Checks if the user want to start
        if ("init_start".equals(StartPositions)) {
            // Loop which loops until the user inputs "init_end" or the maximum length is met
            while ((w < length) && !userStart) {

                // Allows user to input start position or end loop
                StartPositions = scanner.next();

                // Checks if user wants to end the loop
                if ("init_end".equals(StartPositions)) {
                    StartPositions = "";
                    userStart = true;
                    w++;

                } else {
                    /*
                     * Since the user input is a string, the following statment changes it into and
                     * integer
                     */
                    startValue = Integer.parseInt(StartPositions) - 1;
                    if (startValue > length - 1) {
                        StartPositions = ""; // Empties the string
                        w++;
                    } else {
                        initial[startValue] = true;
                        StartPositions = ""; // Empties the string
                        w++;
                    }
                }
            }
        } else {
            // System.out.println("Did not start");
        }
        return initial;
    }

    void run() {
        // Read input to configure the automaton
        String automaton = scanner.next();
        int genLength = scanner.nextInt();
        int numOfGens = scanner.nextInt();
        boolean[] initGen = readInitalGeneration(genLength);
        // Run the automaton
        boolean[] gen = initGen;
        for (int i = 0; i < numOfGens; i++) {
            // Display the current generation
            System.out.println(genToString(gen));
            // And determine the next generation
            if ("A".equals(automaton)) {
                gen = nextGenA(gen);
            } else {
                // B
                gen = nextGenB(gen);
            }
        }
    }

    public static void main(String[] args) {
        new ABAutomaton().run();
    }
}