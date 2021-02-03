package ru.geekbrains.lesson_01;

public abstract class Member implements  Run, Jump, Swim {
    private String name;
    private int age;
    private boolean result;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

}
