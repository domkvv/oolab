package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangularMapTest {
    @Test
    void Test1() {
        IWorldMap map = new RectangularMap(11, 8);
        String[] args = {"l", "f", "l", "f", "f", "f", "f", "r", "f", "f", "f", "r", "f", "r", "f"};
        Vector2d[] positions = {new Vector2d(6, 7)};
        MoveDirection[] directions = OptionsParser.parse(args);
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        String out = " y\\x  0 1 2 3 4 5 6 7 8 910\r\n" +
                     "  8: -----------------------\r\n" +
                     "  7: | | | | | | | | | | | |\r\n" +
                     "  6: | | | | | | | | | | | |\r\n" +
                     "  5: | | | | | | | | | | | |\r\n" +
                     "  4: | | | |>| | | | | | | |\r\n" +
                     "  3: | | | | | | | | | | | |\r\n" +
                     "  2: | | | | | | | | | | | |\r\n" +
                     "  1: | | | | | | | | | | | |\r\n" +
                     "  0: | | | | | | | | | | | |\r\n" +
                     " -1: -----------------------\r\n";
        assertEquals(out, map.toString());
    }

    @Test
    void Test2() {
        IWorldMap map = new RectangularMap(2, 2);
        String[] args = {"f", "f", "r", "b", "f", "l", "r", "f"};
        Vector2d[] positions = {new Vector2d(1, 1), new Vector2d(0, 0)};
        MoveDirection[] directions = OptionsParser.parse(args);
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        String out = " y\\x  0 1\r\n" +
                     "  2: -----\r\n" +
                     "  1: | |v|\r\n" +
                     "  0: |<| |\r\n" +
                     " -1: -----\r\n";
        assertEquals(out, map.toString());
    }

    @Test
    void Test3() {
        IWorldMap map = new RectangularMap(8, 3);
        String[] args = {"r", "b", "f", "f", "r", "r", "f", "f", "f", "l", "f", "l", "f", "f", "b", "r", "r", "b"};
        Vector2d[] positions = {new Vector2d(2, 0), new Vector2d(3, 2), new Vector2d(6, 1)};
        MoveDirection[] directions = OptionsParser.parse(args);
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        String out = " y\\x  0 1 2 3 4 5 6 7\r\n" +
                     "  3: -----------------\r\n" +
                     "  2: | | | | | | | | |\r\n" +
                     "  1: | | | | |>| |v| |\r\n" +
                     "  0: | | | | | | | |^|\r\n" +
                     " -1: -----------------\r\n";
        assertEquals(out, map.toString());
    }

}






