package agh.ics.oop;

import javafx.scene.image.Image;

import java.io.FileNotFoundException;

public class AbstractWorldMapElement implements IMapElement {
    protected Vector2d position;

    public Vector2d getPosition() {
        return this.position;
    }

    public Image setOrientation() throws FileNotFoundException {
        return null;
    }

}
