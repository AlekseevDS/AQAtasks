import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(compareRangeNumbers(3, 11));
        printPositiveNegativeNum(5);
        System.out.println(isNegativeNum(-9));
        printString("example", 5);
        System.out.println(isLeapYear(2024));
        invertBinaryArray();
        hundredArray();
        updateArray();
        diagonalArray();
        System.out.println(Arrays.toString(initArray(6, 10)));
    }

    static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    static void checkSumSign() {
        int a = 2;
        int b = 7;
        int result = a + b;

        if (result >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    static void printColor() {
        int value = 445;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else if (value > 100) {
            System.out.println("Зеленый");
        }

    }

    static void compareNumbers() {
        int a = 8;
        int b = 40;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    static boolean compareRangeNumbers(int firstNum, int secNum) {
        return (firstNum + secNum) > 10 && (firstNum + secNum) <= 20;
    }

    static void printPositiveNegativeNum(int value) {
        if (value < 0) {
            System.out.println("Число отрицательное");
        } else {
            System.out.println("Число положительное");
        }
    }

    static boolean isNegativeNum(int value) {
        return (value < 0);
    }

    static void printString(String text, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }

    static boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        }
        if (year % 400 == 0) {
            return true;
        }
        return false;
    }

    static void invertBinaryArray() {
        int[] binaryArray = {0, 1, 0, 0, 0, 1, 0, 1};
        int[] invertedArray = new int[8];

        for (int i = 0; i < binaryArray.length; i++) {
            if (binaryArray[i] == 0) {
                invertedArray[i] = 1;
            } else {
                invertedArray[i] = 0;
            }
        }

        System.out.println(Arrays.toString(binaryArray));
        System.out.println(Arrays.toString(invertedArray));
    }

    static void hundredArray() {
        int[] initArray = new int[100];

        for (int i = 0; i < initArray.length; i++) {
            initArray[i] = i + 1;
        }
        System.out.println(Arrays.toString(initArray));
    }

    static void updateArray() {
        int[] initArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[] updatedArray = new int[initArray.length];

        for (int i = 0; i < initArray.length; i++) {
            if (initArray[i] < 6) {
                updatedArray[i] = initArray[i] * 2;
            } else {
                updatedArray[i] = initArray[i];
            }
        }
        System.out.println(Arrays.toString(initArray));
        System.out.println(Arrays.toString(updatedArray));
    }

    static void diagonalArray() {
        int[][] initArray = new int[10][10];
        int[][] diagonalArray = new int[10][10];

        for (int i = 0; i < initArray.length; i++) {
            diagonalArray[i][i] = 1;
            diagonalArray[i][initArray[i].length - i - 1] = 1;
        }

        for (int i = 0; i < initArray.length; i++) {
            for (int j = 0; j < initArray[i].length; j++) {
                System.out.print(diagonalArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[] initArray(int len, int initialValue) {
        int[] initArray = new int[len];

        for (int i = 0; i < initArray.length; i++) {
            initArray[i] = initialValue;
        }

        return initArray;
    }
}
