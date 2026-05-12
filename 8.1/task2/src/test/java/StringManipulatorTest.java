import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class StringManipulatorTest {

    private final StringManipulator sm = new StringManipulator();

    @Test
    void testConcatenate() {
		System.out.println("Running testConcatenate()");	
        assertEquals("HelloWorld", sm.concatenate("Hello", "World"));
    }

    @Test
    void testFindLength() {
		System.out.println("Running testFindLength()");
        assertEquals(5, sm.findLength("Hello"));
        assertEquals(0, sm.findLength(""));
    }

    @Test
    void testToUpper() {
		System.out.println("Running testToUpper()");
        assertEquals("HELLO", sm.toUpper("hello"));
    }

    @Test
    void testToLower() {
		System.out.println("Running testToLower()");
        assertEquals("world", sm.toLower("WORLD"));
    }

    @Test
    void testContainsSubStr() {
		System.out.println("Running testContainsSubStr()");
        assertTrue(sm.containsSubStr("Hello World", "World"));
        assertFalse(sm.containsSubStr("Hello World", "Java"));
    }
}
