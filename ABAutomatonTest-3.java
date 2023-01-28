import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test ABAutomaton.
 * 
 * @author Gabriel Leite Savegnago
 * @id 1716255
 * @author Coman Ioan Alexandru
 * @id 1824694
 */
public class ABAutomatonTest {
    ABAutomaton automaton = new ABAutomaton();

    @Test
    public void testGenToString() {
        String expectedString = "";
        assertEquals("  *", automaton.genToString(new boolean[] {false, false, true}));
        // a mix of true and false

        assertEquals("          ", automaton.genToString(new boolean[] {false, false, false, false,
                false, false, false, false, false, false}));
        // test for multiple false values

        assertEquals("*        *", automaton.genToString(new boolean[] {true, false, false, false,
                false, false, false, false, false, true}));
        // test for when the first value in the array is true and the last value is also true

        assertEquals(" ******** ", automaton.genToString(
                new boolean[] {false, true, true, true, true, true, true, true, true, false}));
        // test for when the first value in the array is true and the last value is also true

        boolean[] gen = new boolean[100];
        int i = 0;
        while (i < gen.length) {
            if (i < 50) {
                gen[i] = true;
                expectedString = expectedString + "*";

                i++;
            } else {
                gen[i] = false;
                expectedString = expectedString + " ";
                i++;
            }
        }
        assertEquals(expectedString, automaton.genToString(gen));
    }
    // test for when the first value in the array is true and the last value is also true

    // Add at least 5 test cases.
    // Motivate each test case with a line comment like this.

    @Test
    public void testNextGenA() {
        boolean[] CurrentGen = new boolean[] {false, false, false, false, false, false, false,
                false, false, false};
        boolean[] NextGen = new boolean[] {false, false, false, false, false, false, false, false,
                false, false};
        assertArrayEquals(NextGen, automaton.nextGenA(CurrentGen));
        // checking when all CurrentGen are false

        boolean[] CurrentGen2 = new boolean[] {false, false, false, false, false, true, false,
                false, false, false, false};
        boolean[] NextGen2 = new boolean[] {false, false, false, false, true, false, true, false,
                false, false, false};
        assertArrayEquals(NextGen2, automaton.nextGenA(CurrentGen2));
        // checking when all CurrentGen are true exept the middle

        boolean[] CurrentGen3 = new boolean[] {true, true};
        boolean[] NextGen3 = new boolean[] {true, true};
        assertArrayEquals(NextGen3, automaton.nextGenA(CurrentGen3));
        // checking when only two CurrentGen are true

        boolean[] CurrentGen4 = new boolean[] {false, false};
        boolean[] NextGen4 = new boolean[] {false, false};
        assertArrayEquals(NextGen4, automaton.nextGenA(CurrentGen4));
        // checking when only two CurrentGen are false

        boolean[] CurrentGen5 = new boolean[] {false};
        boolean[] NextGen5 = new boolean[] {false};
        assertArrayEquals(NextGen5, automaton.nextGenA(CurrentGen5));
        // checking when only one Currentgen is false

        boolean[] CurrentGen6 = new boolean[] {true};
        boolean[] NextGen6 = new boolean[] {false};
        assertArrayEquals(NextGen6, automaton.nextGenA(CurrentGen6));
        // checking when only one Currentgen is true

        boolean[] CurrentGen7 = new boolean[] {true, true, true, true, true, true, true, true, true,
                true};
        boolean[] NextGen7 = new boolean[] {true, false, false, false, false, false, false, false,
                false, true};
        assertArrayEquals(NextGen7, automaton.nextGenA(CurrentGen7));
        // checking when all CurrentGen are true

        boolean[] CurrentGen8 = new boolean[] {true, false, true, false, true, false, true, false,
                true, false};
        boolean[] NextGen8 = new boolean[] {false, true, false, true, false, true, false, true,
                false, true};
        assertArrayEquals(NextGen8, automaton.nextGenA(CurrentGen8));
        // checking when true and false alternate in CurrentGen

        // Add at least 8 test cases.
        // Motivate each test case with a line comment like this.
    }

    @Test
    public void testNextGenB() {
        boolean[] CurrentGen = new boolean[] {false, false, false, false, false, false, false,
                false, false, false};
        boolean[] NextGen = new boolean[] {false, false, false, false, false, false, false, false,
                false, false};
        assertArrayEquals(NextGen, automaton.nextGenB(CurrentGen));
        // checking when all CurrentGen are false

        boolean[] CurrentGen2 = new boolean[] {false, false, false, false, false, true, false,
                false, false, false, false};
        boolean[] NextGen2 = new boolean[] {false, false, false, false, true, true, true, false,
                false, false, false};
        assertArrayEquals(NextGen2, automaton.nextGenB(CurrentGen2));
        // checking when all CurrentGen are false exept the middle

        boolean[] CurrentGen3 = new boolean[] {true, true};
        boolean[] NextGen3 = new boolean[] {false, true};
        assertArrayEquals(NextGen3, automaton.nextGenB(CurrentGen3));
        // checking when only two CurrentGen are true

        boolean[] CurrentGen4 = new boolean[] {false, false};
        boolean[] NextGen4 = new boolean[] {false, false};
        assertArrayEquals(NextGen4, automaton.nextGenB(CurrentGen4));
        // checking when only two CurrentGen are false

        boolean[] CurrentGen5 = new boolean[] {false};
        boolean[] NextGen5 = new boolean[] {false};
        assertArrayEquals(NextGen5, automaton.nextGenB(CurrentGen5));
        // checking when only one Currentgen is false

        boolean[] CurrentGen6 = new boolean[] {true};
        boolean[] NextGen6 = new boolean[] {true};
        assertArrayEquals(NextGen6, automaton.nextGenB(CurrentGen6));
        // checking when only one Currentgen is true

        boolean[] CurrentGen7 = new boolean[] {true, true, true, true, true, true, true, true, true,
                true};
        boolean[] NextGen7 = new boolean[] {false, false, false, false, false, false, false, false,
                false, true};
        assertArrayEquals(NextGen7, automaton.nextGenB(CurrentGen7));
        // checking when all CurrentGen are true

        boolean[] CurrentGen8 = new boolean[] {true, false, true, false, true, false, true, false,
                true, false};
        boolean[] NextGen8 = new boolean[] {true, false, true, false, true, false, true, false,
                true, true};
        assertArrayEquals(NextGen8, automaton.nextGenB(CurrentGen8));
        // checking when true and false alternate in CurrentGen
        // Add at least 8 test cases.
        // Motivate each test case with a line comment like this.
    }
}