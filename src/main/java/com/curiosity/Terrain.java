package com.curiosity;

import java.util.List;

public abstract class Terrain {

    protected List<Rover> rovers;

    public Terrain(List<Rover> rovers) {
        this.rovers = rovers;
    }

    public abstract void executeCommand(Rover rover, String command);

    public abstract void placeRover(Rover rover, double x, double y, Direction
            direction);

    public List<Rover> getRovers() {
        return rovers;
    }

    public void setRovers(List<Rover> rovers) {
        this.rovers = rovers;
    }

}
