package com.curiosity;

import java.util.ArrayList;

public class CircularTerrain extends Terrain {

    private double radius;
    private static final double TWO_PI = 2 * Math.PI;

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
            double arc = 1;
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
                    angle += arc / radius;
                    if (angle > TWO_PI) {
                        double excess = angle - TWO_PI;
                        angle = 0 + excess;
                    }
                    rover.setY(angle);
                    break;
                case EAST:
                    angle -= arc / radius;
                    if (angle < 0) {
                        double excess = angle * -1;
                        angle = TWO_PI - excess;
                    }
                    rover.setY(angle);
                    break;
            }
        } else {
            throw new IllegalArgumentException("Illegal command: " + command);
        }
    }

    @Override
    public void placeRover(Rover rover, double x, double y, Direction direction) {
        if (x < 0 || x > radius || y < 0 || y > TWO_PI) {
            throw new IllegalArgumentException("Invalid x and y");
        }
        rover.setX(x);
        rover.setY(y);
        rover.setFacing(direction);
        getRovers().add(rover);
    }

}
