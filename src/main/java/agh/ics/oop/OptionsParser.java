package agh.ics.oop;

import java.util.Arrays;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args) throws IllegalArgumentException {
        MoveDirection[] dir = new MoveDirection[args.length];
        int j = 0;
        for (String i : args) {
            switch (i) {
                case "f", "forward" -> dir[j] = MoveDirection.FORWARD;
                case "b", "backward" -> dir[j] = MoveDirection.BACKWARD;
                case "r", "right" -> dir[j] = MoveDirection.RIGHT;
                case "l", "left" -> dir[j] = MoveDirection.LEFT;
                default -> throw new IllegalArgumentException(i + " is not legal move specification");
            }
            j += 1;
        }
        return Arrays.copyOfRange(dir, 0, j);
    }

}
