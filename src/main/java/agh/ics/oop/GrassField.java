package agh.ics.oop;

import java.lang.Math;
import java.util.concurrent.ThreadLocalRandom;

public class GrassField extends AbstractWorldMap implements IWorldMap {

    public GrassField(int n) {
        while (this.elements.size() < n) {
            int x = ThreadLocalRandom.current().nextInt(0, (int) Math.sqrt(10 * n) + 1);
            int y = ThreadLocalRandom.current().nextInt(0, (int) Math.sqrt(10 * n) + 1);
            Vector2d position = new Vector2d(x, y);
            if (objectAt(position) == null) {
                this.elements.put(position, new Grass(position));
            }
        }
    }

    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }

    public Vector2d[] UpdateLimits() {
        Vector2d lowerLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Vector2d upperRight = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for (Vector2d i : elements.keySet()) {
            lowerLeft = new Vector2d(Math.min(i.x, lowerLeft.x), Math.min(i.y, lowerLeft.y));
            upperRight = new Vector2d(Math.max(i.x, upperRight.x), Math.max(i.y, upperRight.y));
        }
        return new Vector2d[]{lowerLeft, upperRight};
    }

}
