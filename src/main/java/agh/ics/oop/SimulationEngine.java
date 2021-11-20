package agh.ics.oop;

import java.util.ArrayList;

public class SimulationEngine implements IEngine {
    private final MoveDirection[] directions;
    private final IWorldMap map;
    private final ArrayList<Animal> animals;
    private ArrayList<Grass> grasses;

    SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] initials) {
        this.directions = directions;
        this.map = map;
        this.animals = new ArrayList<Animal>();
        for (Vector2d position : initials) {
            Animal animal = new Animal(map, position);
            if (map.place(animal)) this.animals.add(animal);
        }

    }

    public void run() {
        if (animals.size() != 0) {
            int j = 0;
            for (MoveDirection i : directions) {
                this.animals.get(j).move(i);
                j = (j + 1) % animals.size();
            }
        }
    }

}
