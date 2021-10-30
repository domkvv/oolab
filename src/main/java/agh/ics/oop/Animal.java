package agh.ics.oop;

public class Animal {
    private Vector2d position = new Vector2d(2, 2);
    private MapDirection orientation = MapDirection.NORTH;

    public String toString() {
        return "position: " + this.position + " orientation: " + this.orientation;
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
        if (x >= 0 && x <= 4 && y >= 0 && y <= 4) this.position = new Vector2d(x, y);
    }

}
