package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        System.out.println("Start");
        run(args);
        System.out.println("Stop");
    }

    public static void run(String[] args) {
        System.out.println("Zwierzak idzie do przodu");
        boolean flag = true;
        for (String i : args) {
            if (flag) {
                System.out.print(i);
                flag = false;
            } else {
                System.out.print(", ");
                System.out.print(i);
            }
        }
        System.out.println();

    }

}

