package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptionsParserTest {
    @Test
    void Test1() {
        String[] args = {"f", "b", "k", "h"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        assertEquals(2, directions.length);
    }

    @Test
    void Test2() {
        String[] args = {"f", "b", "k", "forward", "jump", "foorward", "backward", "r"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        MoveDirection[] out = {MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT};
        assertArrayEquals(out, directions);
    }

    @Test
    void Test3() {
        String[] args = {"forwarrd", "stroll", "left", "l", "go", "backward", "turn", "right"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        MoveDirection[] out = {MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.BACKWARD, MoveDirection.RIGHT};
        assertArrayEquals(out, directions);
    }

}
