package ru.geekbrains.lesson_02;

public class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }

    public MyArraySizeException(String message, Throwable cause) {
        super(message, cause);
    }
}
