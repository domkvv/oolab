package agh.ics.oop;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Grass extends AbstractWorldMapElement {
    private Vector2d position;

    public Grass(Vector2d position) {
        this.position = position;
    }

    public Vector2d getPosition() {
        return this.position;
    }

    public String toString() {
        return "*";
    }

    @Override
    public Image setOrientation() throws FileNotFoundException {
        return new Image(new FileInputStream("src/main/resources/tuft.png"));
    }
}
