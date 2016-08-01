package com.curiosity;

import java.util.List;

public abstract class Terrain {

    protected List<Rover> rovers;

    public Terrain(List<Rover> rovers) {
        this.rovers = rovers;
    }

    public abstract void move(Rover rover, String command);

    public abstract void placeRover(Rover rover, int x, int y, Direction
            direction);

    public List<Rover> getRovers() {
        return rovers;
    }

    public void setRovers(List<Rover> rovers) {
        this.rovers = rovers;
    }

}
