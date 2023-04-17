package day16.exercise.mvclab.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static java.time.Duration.ofSeconds;

import org.junit.jupiter.api.Test;

class AssertionsDemo {
	@Test
    void testAssertTrue() {
        assertTrue(1 == 1);
        System.out.println("수행될까?-1");
    }
 
    @Test
    void testAssertFalse() {
        assertFalse(1 != 1);
    }
 
    @Test
    void testAssertNull() {
        assertNull(null);
    }
 
    @Test
    void testAssertNotNull() {
        assertNotNull(1);
    }
 
    @Test
    void testAssertEquals() {
        assertEquals(1, 0 + 1);
    }
 
    @Test
    void testAssertThrows() {
        assertThrows(ArithmeticException.class, () -> {int i = 1/0;});
    }
 
    @Test
    void testAssertTimeout() {
        String actualResult = assertTimeout(ofSeconds(1), () -> {
            Thread.sleep(2000);
            return "a result";
        });
 
        assertEquals("a result", actualResult);
    }
    
    @Test
    void testAssertTimeoutPreemptively() {
        String actualResult = assertTimeoutPreemptively(ofSeconds(1), () -> {
        	Thread.sleep(2000);
            return "a result";
        });
 
        assertEquals("a result", actualResult);
        System.out.println("수행될까?-2");
    }
}
