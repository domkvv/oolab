package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        System.out.println("Start");
        Direction[] directions = change(args);
        run(directions);
        System.out.println("Stop");

        Vector2d position1 = new Vector2d(1, 2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2, 1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        MapDirection direction = MapDirection.NORTH;
        System.out.println(direction.toString());
        System.out.println(direction.next());
        System.out.println(direction.previous());
        System.out.println(direction.toUnitVector());

        Animal cheburashka = new Animal();
        System.out.println(cheburashka);
        cheburashka.move(MoveDirection.RIGHT);
        cheburashka.move(MoveDirection.FORWARD);
        cheburashka.move(MoveDirection.FORWARD);
        cheburashka.move(MoveDirection.FORWARD);
        System.out.println(cheburashka);

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







