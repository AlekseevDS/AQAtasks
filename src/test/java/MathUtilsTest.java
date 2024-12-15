import org.example.MathUtils;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MathUtilsTest {
    @Test
    public void testValue1() {
        assertEquals(MathUtils.calculateFactorial(1), 1L);
    }

    @Test
    public void testValue20() {
        assertEquals(MathUtils.calculateFactorial(20), 2432902008176640000L);
    }

    @Test
    public void testZeroValue() {
        assertEquals(MathUtils.calculateFactorial(0), 1L);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testMinusValue() {
        MathUtils.calculateFactorial(-1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testValue21() {
        MathUtils.calculateFactorial(21);
    }
}
