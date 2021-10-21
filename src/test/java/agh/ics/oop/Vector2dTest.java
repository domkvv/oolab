package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Vector2dTest {
    @Test
    void equalsTest() {
        assertEquals(new Vector2d(1, 5), new Vector2d(1, 5));
        assertEquals(new Vector2d(0, 0), new Vector2d(0, 0));
        assertEquals(new Vector2d(-2147483648, 2147483647), new Vector2d(-2147483648, 2147483647));
        assertEquals(new Vector2d(100, -100), new Vector2d(100, -100));
    }

    @Test
    void toStringTest() {
        assertEquals("(1,7)", new Vector2d(1, 7).toString());
        assertEquals("(1,2)", new Vector2d(1, 2).toString());
        assertEquals("(1500,100900)", new Vector2d(1500, 100900).toString());
        assertEquals("(-2147483648,2147483647)", new Vector2d(-2147483648, 2147483647).toString());
        assertEquals("(-1,-1)", new Vector2d(-1, -1).toString());
        assertEquals("(-1,0)", new Vector2d(-1, 0).toString());
        assertEquals("(-1,1)", new Vector2d(-1, 1).toString());
        assertEquals("(0,0)", new Vector2d(0, 0).toString());
    }

    @Test
    void precedesTest() {
        assertEquals(true, new Vector2d(1, 1).precedes(new Vector2d(2, 2)));
        assertEquals(false, new Vector2d(0, 1).precedes(new Vector2d(-2, 4)));
        assertEquals(true, new Vector2d(0, 0).precedes(new Vector2d(1, 0)));
        assertEquals(true, new Vector2d(2, 2).precedes(new Vector2d(2, 2)));
        assertEquals(false, new Vector2d(0, 1).precedes(new Vector2d(0, -1)));
        assertEquals(false, new Vector2d(2, 3).precedes(new Vector2d(-2, 9)));
    }

    @Test
    void followsTest() {
        assertEquals(true, new Vector2d(1, 1).follows(new Vector2d(0, -1)));
        assertEquals(true, new Vector2d(0, 0).follows(new Vector2d(-1, -5)));
        assertEquals(true, new Vector2d(100, -100).follows(new Vector2d(100, -100)));
        assertEquals(false, new Vector2d(25, 1).follows(new Vector2d(24, 25)));
        assertEquals(false, new Vector2d(2, 3).follows(new Vector2d(-2, 9)));
        assertEquals(false, new Vector2d(0, 1).follows(new Vector2d(-2, 4)));
    }

    @Test
    void upperRightTest() {
        assertEquals(new Vector2d(-1, 2), new Vector2d(-8, -6).upperRight(new Vector2d(-1, 2)));
        assertEquals(new Vector2d(0, 4), new Vector2d(0, 1).upperRight(new Vector2d(-6, 4)));
        assertEquals(new Vector2d(8, 3), new Vector2d(8, 3).upperRight(new Vector2d(-2, -1)));
        assertEquals(new Vector2d(51, 36), new Vector2d(47, 36).upperRight(new Vector2d(51, 6)));
        assertEquals(new Vector2d(-29, 21), new Vector2d(-29, 7).upperRight(new Vector2d(-47, 21)));
        assertEquals(new Vector2d(25, 856), new Vector2d(25, 856).upperRight(new Vector2d(-172, 199)));
    }

    @Test
    void lowerLeftTest() {
        assertEquals(new Vector2d(7, -6), new Vector2d(7, 1).lowerLeft(new Vector2d(10, -6)));
        assertEquals(new Vector2d(-6, -8), new Vector2d(10, -8).lowerLeft(new Vector2d(-6, 6)));
        assertEquals(new Vector2d(2, -9), new Vector2d(4, 9).lowerLeft(new Vector2d(2, -9)));
        assertEquals(new Vector2d(-25, -67), new Vector2d(48, 89).lowerLeft(new Vector2d(-25, -67)));
        assertEquals(new Vector2d(-81, 1), new Vector2d(78, 1).lowerLeft(new Vector2d(-81, 15)));
        assertEquals(new Vector2d(211, -940), new Vector2d(211, 564).lowerLeft(new Vector2d(476, -940)));
    }

    @Test
    void addTest() {
        assertEquals(new Vector2d(-5, -9), new Vector2d(-1, -3).add(new Vector2d(-4, -6)));
        assertEquals(new Vector2d(-5, 0), new Vector2d(0, -3).add(new Vector2d(-5, 3)));
        assertEquals(new Vector2d(3, 4), new Vector2d(0, 2).add(new Vector2d(3, 2)));
        assertEquals(new Vector2d(70, -33), new Vector2d(20, 35).add(new Vector2d(50, -68)));
        assertEquals(new Vector2d(-3, 72), new Vector2d(-47, 30).add(new Vector2d(44, 42)));
        assertEquals(new Vector2d(1295, 44), new Vector2d(595, -541).add(new Vector2d(700, 585)));
    }

    @Test
    void subtractTest() {
        assertEquals(new Vector2d(9, -2), new Vector2d(9, -3).subtract(new Vector2d(0, -1)));
        assertEquals(new Vector2d(-4, 13), new Vector2d(-9, 3).subtract(new Vector2d(-5, -10)));
        assertEquals(new Vector2d(2, -14), new Vector2d(-1, -7).subtract(new Vector2d(-3, 7)));
        assertEquals(new Vector2d(-39, -56), new Vector2d(-61, 20).subtract(new Vector2d(-22, 76)));
        assertEquals(new Vector2d(-3, -63), new Vector2d(30, -47).subtract(new Vector2d(33, 16)));
        assertEquals(new Vector2d(1106, 161), new Vector2d(880, -16).subtract(new Vector2d(-226, -177)));

    }

    @Test
    void oppositeTest() {
        assertEquals(new Vector2d(0, 0), new Vector2d(0, 0).opposite());
        assertEquals(new Vector2d(1, 0), new Vector2d(-1, 0).opposite());
        assertEquals(new Vector2d(0, 1), new Vector2d(0, -1).opposite());
        assertEquals(new Vector2d(1, 1), new Vector2d(-1, -1).opposite());
        assertEquals(new Vector2d(-1, 1), new Vector2d(1, -1).opposite());
        assertEquals(new Vector2d(1, -1), new Vector2d(-1, 1).opposite());
        assertEquals(new Vector2d(-1, -1), new Vector2d(1, 1).opposite());
        assertEquals(new Vector2d(42, -7), new Vector2d(-42, 7).opposite());

    }

}
