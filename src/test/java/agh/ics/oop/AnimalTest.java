package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {

    @Test
    void Test1() {
        RectangularMap map = new RectangularMap(3, 3);
        Animal experimental_bunny = new Animal(map);
        String[] args = {"l", "f", "f", "r", "b", "r", "r"};
        MoveDirection[] directions = OptionsParser.parse(args);
        for (MoveDirection i : directions) experimental_bunny.move(i);
        assertEquals(new Vector2d(0, 1), experimental_bunny.getPosition());
        assertEquals(MapDirection.SOUTH, experimental_bunny.getOrientation());
    }

    @Test
    void Test2() {
        RectangularMap map = new RectangularMap(4, 5);
        Animal experimental_bunny = new Animal(map, new Vector2d(1, 0));
        String[] args = {"l", "f", "f", "f", "l", "l"};
        MoveDirection[] directions = OptionsParser.parse(args);
        for (MoveDirection i : directions) experimental_bunny.move(i);
        assertEquals(new Vector2d(0, 0), experimental_bunny.getPosition());
        assertEquals(MapDirection.EAST, experimental_bunny.getOrientation());
    }

    @Test
    void Test3() {
        RectangularMap map = new RectangularMap(10, 10);
        Animal experimental_bunny = new Animal(map, new Vector2d(9, 2));
        String[] args = {"right", "f", "backward", "b", "b", "right", "r", "l"};
        MoveDirection[] directions = OptionsParser.parse(args);
        for (MoveDirection i : directions) experimental_bunny.move(i);
        assertEquals(new Vector2d(6, 2), experimental_bunny.getPosition());
        assertEquals(MapDirection.SOUTH, experimental_bunny.getOrientation());
    }

}
