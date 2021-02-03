package ru.geekbrains.lesson_01;

public class Human extends Member  {
    public Human(String name, int age) {
        super(name, age);
    }

    @Override
    public boolean jump() {
        System.out.println("Человек по имени " + getName() + " перепрыгнул");
        return true;
    }

    @Override
    public boolean run() {
        System.out.println("Человек по имени " + getName() + " пробежал");
        return true;
    }

    @Override
    public boolean swim() {
        System.out.println("Человек по имени " + getName() + " проплыл");
        return true;
    }

    @Override
    public String toString() {
        return "Человек: " +
                "Имя - " + getName() +
                ", Возраст " + getAge();
    }
}
