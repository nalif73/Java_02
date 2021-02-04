package ru.geekbrains.lesson_02;

public class Main {
    public static void main(String[] args) {

        String[][] array = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"},
                {"9", "10", "11", "12"}, {"yy", "14", "15", "16"}};

        try {
            System.out.println("Сумма элементов массива = " + MyArrayMethods.arr2dStrToIntAndSum(array));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
    }
}


