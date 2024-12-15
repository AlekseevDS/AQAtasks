package org.example;

public class MathUtils {
    public static long calculateFactorial(int value) throws IllegalArgumentException {
        if (value < 0) {
            throw new IllegalArgumentException("Факториал не определён для отрицательных чисел.");
        }
        if (value > 20) {
            throw new IllegalArgumentException("Метод расчитан на числа от 0 до 20(вкл).");
        }
        long result = 1L;
        for (int i = value; i > 1; i--) {
            result *= i;
        }
        return result;
    }
}
