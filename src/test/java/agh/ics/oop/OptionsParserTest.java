package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptionsParserTest {
    @Test
    void Test1() {
        try {
            String[] args = {"f", "b", "k", "h"};
            MoveDirection[] directions = new OptionsParser().parse(args);
        }
        catch (IllegalArgumentException ex){
            assertEquals("k is not legal move specification", ex.getMessage());
        }
    }

    @Test
    void Test2() {
        String[] args = {"f", "b", "forward", "backward", "r"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        MoveDirection[] out = {MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT};
        assertArrayEquals(out, directions);
    }

    @Test
    void Test3() {
        try{
            String[] args = {"left", "l", "go", "backward", "turn", "right"};
            MoveDirection[] directions = new OptionsParser().parse(args);
        }
        catch (IllegalArgumentException ex){
            assertEquals("go is not legal move specification", ex.getMessage());
        }

    }

}
