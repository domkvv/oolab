package agh.ics.oop;


import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{
    private final SortedSet<Vector2d> xs = new TreeSet<>(new XComparator());
    private final SortedSet<Vector2d> ys = new TreeSet<>(new YComparator());

    public void addElement(AbstractWorldMapElement element){
        this.xs.add(element.getPosition());
        this.ys.add(element.getPosition());
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        this.xs.remove(oldPosition);
        this.ys.remove(oldPosition);

        this.xs.add(newPosition);
        this.ys.add(newPosition);
    }

    public Vector2d lowerLeft(){
        return new Vector2d(
            Math.min(xs.first().x, ys.first().x),
            Math.min(xs.first().y, ys.first().y)
        );
    }

    public Vector2d upperRight(){
        return new Vector2d(
            Math.max(xs.last().x, ys.last().x),
            Math.max(xs.last().y, ys.last().y)
        );
    }
}