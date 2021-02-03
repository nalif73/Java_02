package ru.geekbrains.lesson_01;

public class Cat extends Member {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public boolean jump() {
        System.out.println("Кот по имени " + getName() + " перепрыгнул");
        return true;
    }

    @Override
    public boolean run() {
         System.out.println("Кот по имени " + getName() + " пробежал");
        return true;
    }

    @Override
    public boolean swim() {
        System.out.println("Коты не умеют плавать. Это конец");
        return false;
    }

    @Override
    public String toString() {
        return "Кот: " +
                "Имя - " + getName() +
                ", Возраст " + getAge();
    }
}
