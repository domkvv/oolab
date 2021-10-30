package agh.ics.oop;

import java.util.Arrays;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args) {
        MoveDirection[] dir = new MoveDirection[args.length];
        int j = 0;
        boolean flag = true;
        for (String i : args) {
            switch (i) {
                case "f", "forward" -> dir[j] = MoveDirection.FORWARD;
                case "b", "backward" -> dir[j] = MoveDirection.BACKWARD;
                case "r", "right" -> dir[j] = MoveDirection.RIGHT;
                case "l", "left" -> dir[j] = MoveDirection.LEFT;
                default -> flag = false;
            }
            if (flag) j += 1;
            else flag = true;
        }

        return Arrays.copyOfRange(dir, 0, j);
    }

}
