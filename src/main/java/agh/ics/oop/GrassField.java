package agh.ics.oop;

import java.lang.Math;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class GrassField extends AbstractWorldMap implements IWorldMap{
    private final ArrayList<Grass> grasses = new ArrayList<Grass>();

    public GrassField(int n) {
        while (this.grasses.size() < n) {
            int x = ThreadLocalRandom.current().nextInt(0, (int) Math.sqrt(10 * n) + 1);
            int y = ThreadLocalRandom.current().nextInt(0, (int) Math.sqrt(10 * n) + 1);
            Vector2d position = new Vector2d(x, y);
            if (objectAt(position) == null) {
                this.grasses.add(new Grass(position));
            }
        }
    }

    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
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

    public Vector2d[] UpdateLimits() {
        Vector2d lowerLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Vector2d upperRight = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for (Animal i : animals) {
            lowerLeft = new Vector2d(Math.min(i.getPosition().x, lowerLeft.x), Math.min(i.getPosition().y, lowerLeft.y));
            upperRight = new Vector2d(Math.max(i.getPosition().x, upperRight.x), Math.max(i.getPosition().y, upperRight.y));
        }
        for (Grass i : grasses) {
            lowerLeft = new Vector2d(Math.min(i.getPosition().x, lowerLeft.x), Math.min(i.getPosition().y, lowerLeft.y));
            upperRight = new Vector2d(Math.max(i.getPosition().x, upperRight.x), Math.max(i.getPosition().y, upperRight.y));
        }
        return new Vector2d[]{lowerLeft, upperRight};
    }

}
