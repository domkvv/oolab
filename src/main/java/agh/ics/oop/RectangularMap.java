package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap implements IWorldMap{
    protected Vector2d lowerLeft;
    protected Vector2d upperRight;

    public RectangularMap(int width, int height) {
        this.lowerLeft = new Vector2d(0, 0);
        this.upperRight = new Vector2d(width - 1, height - 1);
    }

    public boolean canMoveTo(Vector2d position) {
        return (position.precedes(this.upperRight) && position.follows(this.lowerLeft) && !(isOccupied(position)));
    }

    public Vector2d[] UpdateLimits() {
        return new Vector2d[]{this.lowerLeft, this.upperRight};
    }

}
