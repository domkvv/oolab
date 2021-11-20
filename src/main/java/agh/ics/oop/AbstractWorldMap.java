package agh.ics.oop;

import java.util.ArrayList;

abstract class AbstractWorldMap implements IWorldMap {
    protected final ArrayList<Animal> animals = new ArrayList<Animal>();
    protected final MapVisualizer visualizer = new MapVisualizer(this);
    protected Vector2d lowerLeft;
    protected Vector2d upperRight;

    public boolean isOccupied(Vector2d position) {
        if (objectAt(position) != null) return true;
        return false;
    }

    public boolean place(Animal animal) {
        if (objectAt(animal.getPosition()) instanceof Animal) return false;
        animals.add(animal);
        return true;
    }

    public String toString() {
        Vector2d lowerLeft = UpdateLimits()[0];
        Vector2d upperRight = UpdateLimits()[1];
        return visualizer.draw(lowerLeft, upperRight);
    }

    abstract Vector2d[] UpdateLimits();

}
