package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        System.out.println("Start");
        run(args);
        System.out.println("Stop");
    }

    public static void run(String[] args) {
        for (String i : args) {
            switch (i) {
                case "f":
                    System.out.println("Zwierzak idzie do przodu");
                    break;
                case "b":
                    System.out.println("Zwierzak idzie do tyłu");
                    break;
                case "r":
                    System.out.println("Zwierzak skręca w prawo");
                    break;
                case "l":
                    System.out.println("Zwierzak skręca w lewo");
                    break;
            }
        }

    }

}

