package ru.geekbrains.lesson_01;

public class Robot extends Member {
    public Robot(String name, int age) {
        super(name, age);
    }

    @Override
    public boolean run() {
        System.out.println("Робот по имени " + getName() + " пробежал");
        return true;
    }

    @Override
    public boolean jump() {
        System.out.println("Роботы не умеют прыгать. Это конец");
        return false;
    }

    @Override
    public boolean swim() {
        System.out.println("Роботы не умеют плавать. Это конец");
        return false;
    }

    @Override
    public String toString() {
        return "Робот: " +
                "Имя - " + getName() +
                ", Возраст " + getAge();
    }
}
