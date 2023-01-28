import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Test UniversalAutomaton.
 * 
 * @author Gabriel Leite Savegnago
 * @id 1716255
 * 
 * @author Coman Ioan Alexandru
 * @id 1824694
 */
public class UniversalAutomatonTest {
    UniversalAutomaton automaton = new UniversalAutomaton();

    @Test
    public void testGenToString() {
        String expectedString = "";
        assertEquals("  *", automaton.genToString(new boolean[] {false, false, true}));
        // a mixt of false and true

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
    @Test
    public void testNextGen() {
        boolean[] rules = new boolean[] {false, false, false, false, false, false, false, false};
        boolean[] CurrentGen = new boolean[] {false, false, false, false, false, false, false,
                false, false, false};
        boolean[] NextGen = new boolean[] {false, false, false, false, false, false, false, false,
                false, false};
        assertArrayEquals(NextGen, automaton.nextGen(rules, CurrentGen));
        // checking when all CurrentGen are false

        boolean[] rules2 = new boolean[] {true, true, true, true, true, true, true, true};
        boolean[] CurrentGen2 = new boolean[] {true, true, true, true, true, true, true, true, true,
                true};
        boolean[] NextGen2 = new boolean[] {true, true, true, true, true, true, true, true, true,
                true};
        assertArrayEquals(NextGen2, automaton.nextGen(rules2, CurrentGen2));
        // checking when all CurrentGen are true

        boolean[] rules3 = new boolean[] {true, true, true, true, true, true, true, true};
        boolean[] CurrentGen3 = new boolean[] {true};
        boolean[] NextGen3 = new boolean[] {true};
        assertArrayEquals(NextGen3, automaton.nextGen(rules3, CurrentGen3));
        // checking when only one CurrentGen is true

        boolean[] rules4 = new boolean[] {false, false, false, false, false, false, false, false};
        boolean[] CurrentGen4 = new boolean[] {false};
        boolean[] NextGen4 = new boolean[] {false};
        assertArrayEquals(NextGen4, automaton.nextGen(rules4, CurrentGen4));
        // checking when only one CurrentGen is false

        boolean[] rules5 = new boolean[] {false, false, false, false, false, false, false, false};
        boolean[] CurrentGen5 = new boolean[] {false, false};
        boolean[] NextGen5 = new boolean[] {false, false};
        assertArrayEquals(NextGen5, automaton.nextGen(rules5, CurrentGen5));
        // checking when only two CurrentGen are false

        boolean[] rules6 = new boolean[] {true, true, true, true, true, true, true, true};
        boolean[] CurrentGen6 = new boolean[] {true, true};
        boolean[] NextGen6 = new boolean[] {true, true};
        assertArrayEquals(NextGen6, automaton.nextGen(rules6, CurrentGen6));
        // checking when only two CurrentGen are true

        boolean[] rules7 = new boolean[] {true, true, true, true, true, true, true, true};
        boolean[] CurrentGen7 = new boolean[] {true, true, true};
        boolean[] NextGen7 = new boolean[] {true, true, true};
        assertArrayEquals(NextGen7, automaton.nextGen(rules7, CurrentGen7));
        // checking when only three CurrentGen are true

        boolean[] rules8 = new boolean[] {false, false, false, false, false, false, false, false};
        boolean[] CurrentGen8 = new boolean[] {false, false, false};
        boolean[] NextGen8 = new boolean[] {false, false, false};
        assertArrayEquals(NextGen8, automaton.nextGen(rules8, CurrentGen8));
        // checking when only three CurrentGen are false

        boolean[] rules9 = new boolean[] {false, true, false, true, false, true, false, true};
        boolean[] CurrentGen9 = new boolean[] {false, true, false, true, false, true, false, true,
                false, true};
        boolean[] NextGen9 = new boolean[] {true, false, true, false, true, false, true, false,
                true, false};
        assertArrayEquals(NextGen9, automaton.nextGen(rules9, CurrentGen9));
        // checking when true and false alternate
    }

}