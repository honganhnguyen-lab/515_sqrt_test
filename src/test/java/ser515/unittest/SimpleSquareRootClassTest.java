package ser515.unittest;

// static imports are just a scoping mechanism for static members of an imported class
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.BeforeEach;

// Same example except noww we are testing a non-static, and requirees us to set object state usin BeforeEach
class SimpleSquareRootClassTest {

    SimpleSquareRootClass myX;

    // This executes once before each test. BeforeAll executes once before ALL tests
    @BeforeEach
    void beforeEach() {
        myX = new SimpleSquareRootClass(1);
    }
    // There are also @AfterEach and @AfterAll with expected semantics. Usually these would do cleanup, such as
    // resetting object state after a test (each) or cleaning up hardresources like database connection (All)

    @Test
    void testMakeSqrt() {
        assertEquals(0.0, myX.makeSqrt());
    }


    @Test
    void testSquareRootOfPositiveNumber() {
        assertEquals(3, SimpleSquareRootFunction.makeSqrt(9), 0.001, "Square root of 9 should be 3");
        assertEquals(5, SimpleSquareRootFunction.makeSqrt(25), 0.001, "Square root of 25 should be 5");
    }

    @Test
    void testSquareRootOfZero() {
        assertEquals(0, SimpleSquareRootFunction.makeSqrt(0), 0.001, "Square root of 0 should be 0");
    }

    @Test
    void testSquareRootOfNonPerfectSquare() {
        assertEquals(2.236, SimpleSquareRootFunction.makeSqrt(5), 0.001, "Square root of 5 should be close to 2.236");
    }

    @Test
    void testSquareRootOfNegativeNumber() {
        assertTrue(Double.isNaN(SimpleSquareRootFunction.makeSqrt(-4)), "Square root of a negative number should return NaN");
    }
}