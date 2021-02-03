package ru.geekbrains.lesson_01;

public class Team {
    private String name;
    private Member[] members;

    public Team(String name, Member... members) {
        this.name = name;
        this.members = members;
    }

    public void printName() {
        System.out.println("Команда " + name);
    }

    public Member[] getMembers() {
        return members;
    }

    public void printMembers() {
        for (Member member : members) {
            System.out.println(member);
        }
    }

    public void showResults() {
        for (Member member : members) {
            if (member.isResult()) System.out.println(member + " прошел полосу препятствий");
              else System.out.println(member + " не прошел полосу препятствий");
        }
    }

}
