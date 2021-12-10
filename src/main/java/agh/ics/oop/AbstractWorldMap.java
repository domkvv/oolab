package agh.ics.oop;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    protected final Map<Vector2d, AbstractWorldMapElement> elements = new LinkedHashMap<>();
    protected final MapVisualizer visualizer = new MapVisualizer(this);

    public boolean isOccupied(Vector2d position) {
        if (objectAt(position) != null) return true;
        return false;
    }

    public boolean place(Animal animal) throws IllegalArgumentException {
        if (objectAt(animal.getPosition()) instanceof Animal){
            throw new IllegalArgumentException("position " + animal.getPosition() + " is already occupied by another animal");
        }
        animal.addObserver(this);
        this.elements.put(animal.getPosition(), animal);
        return true;
    }

    public String toString() {
        Vector2d lowerLeft = UpdateLimits()[0];
        Vector2d upperRight = UpdateLimits()[1];
        return visualizer.draw(lowerLeft, upperRight);
    }

    public Object objectAt(Vector2d position) {
        if (this.elements.containsKey(position)) return this.elements.get(position);
        return null;
    }

    public abstract Vector2d[] UpdateLimits();

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        AbstractWorldMapElement moving_animal = this.elements.get(oldPosition);
        this.elements.remove(oldPosition);
        this.elements.put(newPosition, moving_animal);
    }
}
