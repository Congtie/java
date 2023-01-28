import java.util.ArrayList;

/**
 * Asterisk Sudoku solver.
 * 
 * Prints the number of solutions of a Sudoku if there are multiple solutions.
 * If there is only a single solution, it prints this solution instead.
 *
 * 
 * @author Gabriel Leite Savegnago
 * @id 1716255
 * @author Coman Ioan Alexandru
 * @id 1824694
 */
class SudokuSolver {
    // Size of the grid.
    static final int SUDOKU_SIZE = 9;
    // Minimum digit to be filled in.
    static final int SUDOKU_MIN_NUMBER = 1;
    // Maximum digit to be filled in.
    static final int SUDOKU_MAX_NUMBER = 9;
    // Dimension of the boxes, i.e., the sub-grids that should contain all digits.
    static final int SUDOKU_BOX_DIMENSION = 3;

    // The puzzle grid; 0 represents empty.
    // This particular grid has exactly one solution.
    // Other grids might have multiple solutions.
    int[][] grid = new int[][] {
            { 0, 9, 0, 7, 3, 0, 4, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 5, 0, 0 },
            { 3, 0, 0, 0, 0, 6, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 2, 6, 4, 0 },
            { 0, 0, 0, 6, 5, 1, 0, 0, 0 },
            { 0, 0, 6, 9, 0, 7, 0, 0, 0 },
            { 5, 8, 0, 0, 0, 0, 0, 0, 0 },
            { 9, 0, 0, 0, 0, 3, 0, 2, 5 },
            { 6, 0, 3, 0, 0, 0, 8, 0, 0 },
    };

    // Solution counter
    int solutionCounter = 0;

    /**
     * Prints this Sudoku.
     */
    void print() {
        String printLine1 = "|";
        // Print out the border with + 4 for the borders
        System.out.print("+");
        for (int i = 0; i < grid.length + 8; i++) {
            System.out.print("-");
        }
        System.out.println("+");

        // Loop with thew rows and columns
        for (int r = 0; r < 9; r++) {
            System.out.print("|");
            for (int c = 0; c < 9; c++) {

                // If it is in the place where < or > is required

                if ((c == 2) || (c == 5) || (c == 8)) {

                    // When empty
                    if (grid[r][c] == 0) {
                        System.out.print(" " + "|");
                    } else {
                        System.out.print(grid[r][c] + "|");
                    }

                } else if (((r == 1 || r == 4 || r == 7) && c == 3)) {
                    // When empty
                    if (grid[r][c] == 0) {
                        System.out.print(" " + ">");
                    } else {
                        System.out.print(grid[r][c] + ">");
                    }

                } else if ((r == 1 || r == 4 || r == 7) && c == 4) {
                    // When empty
                    if (grid[r][c] == 0) {
                        System.out.print(" " + "<");
                    } else {
                        System.out.print(grid[r][c] + "<");
                    }

                } else if ((r == 4 && (c == 0 || c == 6))) {
                    // When empty
                    if (grid[r][c] == 0) {
                        System.out.print(" " + ">");
                    } else {
                        System.out.print(grid[r][c] + ">");
                    }
                } else if ((r == 4 && (c == 1 || c == 7))) {
                    // When empty
                    if (grid[r][c] == 0) {
                        System.out.print(" " + "<");
                    } else {
                        System.out.print(grid[r][c] + "<");
                    }
                } else if ((r == 6 || r == 2) && (c == 1)) {
                    if (grid[r][c] == 0) {
                        System.out.print(" " + ">");
                    } else {
                        System.out.print(grid[r][c] + ">");
                    }

                } else if ((r == 6 || r == 2) && (c == 6)) {
                    if (grid[r][c] == 0) {
                        System.out.print(" " + "<");
                    } else {
                        System.out.print(grid[r][c] + "<");
                    }

                } else {
                    // When empty
                    if (grid[r][c] == 0) {
                        System.out.print(" " + " ");
                    } else {
                        System.out.print(grid[r][c] + " ");
                    }

                }
            }

            // Make outer borders
            System.out.println("");
            if ((r == 2) || (r == 5) || (r == 8)) {
                System.out.print("+");
                for (int b = 0; b < 17; b++) {
                    System.out.print("-");
                }
                System.out.print("+");
                System.out.println("");
            }
        }
    }

    /**
     * Determine if there's a conflic when we fill in d at position (r, c).
     * 
     * @param r row index
     * @param c column index
     * @param d value
     * @return true if there's a conflict, false otherwise
     */
    boolean givesConflict(int r, int c, int d) {

        // Checks all the other conflict methods and returns true or false
        if (rowConflict(r, d) || colConflict(c, d) || boxConflict(r, c, d) || asteriskConflict(r, c, d)) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Determine if there's a conflict when we fill in d in row r.
     * 
     * @param r row index
     * @param d value
     * @return true if there's a conflict, false otherwise
     */
    boolean rowConflict(int r, int d) {

        // Loops through the row and checks if the number is already there
        for (int i = 0; i < 9; i++) {
            if (grid[r][i] == d) { // Checks the grid for the specified row
                return true; // When the number is already there
            }
        }

        return false;

    }

    /**
     * Determine if there's a conflict when we fill d in column c.
     * 
     * @param c column index
     * @param d value
     * @return true if there's a conflict, false otherwise
     */
    boolean colConflict(int c, int d) {
        // Loops through the row and checks if the number is already there
        for (int i = 0; i < 9; i++) {
            if (grid[i][c] == d) { // Checks the grid for the specified row
                return true; // When the number is already there
            }
        }

        return false;

    }

    /**
     * Determine if there's a conflict when we fill d in box at (r, c).
     * 
     * @param r row index
     * @param c column index
     * @param d value
     * @return true if there's a conflict, false otherwise
     */
    boolean boxConflict(int r, int c, int d) {
        int[][] targetBox = new int[][] {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 },
        };

        int row = r; // The value of the row of the free box
        int column = c; // The value of the column of the free box
        int number = d; // The number which will be input
        int rowMax;
        int columnMax;

        // Minimum values used to make a smaller grid for the specific box
        int rowMin;
        int columnMin;

        // Checks what row the free box is in
        if (row <= 2) {
            rowMax = 2;
            rowMin = 0;
        } else if (row > 2 && row <= 5) {
            rowMax = 5;
            rowMin = 3;
        } else {
            rowMax = 8;
            rowMin = 6;
        }

        // Checks what column the free box is in
        if (column <= 2) {
            columnMax = 2;
            columnMin = 0;
        } else if (column > 2 && column <= 5) {
            columnMax = 5;
            columnMin = 3;
        } else {
            columnMax = 8;
            columnMin = 6;
        }

        // Creates a 2d integer array for the specific box using the grid
        for (int i = 0; i < 3; i++) { // Loops on y - axis
            for (int j = 0; j < 3; j++) { // Loops on x - axis
                targetBox[i][j] = grid[rowMin][columnMin];
                // System.out.print(columnMin); // Used for testing
                columnMin = columnMin + 1; // Adds 1 to get all numbers for specific box
            }
            columnMin = columnMin - 3; // Resets columnMin to the correct box minimum value
            rowMin++;

        }

        // Checks the specific box
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                // If statement which checks if any of the numbers in the grid equals the number
                if (targetBox[i][j] == number) {
                    return true;
                }
            }

        }
        return false;
    }

    /**
     * Determine if there's a conflict in the asterisk when we fill in d.
     * 
     * @param row row index
     * @param col col index
     * @param d   value
     * @return true if there's a conflict, false otherwise
     */
    boolean asteriskConflict(int row, int col, int d) {

        // Checks the first row and fourth column
        if (row == 1 && col == 4) {

            /*
             * If any of the methods called returns true, then the statement returns true,
             * since there would be a conflict
             */
            if (checkSecondRow(row, col, d) || checkSixthRow(row, col, d) || checkFourthRow(row, col, d)
                    || checkSeventhRow(row, col, d)) {
                return true;
            } else {
                return false;
            }

        } else if (row == 2 && (col == 2 || col == 6)) {
            if (checkFirstRow(row, col, d) || checkFourthRow(row, col, d) || checkSixthRow(row, col, d)
                    || checkSeventhRow(row, col, d)) {
                return true;
            } else {
                return false;
            }

        } else if (row == 4 && (col == 1 || col == 4 || col == 7)) {
            if (checkSeventhRow(row, col, d) || checkFirstRow(row, col, d) || checkSecondRow(row, col, d)
                    || checkSixthRow(row, col, d)) {
                return true;
            } else {
                return false;
            }

        } else if (row == 6 && (col == 2 || col == 6)) {
            if (checkFirstRow(row, col, d) || checkSecondRow(row, col, d) || checkFourthRow(row, col, d)
                    || checkSeventhRow(row, col, d)) {
                return true;
            } else {
                return false;
            }

        } else if (row == 7 && (col == 4)) {
            if (checkSecondRow(row, col, d) || checkFourthRow(row, col, d) || checkSixthRow(row, col, d)
                    || checkFirstRow(row, col, d)) {
                return true;
            } else {
                return false;
            }
        }

        // return false if no conflict
        return false;

    }

    /**
     * Coolection of methods used in asteriskConflict to check if the given number
     * is already there in any of the asterisks
     * 
     * @param row row index
     * @param col col index
     * @param d   number to check
     * @return true if there is a conflict
     */
    boolean checkFirstRow(int row, int col, int d) {
        if (d == grid[1][4]) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method used in asteriskConflict to check if the given number is already there
     * in any of the asterisks on the third row
     * 
     * @param row row index
     * @param col col index
     * @param d   number to check
     * @return true if there is a conflict
     */
    boolean checkSecondRow(int row, int col, int d) {
        if (d == grid[2][2] || d == grid[2][6]) {
            return true;
        } else {
            return false;
        }
    }

    boolean checkFourthRow(int row, int col, int d) {
        if (d == grid[4][1] || d == grid[4][4] || d == grid[4][7]) {
            return true;
        } else {
            return false;
        }
    }

    boolean checkSixthRow(int row, int col, int d) {
        if (d == grid[6][2] || d == grid[6][3 * 2]) {
            return true;
        } else {
            return false;
        }
    }

    boolean checkSeventhRow(int row, int col, int d) {
        if (d == grid[7][4]) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Find the next empty square in "reading order".
     * 
     * @return coordinates of the next empty square
     */
    int[] findEmptySquare() {
        // Variables used in the loop
        int position = 0;
        int row = 0;

        int[] rowEmpty = new int[81]; // int array used to store the empty row values
        int[] colEmpty = new int[81]; // int array used to store the empty column values
        int i = 0; // Variable used to determine
        while (row < 9) {
            while (position < 9) {

                // Checks if the square is empty
                if (grid[row][position] == 0) {

                    /*
                     * Used to increase the number is the array to assign the empty square to a new
                     * place in the array
                     */
                    i++;
                    rowEmpty[i] = row;
                    colEmpty[i] = position;
                    position++;

                    // returns the empty row and column
                    return new int[] { rowEmpty[i], colEmpty[i] };
                } else {
                    position++;
                }
            }
            row = row + 1;
            position = 0;
        }

        return null;
    }

    /**
     * Determine if sudoku is filled in completely or not.
     * 
     * @return true if there are no empty cells left.
     */
    boolean filledSudoku() {

        if (checkBox(1, 0) &&
                checkBox(2, 0) &&
                checkBox(3, 0) &&
                checkBox(4, 3) &&
                checkBox(5, 3) &&
                checkBox(6, 3) &&
                checkBox(7, 4) &&
                checkBox(8, 5) &&
                checkBox(9, 4) && checkRow()) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Checks if the grid is full, by checking each row and column
     * 
     * @return true if every row and column is full
     */
    boolean checkRow() {

        // Variables used to keep count
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int count6 = 0;
        int count7 = 0;
        int count8 = 0;
        int count9 = 0;

        // Two loop to loop through each row and column
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                // Checks the amount of times each number appears
                if (grid[r][c] == 1) {
                    count1++;
                }
                if (grid[r][c] == 2) {
                    count2++;
                }
                if (grid[r][c] == 3) {
                    count3++;
                }
                if (grid[r][c] == 4) {
                    count4++;
                }
                if (grid[r][c] == 5) {
                    count5++;
                }
                if (grid[r][c] == 6) {
                    count6++;
                }
                if (grid[r][c] == 7) {
                    count7++;
                }
                if (grid[r][c] == 8) {
                    count8++;
                }
                if (grid[r][c] == 9) {
                    count9++;
                }
            }
        }

        // Checks if each number appears 9 times
        if ((count1 == 9) && (count2 == 9) && (count3 == 9) && (count4 == 9) && (count5 == 9) && (count6 == 9)
                && (count7 == 9) && (count8 == 9) && (count9 == 9)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks every 3x3 of the Sudoku grid
     * 
     * @param n number of the 3x3
     * @param r row index
     * @return true if everybox is correct
     */

    boolean checkBox(int n, int r) {

        // Start of the 3x3 box
        int min = 0;
        int max = 0;

        // Row
        int row = 0;

        // Colection of if statements used to check and decide the start of the 3x3
        if (r == 4) {
            r = r + 2;
        } else if (r == 5) {
            r = r + 1;
        }
        if (n == 1) {
            row = r;
            min = 0;
            max = 2;
        }
        if (n == 2) {
            row = r;
            min = 3;
            max = 5;
        }
        if (n == 3) {
            row = r;
            min = 6;
            max = 8;
        }

        // Loops for every possible number used in Sudoku (1 to 9)
        for (int i = 1; i < 10; i++) {

            /*
             * Checks if each number is used more than once by using the previous values to
             * start at the start location of the 3x3
             */
            if ((grid[row][min] == i) && (grid[row][min + 1] == i) && (grid[row][min + 2] == i)
                    && (grid[row + 1][min] == i) && (grid[row + 1][min + 1] == i) && (grid[row + 1][min + 2] == i)
                    && (grid[row + 2][min] == i) && (grid[row + 2][min + 1] == i) && (grid[row + 2][min + 2] == i)) {
                return false;
            }
        }

        for (int i = 1; i < 10; i++) {
            if ((grid[row][min] == 0) || (grid[row][min + 1] == 0) || (grid[row][min + 2] == 0)
                    || (grid[row + 1][min] == 0) || (grid[row + 1][min + 1] == 0) || (grid[row + 1][min + 2] == 0)
                    || (grid[row + 2][min] == 0) || (grid[row + 2][min + 1] == 0) || (grid[row + 2][min + 2] == 0)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Gets the row index of the empty square
     * 
     * @return col index
     */
    int getRow() {

        // Checks if the method returns null
        if (findEmptySquare() == null) {
            print();
            return -1;
        }

        // Creates an int array based on the returned values
        int[] readFreeBox = new int[3];
        readFreeBox = findEmptySquare();
        return readFreeBox[0];
    }

    /**
     * Gets the column of the empty square
     * 
     * @return col index
     */
    int getCol() {

        // Checks if the method returns null
        if (findEmptySquare() == null) {
            return -1;
        }

        // Creates an int array based on the returned values
        int[] readFreeBox = new int[3];
        readFreeBox = findEmptySquare();

        return readFreeBox[1];
    }

    /**
     * Gets all the numbers that fits in the given box
     * 
     * @param row row index
     * @param col col index
     * @return ArrayList with numbers that fit
     */
    ArrayList<Integer> numbersLeft(int row, int col) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 9; i > -1; i--) {
            if (!givesConflict(row, col, i)) {
                // print();
                numbers.add(i);
            }
        }
        return numbers;
    }

    /**
     * Find all solutions for the grid.
     * 
     * Stores the final solution.
     */
    void solve() {
        if (completeGrid()) {
            solutionCounter++;
            return;
        } else {
            System.out.println("0");
        }
    }

    /**
     * Checks every number to complete the Sudoku
     * 
     * @return true if a solution is found
     */

    int getC = findEmptySquare()[1];
    int getR = findEmptySquare()[0];
    int n = 1;

    boolean completeGrid() {

        // Return true if the Sudoku if completed
        if (filledSudoku()) {
            return true;
        }

        if (findEmptySquare() == null) {
            return false;
        }

        // Creates an ArrayList with the all the numbers that fit
        ArrayList<Integer> availableNumbers = numbersLeft(getRow(), getCol());

        // Int variable used instead of availableNumbers.size();
        int arrayListSize = availableNumbers.size();

        if (availableNumbers.size() > 0) {
            n = availableNumbers.get(arrayListSize - 1);
        }

        // Makes the array size 8 by adding 0
        if (availableNumbers.size() < 8) {
            while (availableNumbers.size() < 8) {
                availableNumbers.add(1);
            }
        }

        square[] empty = {
                // new square(getRow(), getCol(), availableNumbers.get(8)),
                new square(getRow(), getCol(), 1),
                new square(getRow(), getCol(), 2),
                new square(getRow(), getCol(), 3),
                new square(getRow(), getCol(), 4),
                new square(getRow(), getCol(), 5),
                new square(getRow(), getCol(), 6),
                new square(getRow(), getCol(), 7),
                new square(getRow(), getCol(), 8),
                new square(getRow(), getCol(), 9),
        };

        // For loop to check every empty square with one of the posible values that fits
        for (square next : empty) {

            // If statement used to check for conflicts
            if (!givesConflict(next.row, next.col, next.n)) {

                // Sets the square to the number
                grid[next.row][next.col] = next.n;

                // Boolean value used to run the filledSudoku method and completeGrid method
                boolean solved = completeGrid();

                /*
                 * If statement used to check if backtracking is needed or if the Sudoku is
                 * completed
                 */
                if (solved) {
                    return true; // Return true when the Sudoku is completed

                } else {
                    // Backtracks by makeing the square empty
                    grid[next.row][next.col] = 0;

                }
            }
        }
        return false;
    }

    /**
     * Run the solver and output the results.
     */
    void solveIt() {
        // Solve method
        solve();

        // Checks if the Sudoku is full
        if (filledSudoku()) {

            // Checks if the solution counter is exactly 1
            if (solutionCounter == 1) {
                print(); // Prints the sudoku grid
            } else {
                System.out.println(solutionCounter); // Prints the counter
            }
        }
    }

    public static void main(String[] args) {
        new SudokuSolver().solveIt();
    }
}

// Class to store and get the next squares
class square {
    int row;
    int col;
    int n;

    square(int row, int col, int n) {
        this.row = row;
        this.col = col;
        this.n = n;
    }
}