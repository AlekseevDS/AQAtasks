import org.example.MathUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathUtilsTest {

    @Test
    void testValue1() {
        assertEquals(1L, MathUtils.calculateFactorial(1));
    }

    @Test
    void testValue20() {
        assertEquals(2432902008176640000L, MathUtils.calculateFactorial(20));
    }

    @Test
    void testZeroValue() {
        assertEquals(1L, MathUtils.calculateFactorial(0));
    }

    @Test
    void testMinusValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            MathUtils.calculateFactorial(-1);});
    }

    @Test
    void testValue21() {
        assertThrows(IllegalArgumentException.class, () -> {
            MathUtils.calculateFactorial(21);});
    }
}