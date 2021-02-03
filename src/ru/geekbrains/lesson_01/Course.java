package ru.geekbrains.lesson_01;

public class Course {
    enum Obstacles {
        TRACK, WALL, WATER
    }

    private Obstacles[] obstacles;

    public Course(Obstacles... obstacles) {
        this.obstacles = obstacles;
    }

    public void printObstacles() {
        System.out.print("На полосе припятствий ");
        for (Obstacles o : obstacles) {
            System.out.print(o + " ");
        }
        System.out.println();
    }

    public void passCourse(Team team) {
        Member[] members = team.getMembers();
        for (Member member : members) {
            System.out.println("Участник " + member.getName() + " начинает проходить полосу препятствий");
            for (Obstacles obstacle : obstacles) {
                if (obstacle == Obstacles.TRACK)
                    member.setResult(member.run());

                if (obstacle == Obstacles.WALL)
                    member.setResult(member.jump());

                if (obstacle == Obstacles.WATER)
                    member.setResult(member.swim());

                if (!member.isResult()) break;

            }

        }


    }
}
