package agh.ics.oop;

import javafx.scene.image.Image;

import java.io.FileNotFoundException;
import java.lang.Math;
import java.util.concurrent.ThreadLocalRandom;

public class GrassField extends AbstractWorldMap implements IWorldMap {
    private MapBoundary boundary = new MapBoundary();

    public GrassField(int n) {
        while (this.elements.size() < n) {
            int x = ThreadLocalRandom.current().nextInt(0, (int) Math.sqrt(10 * n) + 1);
            int y = ThreadLocalRandom.current().nextInt(0, (int) Math.sqrt(10 * n) + 1);
            Vector2d position = new Vector2d(x, y);
            if (objectAt(position) == null) {
                Grass new_grass = new Grass(position);
                this.elements.put(position, new_grass);
                this.boundary.addElement(new_grass);
            }
        }
    }

    @Override
    public boolean place(Animal animal) throws IllegalArgumentException {
        super.place(animal);
        this.boundary.addElement(animal);
        return true;
    }

    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }

    public Vector2d[] UpdateLimits() {
        Vector2d lowerLeft = this.boundary.lowerLeft();
        Vector2d upperRight = this.boundary.upperRight();
        return new Vector2d[]{lowerLeft, upperRight};
    }

}
