
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Heather on 10/5/2016.
 */

// note, I did a lot of assertEquals tests, you do not need that many so
// feel free to delete some of the methods that basically do the same
// testing

public class JUnitTest {
    JUnit junit = new JUnit();

    @Test
    public void addFiveTest(){
        assertEquals(10.0, junit.addFive(5));
        assertNotNull(junit);
    }

    @Test
    public void subtractSevenTest (){
        assertEquals(-7.0, junit.subtractSeven(0));
    }

    @Test
    public void divideTwoTest(){
        assertEquals(3.5, junit.divideTwo(7));
    }

    @Test
    public void multiplyThreeTest(){
        assertEquals(6.0, junit.multiplyThree(2));
    }

    @Test
    public void helloWorldTest(){
        assertEquals("hello", junit.helloWorld("hello"));
    }

    @Test
    public void containsLetterATest(){
        assertFalse(junit.containsLetterA("hello"));
        assertTrue(junit.containsLetterA("jumbalaya"));
    }

    @Test
    public void arrayTest() {
        assertArrayEquals(new int[]{3,4,5}, junit.array(3,4,5));
        assertArrayEquals(new int[]{1,2,3}, junit.array(1,2,3));
    }

    @Test
    public void nullMethodTest() {
        assertNull(junit.nullMethod());
    }


    @Test (expected = NullPointerException.class)
    public void throwExceptionMessageTest() {
        junit.throwExceptionMessage();
    }
}
