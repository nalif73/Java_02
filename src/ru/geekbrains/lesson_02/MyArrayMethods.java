package ru.geekbrains.lesson_02;

import java.util.Arrays;

public class MyArrayMethods {
    public static int arr2dStrToIntAndSum(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (!(array.length == 4) && (array[0].length == 4)) {
            throw new MyArraySizeException(String.format("Размер переданного массива [%sx%s] не соответствует" +
                    " требуемому [4х4]", array.length, array[0].length));
        }
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("Ошибка преобразования String в Int" +
                            " в ячейке [%sx%s] массива", i+1, j+1));
                }
            }
        }
        return sum;
    }
}
