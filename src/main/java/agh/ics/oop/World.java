package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

public class World {

    public static void main(String[] args) {

        Application.launch(App.class, args);
//        try {
//            MoveDirection[] directions = new OptionsParser().parse(args);
//            IWorldMap map = new GrassField(10);
//            System.out.println(map.toString());
//            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
//            IEngine engine = new SimulationEngine(directions, map, positions);
//            System.out.println(map.toString());
//            engine.run();
//            System.out.println(map.toString());
//
//        } catch (IllegalArgumentException ex) {
//            System.out.println(ex.getMessage());
//        }
    }

    public static Direction[] change(String[] args) {
        Direction[] directions = new Direction[args.length];
        int j = 0;
        for (String i : args) {
            switch (i) {
                case "f":
                    directions[j] = Direction.FORWARD;
                    break;
                case "b":
                    directions[j] = Direction.BACKWARD;
                    break;
                case "r":
                    directions[j] = Direction.RIGHT;
                    break;
                case "l":
                    directions[j] = Direction.LEFT;
                    break;
                default:
                    directions[j] = null;
                    break;
            }
            j += 1;
        }
        return directions;
    }

    public static void run(Direction[] args) {
        for (Direction i : args) {
            if (i != null) {
                switch (i) {
                    case FORWARD:
                        System.out.println("Zwierzak idzie do przodu");
                        break;
                    case BACKWARD:
                        System.out.println("Zwierzak idzie do tyłu");
                        break;
                    case RIGHT:
                        System.out.println("Zwierzak skręca w prawo");
                        break;
                    case LEFT:
                        System.out.println("Zwierzak skręca w lewo");
                        break;
                }
            }
        }

    }

}







