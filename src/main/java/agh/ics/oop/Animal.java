package agh.ics.oop;

public class Animal {
    private Vector2d position;
    private MapDirection orientation;
    private IWorldMap map;

    Animal() {
        this.position = new Vector2d(2, 2);
        this.orientation = MapDirection.NORTH;
    }

    Animal(IWorldMap map) {
        this.map = map;
        this.position = new Vector2d(2, 2);
        this.orientation = MapDirection.NORTH;
    }

    Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.position = initialPosition;
        this.orientation = MapDirection.NORTH;
    }

    public String toString() {
        return (this.orientation.toString());
    }

    public Vector2d getPosition() {
        return this.position;
    }

    public MapDirection getOrientation() {
        return this.orientation;
    }

    boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public void move(MoveDirection direction) {
        int x = this.position.x;
        int y = this.position.y;

        switch (direction) {
            case RIGHT -> this.orientation = (MapDirection) this.orientation.next();
            case LEFT -> this.orientation = (MapDirection) this.orientation.previous();
            case FORWARD -> {
                switch (this.orientation) {
                    case NORTH -> y += 1;
                    case SOUTH -> y -= 1;
                    case WEST -> x -= 1;
                    case EAST -> x += 1;
                }
            }
            case BACKWARD -> {
                switch (this.orientation) {
                    case NORTH -> y -= 1;
                    case SOUTH -> y += 1;
                    case WEST -> x += 1;
                    case EAST -> x -= 1;
                }
            }
        }
        if (map.canMoveTo(new Vector2d(x, y))) {
            this.position = new Vector2d(x, y);
        }
    }

}
