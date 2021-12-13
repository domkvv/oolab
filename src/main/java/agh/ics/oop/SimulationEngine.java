package agh.ics.oop;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class SimulationEngine implements IEngine, Runnable {
    private final MoveDirection[] directions;
    private final IWorldMap map;
    private final ArrayList<Animal> animals;
    private ArrayList<Grass> grasses;
    private final ArrayList<ISimulationEngineObserver> observers = new ArrayList<ISimulationEngineObserver>();
    private int moveDelay;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] initials, int moveDelay) {
        this.directions = directions;
        this.map = map;
        this.animals = new ArrayList<Animal>();
        this.moveDelay = moveDelay;
        for (Vector2d position : initials) {
            Animal animal = new Animal(map, position);
            if (map.place(animal)) this.animals.add(animal);
        }

    }

    public void run() {
        if (animals.size() != 0) {
            int j = 0;
            for (MoveDirection i : directions) {
                try {
                    Thread.sleep(this.moveDelay);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                this.animals.get(j).move(i);
                j = (j + 1) % animals.size();
                mapChanged();
            }
        }
    }

    public void addObserver(ISimulationEngineObserver observer) {
        this.observers.add(observer);
    }

    public void mapChanged() {
        for (ISimulationEngineObserver observer : observers) {
            try {
                observer.mapChanged();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }

}
