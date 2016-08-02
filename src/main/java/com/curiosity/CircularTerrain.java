package com.curiosity;

import java.util.ArrayList;

import static javafx.scene.input.KeyCode.Y;

public class CircularTerrain extends Terrain {

    private double radius;

    public CircularTerrain(double radius) {
        super(new ArrayList<>());
        this.radius = radius;
    }

    @Override
    public void executeCommand(Rover rover, String command) {
        if (rover == null || command == null || "".equals(command)) {
            throw new IllegalArgumentException("Null arguments to executeCommand.");
        }
        if (!rovers.contains(rover)) {
            throw new IllegalArgumentException("Rover not placed on the map.");
        }
        Direction roverDirection = rover.getFacing();
        if ("L".equals(command)) {
            rover.rotateLeft();
        } else if ("R".equals(command)) {
            rover.rotateRight();
        } else if ("M".equals(command)) {
            double distanceFromCenter = rover.getX();
            double angle = rover.getY();
            switch (roverDirection) {
                case NORTH:
                    distanceFromCenter++;
                    if (distanceFromCenter > radius) {
                        System.out.println("Rover reached edge.");
                        break;
                    }
                    rover.setX(distanceFromCenter);
                    break;
                case SOUTH:
                    distanceFromCenter--;
                    if (distanceFromCenter < 0) {
                        System.out.println("Rover reached edge.");
                        break;
                    }
                    rover.setX(distanceFromCenter);
                    break;
                case WEST:
                    currentX--;
                    if (currentX < 0) {
                        System.out.println("Rover reached edge.");
                        break;
                    }
                    rover.setX(currentX);
                    break;
                case EAST:
                    currentX++;
                    if (currentX > maxX) {
                        System.out.println("Rover reached edge.");
                        break;
                    }
                    rover.setX(currentX);
                    break;
            }
        }

    }

    @Override
    public void placeRover(Rover rover, double x, double y, Direction direction) {
        if (x < 0 || x > radius || y < 0 || y > (2 * Math.PI)) {
            throw new IllegalArgumentException("Invalid x and y");
        }
        rover.setX(x);
        rover.setY(y);
        rover.setFacing(direction);
        getRovers().add(rover);
    }

}
