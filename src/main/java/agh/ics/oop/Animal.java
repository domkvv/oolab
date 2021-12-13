package agh.ics.oop;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Animal extends AbstractWorldMapElement {
    private Vector2d position;
    private MapDirection orientation;
    private IWorldMap map;
    private final ArrayList<IPositionChangeObserver> observers = new ArrayList<IPositionChangeObserver>();

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
        Vector2d new_position = new Vector2d(x, y);
        if (map.canMoveTo(new_position)) {
            positionChanged(this.position, new_position);
            this.position = new_position;
        }

    }

    public void addObserver(IPositionChangeObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer) {
        this.observers.remove(observer);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for (IPositionChangeObserver observer : observers) {
            observer.positionChanged(oldPosition, newPosition);
        }
    }

    @Override
    public Image setOrientation() throws FileNotFoundException {
        return switch (this.orientation.ordinal()) {
            case 0 -> new Image(new FileInputStream("src/main/resources/up.png"));
            case 1 -> new Image(new FileInputStream("src/main/resources/down.png"));
            case 2 -> new Image(new FileInputStream("src/main/resources/left.png"));
            case 3 -> new Image(new FileInputStream("src/main/resources/right.png"));
            default -> null;
        };
    }

}
