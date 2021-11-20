package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IWorldMapTest {
    @Test
    void TestPlaceRectangularMap1() {
        IWorldMap map = new RectangularMap(10, 8);
        Animal[] animals = {new Animal(map, new Vector2d(1, 1)), new Animal(map, new Vector2d(5, 2)), new Animal(map, new Vector2d(3, 7))};
        for (Animal i : animals) {
            map.place(i);
        }
        String out = " y\\x  0 1 2 3 4 5 6 7 8 9\r\n" +
                     "  8: ---------------------\r\n" +
                     "  7: | | | |^| | | | | | |\r\n" +
                     "  6: | | | | | | | | | | |\r\n" +
                     "  5: | | | | | | | | | | |\r\n" +
                     "  4: | | | | | | | | | | |\r\n" +
                     "  3: | | | | | | | | | | |\r\n" +
                     "  2: | | | | | |^| | | | |\r\n" +
                     "  1: | |^| | | | | | | | |\r\n" +
                     "  0: | | | | | | | | | | |\r\n" +
                     " -1: ---------------------\r\n";
        assertEquals(out, map.toString());
    }

    @Test
    void TestPlaceRectangularMap2() {
        IWorldMap map = new RectangularMap(10, 4);
        Animal[] animals = {new Animal(map, new Vector2d(7, 1)), new Animal(map, new Vector2d(3, 2)), new Animal(map, new Vector2d(3, 2))};
        for (Animal i : animals) {
            map.place(i);
        }
        String out = " y\\x  0 1 2 3 4 5 6 7 8 9\r\n" +
                     "  4: ---------------------\r\n" +
                     "  3: | | | | | | | | | | |\r\n" +
                     "  2: | | | |^| | | | | | |\r\n" +
                     "  1: | | | | | | | |^| | |\r\n" +
                     "  0: | | | | | | | | | | |\r\n" +
                     " -1: ---------------------\r\n";
        assertEquals(out, map.toString());
    }

    @Test
    void TestPlaceGrassField1() {
        IWorldMap map = new GrassField(0);
        Animal[] animals = {new Animal(map, new Vector2d(3, 2)), new Animal(map, new Vector2d(2, 2))};
        for (Animal i : animals) {
            map.place(i);
        }
        String out = " y\\x  2 3\r\n" +
                     "  3: -----\r\n" +
                     "  2: |^|^|\r\n" +
                     "  1: -----\r\n";
        assertEquals(out, map.toString());
    }

    @Test
    void TestPlaceGrassField2() {
        IWorldMap map = new GrassField(0);
        Animal[] animals = {new Animal(map, new Vector2d(0, 6)), new Animal(map, new Vector2d(5, 1)), new Animal(map, new Vector2d(0, 6))};
        for (Animal i : animals) {
            map.place(i);
        }
        String out = " y\\x  0 1 2 3 4 5\r\n" +
                     "  7: -------------\r\n" +
                     "  6: |^| | | | | |\r\n" +
                     "  5: | | | | | | |\r\n" +
                     "  4: | | | | | | |\r\n" +
                     "  3: | | | | | | |\r\n" +
                     "  2: | | | | | | |\r\n" +
                     "  1: | | | | | |^|\r\n" +
                     "  0: -------------\r\n";
        assertEquals(out, map.toString());
    }

    @Test
    void TestIsOccupiedRectangularMap() {
        IWorldMap map = new RectangularMap(10, 8);
        Animal[] animals = {new Animal(map, new Vector2d(1, 1)), new Animal(map, new Vector2d(5, 2)), new Animal(map, new Vector2d(3, 7))};
        for (Animal i : animals) {
            map.place(i);
        }
        assertEquals(true, map.isOccupied(new Vector2d(5, 2)));
        assertEquals(false, map.isOccupied(new Vector2d(1, 2)));
    }

    @Test
    void TestIsOccupiedGrassField() {
        IWorldMap map = new GrassField(0);
        Animal[] animals = {new Animal(map, new Vector2d(3, 2)), new Animal(map, new Vector2d(2, 2))};
        for (Animal i : animals) {
            map.place(i);
        }
        assertEquals(false, map.isOccupied(new Vector2d(2, 3)));
        assertEquals(true, map.isOccupied(new Vector2d(3, 2)));
        assertEquals(true, map.isOccupied(new Vector2d(2, 2)));
    }

    @Test
    void TestCanMoveToRectangularMap() {
        IWorldMap map = new RectangularMap(10, 8);
        Animal[] animals = {new Animal(map, new Vector2d(1, 1)), new Animal(map, new Vector2d(5, 2)), new Animal(map, new Vector2d(3, 7))};
        for (Animal i : animals) {
            map.place(i);
        }
        assertEquals(false, map.canMoveTo(new Vector2d(5, 2)));
        assertEquals(true, map.canMoveTo(new Vector2d(6, 2)));
    }

    @Test
    void TestCanMoveToGrassField() {
        IWorldMap map = new GrassField(16);
        Animal[] animals = {new Animal(map, new Vector2d(1, 1)), new Animal(map, new Vector2d(7, 8))};
        for (Animal i : animals) {
            map.place(i);
        }
        assertEquals(false, map.canMoveTo(new Vector2d(1, 1)));
        assertEquals(true, map.canMoveTo(new Vector2d(7, 2)));
        assertEquals(true, map.canMoveTo(new Vector2d(2, 2)));
    }

    @Test
    void TestObjectAtRectangularMap() {
        IWorldMap map = new RectangularMap(6, 4);
        Animal[] animals = {new Animal(map, new Vector2d(0, 1)), new Animal(map, new Vector2d(4, 2))};
        for (Animal i : animals) {
            map.place(i);
        }
        assertEquals(animals[0], map.objectAt(new Vector2d(0, 1)));
        assertEquals(null, map.objectAt(new Vector2d(6, 2)));
        assertEquals(null, map.objectAt(new Vector2d(2, 2)));
    }

    @Test
    void TestObjectAtGrassField() {
        IWorldMap map = new GrassField(0);
        Animal[] animals = {new Animal(map, new Vector2d(9, 9)), new Animal(map, new Vector2d(0, 20))};
        for (Animal i : animals) {
            map.place(i);
        }
        assertEquals(animals[1], map.objectAt(new Vector2d(0, 20)));
        assertEquals(null, map.objectAt(new Vector2d(9, 8)));
        assertEquals(animals[0], map.objectAt(new Vector2d(9, 9)));
    }


}




