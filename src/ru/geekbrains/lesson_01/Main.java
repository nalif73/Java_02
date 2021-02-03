package ru.geekbrains.lesson_01;

public class Main {
    public static void main(String[] args) {

        Member[] members = {new Human("Вася", 40), new Robot("Вэртер", 7),
                new Cat("Пушок", 4), new Human("Коля", 22)};

        Team team = new Team("Ракета", members);
        team.printName();
        team.printMembers();

        Course course = new Course(Course.Obstacles.TRACK, Course.Obstacles.WALL, Course.Obstacles.WATER);
        course.printObstacles();
        course.passCourse(team);

        team.showResults();
    }


}
