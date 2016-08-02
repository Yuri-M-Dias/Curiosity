package com.curiosity;

import java.util.ArrayList;

public class RectangleTerrain extends Terrain {

    private int[][] map;
    private int maxX;
    private int maxY;

    public RectangleTerrain(int maxX, int maxY) {
        super(new ArrayList<>());
        this.maxX = maxX;
        this.maxY = maxY;
        this.map = new int[this.maxX][this.maxY];
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
            double currentX = rover.getX();
            double currentY = rover.getY();
            switch (roverDirection) {
                case NORTH:
                    currentY++;
                    if (currentY > maxY) {
                        System.out.println("Rover reached edge.");
                        break;
                    }
                    rover.setY(currentY);
                    break;
                case SOUTH:
                    currentY--;
                    if (currentY < 0) {
                        System.out.println("Rover reached edge.");
                        break;
                    }
                    rover.setY(currentY);
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
        if (x < 0 || x > maxX || y > maxY || y < 0) {
            throw new IllegalArgumentException("Invalid x and y");
        }
        rover.setX(x);
        rover.setY(y);
        rover.setFacing(direction);
        getRovers().add(rover);
    }

}
