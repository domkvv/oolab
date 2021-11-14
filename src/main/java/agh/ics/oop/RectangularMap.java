package agh.ics.oop;

import java.util.ArrayList;

public class RectangularMap implements IWorldMap {
    private final Vector2d lowerLeft;
    private final Vector2d upperRight;
    private final ArrayList<Animal> animals = new ArrayList<Animal>();
    private final MapVisualizer visualizer;

    RectangularMap(int width, int height){
        this.lowerLeft = new Vector2d(0, 0);
        this.upperRight = new Vector2d(width-1, height-1);
        this.visualizer = new MapVisualizer(this);
    }

    public String toString(){
        return visualizer.draw(this.lowerLeft, this.upperRight);
    }

    public boolean canMoveTo(Vector2d position){
        return (position.precedes(this.upperRight) && position.follows(this.lowerLeft) && !(isOccupied(position)));
    }

    /**
     * Place an animal on the map.
     *
     * @param animal
     *            The animal to place on the map.
     * @return True if the animal was placed. The animal cannot be placed if the map is already occupied.
     */
    public boolean place(Animal animal){
        if(isOccupied(animal.getPosition())) return false;
        animals.add(animal);
        return true;
    }
    /**
     * Return true if given position on the map is occupied. Should not be
     * confused with canMove since there might be empty positions where the animal
     * cannot move.
     *
     * @param position
     *            Position to check.
     * @return True if the position is occupied.
     */
    public boolean isOccupied(Vector2d position){
        if(objectAt(position) != null) return true;
        return false;
    }

    /**
     * Return an object at a given position.
     *
     * @param position
     *            The position of the object.
     * @return Object or null if the position is not occupied.
     */
    public Object objectAt(Vector2d position){
        for(Animal animal : animals){
            if(animal.getPosition().equals(position)) return animal;
        }
        return null;
    }

}
