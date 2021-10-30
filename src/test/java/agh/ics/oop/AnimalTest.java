package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {

    @Test
    void AnimalTest01() {
        Animal experimental_bunny01 = new Animal();
        String[] args01 = {"r"};
        MoveDirection[] directions01 = OptionsParser.parse(args01);
        for (MoveDirection i : directions01) experimental_bunny01.move(i);
        assertEquals("position: (2,2) orientation: Wschód", experimental_bunny01.toString());
    }

    @Test
    void AnimalTest02() {
        Animal experimental_bunny02 = new Animal();
        String[] args02 = {"f", "r"};
        MoveDirection[] directions02 = OptionsParser.parse(args02);
        for (MoveDirection i : directions02) experimental_bunny02.move(i);
        assertEquals("position: (2,3) orientation: Wschód", experimental_bunny02.toString());
    }

    @Test
    void AnimalTest1() {
        Animal experimental_bunny1 = new Animal();
        String[] args = {"f", "h", "k", "mm", "p", "left", "opps", "backward", "back", "right", "rigth", "r", "b", "f", "f"};
        MoveDirection[] directions = OptionsParser.parse(args);
        for (MoveDirection i : directions) experimental_bunny1.move(i);
        assertEquals("position: (4,3) orientation: Wschód", experimental_bunny1.toString());
    }

    @Test
    void AnimalTest2() {
        Animal experimental_bunny2 = new Animal();
        String[] args2 = {"f", "left", "forward", "f", "f", "f", "f", "f", "r", "forward", "forward", "left"};
        MoveDirection[] directions2 = OptionsParser.parse(args2);
        for (MoveDirection i : directions2) experimental_bunny2.move(i);
        assertEquals("position: (0,4) orientation: Zachód", experimental_bunny2.toString());
    }

    @Test
    void AnimalTest3() {
        Animal experimental_bunny3 = new Animal();
        String[] args3 = {"b", "b", "r", "f", "p", "k", "left", "a", "f", "f", "l", "backward", "end"};
        MoveDirection[] directions3 = OptionsParser.parse(args3);
        for (MoveDirection i : directions3) experimental_bunny3.move(i);
        assertEquals("position: (4,2) orientation: Zachód", experimental_bunny3.toString());
    }

    @Test
    void AnimalTest4() {
        Animal experimental_bunny4 = new Animal();
        String[] args4 = {"b", "b", "do", "a", "kickflip", "b", "jump", "dive", "stroll", "b", "backward", "up", "up", "f", "right", "r"};
        MoveDirection[] directions4 = OptionsParser.parse(args4);
        for (MoveDirection i : directions4) experimental_bunny4.move(i);
        assertEquals("position: (2,1) orientation: Południe", experimental_bunny4.toString());
    }

    @Test
    void AnimalTest5() {
        Animal experimental_bunny5 = new Animal();
        String[] args5 = {"left", "forward", "left", "forward", "left", "f", "f", "l", "f", "f", "l", "f", "f", "l", "f", "l", "f", "r"};
        MoveDirection[] directions5 = OptionsParser.parse(args5);
        for (MoveDirection i : directions5) experimental_bunny5.move(i);
        assertEquals("position: (2,2) orientation: Południe", experimental_bunny5.toString());
    }

    @Test
    void AnimalTest6() {
        Animal experimental_bunny6 = new Animal();
        String[] args6 = {"l", "f", "left", "a", "ba", "forward", "f", "right", "f", "f", "r"};
        MoveDirection[] directions6 = OptionsParser.parse(args6);
        for (MoveDirection i : directions6) experimental_bunny6.move(i);
        assertEquals("position: (0,0) orientation: Północ", experimental_bunny6.toString());
    }


}
