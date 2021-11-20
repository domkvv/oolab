package agh.ics.oop;

import java.util.ArrayList;

import java.lang.Math;

import java.util.concurrent.ThreadLocalRandom;

public class GrassField implements IWorldMap {
    private final ArrayList<Grass> grasses = new ArrayList<Grass>();
    private final ArrayList<Animal> animals = new ArrayList<Animal>();
    private Vector2d lowerLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
    private Vector2d upperRight = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
    private MapVisualizer visualizer;

    public GrassField(int n) {
        int x;
        int y;
        while (this.grasses.size() < n) {
            x = ThreadLocalRandom.current().nextInt(0, (int) Math.sqrt(10 * n) + 1);
            y = ThreadLocalRandom.current().nextInt(0, (int) Math.sqrt(10 * n) + 1);
            Vector2d position = new Vector2d(x, y);
            if (objectAt(position) == null) {
                this.grasses.add(new Grass(position));
            }
        }
        this.visualizer = new MapVisualizer(this);
    }

    public String toString() {
        for(Animal i : animals){
            this.lowerLeft = new Vector2d(Math.min(i.getPosition().x, lowerLeft.x), Math.min(i.getPosition().y, lowerLeft.y));
            this.upperRight = new Vector2d(Math.max(i.getPosition().x, upperRight.x), Math.max(i.getPosition().y, upperRight.y));
        }
        for(Grass i : grasses){
            this.lowerLeft = new Vector2d(Math.min(i.getPosition().x, lowerLeft.x), Math.min(i.getPosition().y, lowerLeft.y));
            this.upperRight = new Vector2d(Math.max(i.getPosition().x, upperRight.x), Math.max(i.getPosition().y, upperRight.y));
        }
        return visualizer.draw(this.lowerLeft, this.upperRight);
    }

    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }

    public boolean place(Animal animal) {
        if (objectAt(animal.getPosition()) instanceof Animal ) return false;
        animals.add(animal);
        return true;
    }

    public boolean isOccupied(Vector2d position) {
        if (objectAt(position) != null) return true;
        return false;
    }

    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.getPosition().equals(position)) return animal;
        }
        for (Grass grass : grasses) {
            if (grass.getPosition().equals(position)) return grass;
        }
        return null;
    }


}
