public class Main {
    public static void main(String[] args) {
        String[][][] arrayOfArrays = {
                {
                        {"1", "2", "3", "4"},
                        {"7", "6", "5", "4"},
                        {"88", "4", "5", "0"},
                        {"9", "4", "3", "2"}
                },
                {
                        {"4", "3", "4", "55"},
                        {"x", "3", "2", "1"},
                        {"4", "4", "4", "5"},
                        {"2", "3", "2", "6"}
                },
                {
                        {"", "", "", ""},
                        {"", "", "", ""},
                        {"", "", "", ""},
                        {"", "", ""}
                }
        };

        for (String[][] testArrayOfArray : arrayOfArrays) {
            try {
                System.out.println("Сумма элементов массива равна: " + sumArray(testArrayOfArray));
            } catch (MyArraySizeException | MyArrayDataException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int sumArray(String[][] strArr) throws MyArraySizeException, MyArrayDataException {
        int result = 0;

        if (strArr.length != 4) {
            throw new MyArraySizeException("Массив не соответствует размеру 4х4 (по строкам)." +
                    " Вычисление не выполнено.");
        }

        for (String[] strings : strArr) {
            if (strings.length != 4) {
                throw new MyArraySizeException("Массив не соответствует размеру 4х4 (по столбцам)." +
                        " Вычисление не выполнено.");
            }
        }

        for (int i = 0; i < strArr.length; i++) {
            for (int j = 0; j < strArr[i].length; j++) {
                try {
                    result += Integer.parseInt(strArr[i][j]);
                } catch (NumberFormatException e) {

                    throw new MyArrayDataException("Элемент в ячейке [" + i + "]" + "[" + j + "] " +
                            "невозможно преобразовать в число." + " Вычисление не выполнено.");
                }
            }
        }
        return result;
    }
}