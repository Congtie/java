import java.util.Scanner;

/**
 * Universal Automaton.
 * 
 * Usage: The user firstly inputs a sequence of 8 ones or zeros with one space in between. This
 * sequence is used in the read rule sequence to determine the correct rules that are then used in
 * the nextGen method. The user then inputs the length of the generation followed by the amount of
 * generations. In order for the program to know the user has to init_start followed by integers
 * within the generation legth to indicate where the first cell shoudl start. When the user inputs
 * init_end
 * 
 * 
 * @author Gabriel Leite Savegnago
 * @id 1716255
 * 
 * @author Coman Ioan Alexandru
 * @id 1824694
 * 
 */
class UniversalAutomaton {
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
     * set of rules chosen by the user.
     */

    boolean[] nextGen(boolean[] ruleSequence, boolean[] gen) {
        int i = 0; // Variable used for most of the loops

        // Boolean array that has the values for the next generation
        boolean[] newNextGen = new boolean[gen.length];

        // When there is only 1 input
        if (gen.length == 1) {
            if (gen[0] == false) {
                if (ruleSequence[0] == true) {
                    newNextGen[0] = true;
                    return newNextGen;
                } else {
                    return newNextGen;
                }
            } else if (gen[0] == true) {
                if (ruleSequence[2] == true) {
                    newNextGen[0] = true;
                    return newNextGen;
                } else {
                    newNextGen[0] = false;
                    return newNextGen;
                }
            }
        }

        // This for loop changes all the values in the newNextGen array to false
        for (int y = 0; y < gen.length; y++) {
            newNextGen[y] = false;
        }
        /*
         * if statement which checks what rules were set to true by the user and applies it for the
         * first number in the array. If the values follows the rule then the first value in the
         * newNextGen array is changed to true. The gen array is not changed.
         */

        if (ruleSequence[0] == true) {
            if (!gen[i] && !gen[i + 1]) {
                newNextGen[i] = true;

            } else {
                newNextGen[i] = false;
            }
        } else if (ruleSequence[0] == false) {
            if (!gen[i] && !gen[i + 1]) {
                newNextGen[i] = false;
            }
        }

        if (ruleSequence[1] == true) {
            if (!gen[i] && gen[i + 1]) {
                newNextGen[i] = true;

            } else {
                newNextGen[i] = false;

            }
        } else if (ruleSequence[1] == false) {
            if (!gen[i] && gen[i + 1]) {
                newNextGen[i] = false;

            }
        }

        if (ruleSequence[2] == true) {
            if (gen[i] && !gen[i + 1]) {
                newNextGen[i] = true;
            }
        } else if (ruleSequence[2] == false) {
            if (gen[i] && !gen[i + 1]) {
                newNextGen[i] = false;

            }
        }

        if (ruleSequence[3] == true) {
            if (gen[i] && gen[i + 1]) {
                newNextGen[i] = true;

            }
        } else if (ruleSequence[3] == false) {
            if (gen[i] && gen[i + 1]) {
                newNextGen[i] = false;

            }
        }

        i++;

        /*
         * The following collection of while loops, checks every value in the gen arrau for every
         * rule. There are multiple if statements in each loop which checks the user choice for the
         * specific rule and applies the rule if the requirements are met.
         */

        while (i < gen.length - 1) {
            if (ruleSequence[0] == true) {
                if (!gen[i] && !gen[i + 1] && !gen[i - 1]) {
                    newNextGen[i] = true;
                    // System.out.println("Works");
                    i++;
                } else {
                    i++;
                    // System.out.println("Works");
                }

            } else if (ruleSequence[0] == false) {
                if (!gen[i] && !gen[i + 1] && !gen[i - 1]) {
                    newNextGen[i] = false;
                    i++;
                } else {
                    i++;
                    // System.out.println("Works");
                }
            }
        }

        i = 1; // i is set to 1, for i not to a number larger than the array length
        while (i < gen.length - 1) {
            if (ruleSequence[1] == true) {
                if (!gen[i] && gen[i + 1] && !gen[i - 1]) {
                    newNextGen[i] = true;
                    i++;
                } else {
                    i++;
                    // System.out.println("Works");
                }

            } else if (ruleSequence[1] == false) {
                if (!gen[i] && gen[i + 1] && !gen[i - 1]) {
                    newNextGen[i] = false;
                    i++;
                } else {
                    i++;
                    // System.out.println("Works");
                }
            }
        }

        i = 1;
        while (i < gen.length - 1) {
            if (ruleSequence[2] == true) {
                if (gen[i] && !gen[i + 1] && !gen[i - 1]) {
                    newNextGen[i] = true;
                    i++;
                } else {
                    i++;
                    // System.out.println("Works");
                }

            } else if (ruleSequence[2] == false) {
                if (gen[i] && !gen[i + 1] && !gen[i - 1]) {
                    newNextGen[i] = false;
                    i++;
                } else {
                    i++;
                    // System.out.println("Works");
                }
            }
        }

        i = 1;
        while (i < gen.length - 1) {
            if (ruleSequence[3] == true) {
                if (gen[i] && gen[i + 1] && !gen[i - 1]) {
                    newNextGen[i] = true;
                    i++;
                } else {
                    i++;
                    // System.out.println("Works");
                }

            } else if (ruleSequence[3] == false) {
                if (gen[i] && gen[i + 1] && !gen[i - 1]) {
                    newNextGen[i] = false;
                    i++;
                } else {
                    i++;
                    // System.out.println("Works");
                }
            }
        }

        i = 1;
        while (i < gen.length - 1) {
            if (ruleSequence[4] == true) {
                if (!gen[i] && !gen[i + 1] && gen[i - 1]) {
                    newNextGen[i] = true;
                    i++;
                } else {
                    i++;
                    // System.out.println("Works");
                }

            } else if (ruleSequence[4] == false) {
                if (!gen[i] && !gen[i + 1] && gen[i - 1]) {
                    newNextGen[i] = false;
                    i++;
                } else {
                    i++;
                    // System.out.println("Works");
                }
            }
        }

        i = 1;
        while (i < gen.length - 1) {
            if (ruleSequence[5] == true) {
                if (!gen[i] && gen[i + 1] && gen[i - 1]) {
                    newNextGen[i] = true;
                    i++;
                } else {
                    i++;
                    // System.out.println("Works");
                }

            } else if (ruleSequence[5] == false) {
                if (!gen[i] && gen[i + 1] && gen[i - 1]) {
                    newNextGen[i] = false;
                    i++;
                } else {
                    i++;
                    // System.out.println("Works");
                }
            }
        }

        i = 1;
        while (i < gen.length - 1) {
            if (ruleSequence[6] == true) {
                if (gen[i] && !gen[i + 1] && gen[i - 1]) {
                    newNextGen[i] = true;
                    i++;
                } else {
                    i++;
                    // System.out.println("Works");
                }

            } else if (ruleSequence[6] == false) {
                if (gen[i] && !gen[i + 1] && gen[i - 1]) {
                    newNextGen[i] = false;
                    i++;
                } else {
                    i++;
                    // System.out.println("Works");
                }
            }
        }

        i = 1;
        while (i < gen.length - 1) {

            if (ruleSequence[7] == true) {
                if (gen[i] && gen[i + 1] && gen[i - 1]) {
                    newNextGen[i] = true;
                    i++;
                } else {
                    i++;
                    // System.out.println("Works");
                }

            } else if (ruleSequence[7] == false) {
                if (gen[i] && gen[i + 1] && gen[i - 1]) {
                    newNextGen[i] = false;
                    i++;
                } else {
                    i++;
                    // System.out.println("Works");
                }
            }
        }

        /*
         * The following set of if statments checks if the rules apply for the last value in the
         * boolean array (gen[gen.length-1])
         */

        if (ruleSequence[0] == true) {
            if (!gen[gen.length - 1] && !gen[gen.length - 2]) {
                newNextGen[gen.length - 1] = true;

            }
        } else if (ruleSequence[0] == false) {
            if (!gen[gen.length - 1] && !gen[gen.length - 2]) {
                newNextGen[gen.length - 1] = false;
            }
        }

        if (ruleSequence[2] == true) {
            if (gen[gen.length - 1] && !gen[gen.length - 2]) {
                newNextGen[gen.length - 1] = true;
            }
        } else if (ruleSequence[2] == false) {
            if (gen[gen.length - 1] && !gen[gen.length - 2]) {
                newNextGen[gen.length - 1] = false;

            }
        }

        if (ruleSequence[4] == true) {
            if (!gen[gen.length - 1] && gen[gen.length - 2]) {
                newNextGen[gen.length - 1] = true;
            }
        } else if (ruleSequence[2] == false) {
            if (!gen[gen.length - 1] && gen[gen.length - 2]) {
                newNextGen[gen.length - 1] = false;

            }
        }

        if (ruleSequence[6] == true) {
            if (gen[gen.length - 1] && gen[gen.length - 2]) {
                newNextGen[i] = true;
            }
        } else if (ruleSequence[2] == false) {
            if (gen[gen.length - 1] && gen[gen.length - 2]) {
                newNextGen[gen.length - 1] = false;

            }
        }
        return newNextGen;
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

    /*
     * Method which reads which rules the user desires the program to follow. The following method
     * does this through changing the input into a boolean in a boolean array with max length of 8
     */
    boolean[] readRuleSequence() {
        boolean[] ruleSequence = new boolean[8]; // Boolean array that will be returned
        String userInput = ""; // String used for user input
        int i = 0; // Variable used in the following while loop

        while (i < ruleSequence.length) {
            userInput = scanner.next();
            if ("1".equals(userInput)) {
                // If user inputs 1 then that value is set to true in the array
                ruleSequence[i] = true;
                i++;
            } else {
                ruleSequence[i] = false;
                i++;
            }
        }
        return ruleSequence;
    }

    void run() {
        // Read input to configure the universal automaton
        boolean[] ruleSequence = readRuleSequence();
        int generationLength = scanner.nextInt();
        int numberOfGenerations = scanner.nextInt();
        boolean[] initGen = readInitalGeneration(generationLength);
        // Run the automaton
        boolean[] gen = initGen;
        for (int i = 0; i < numberOfGenerations; i++) {
            // Display the current generation
            System.out.println(genToString(gen));
            // Determine the next generation
            gen = nextGen(ruleSequence, gen);
        }
    }

    public static void main(String[] args) {
        new UniversalAutomaton().run();
    }
}