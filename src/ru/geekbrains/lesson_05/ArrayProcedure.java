package ru.geekbrains.lesson_05;

import java.util.Arrays;

public class ArrayProcedure {
    static final int size = 10000000;
    static final int h = size / 2;
    float[] arr = new float[size];

    public void firstMethod() {
        Arrays.fill(arr, 1);
        long timeMillis1 = System.currentTimeMillis();
        updateArrray(arr);
        long timeMillis2 = System.currentTimeMillis();
        System.out.println("First method time: " + (timeMillis2 - timeMillis1));
    }

    public void secondMethod() {
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        long timeMillis1 = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread thread1 = new Thread(() -> {
            updateArrray(a1);
            System.arraycopy(a1, 0, arr, 0, h);

        });
        Thread thread2 = new Thread(() -> {
            updateArrray(a2);
            System.arraycopy(a2, 0, arr, h, h);

        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        long timeMillis2 = System.currentTimeMillis();
        System.out.println("Second method time: " + (timeMillis2 - timeMillis1));

    }

    public void updateArrray(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
