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
    public void move(Rover rover, String command) {
        if (rover == null || command == null || "".equals(command)) {
            throw new IllegalArgumentException("Null arguments to move.");
        }
        if (!rovers.contains(rover)) {
            throw new IllegalArgumentException("Rover not placed on the map.");
        }
        Direction roverDirection = rover.getFacing();
        if ("L".equals(command)) {
            rover.setFacing(rotateDirection(roverDirection, -90));
        } else if ("R".equals(command)) {
            rover.setFacing(rotateDirection(roverDirection, 90));
        } else if ("M".equals(command)) {
            int currentX = rover.getX();
            int currentY = rover.getY();
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
    public void placeRover(Rover rover, int x, int y, Direction direction) {
        if(x < 0 || x > maxX || y > maxY || y < 0){
            throw new IllegalArgumentException("Invalid x and y");
        }
        rover.setX(x);
        rover.setY(y);
        rover.setFacing(direction);
        getRovers().add(rover);
    }

    private Direction rotateDirection(Direction currentDirection, int degrees) {
        int currentDegree = currentDirection.getDegree() + degrees;
        Direction direction = null;
        if (currentDegree == 0 || currentDegree == 360) {
            direction = Direction.EAST;
        } else if (currentDegree == 90) {
            direction = Direction.NORTH;
        } else if (currentDegree == 180) {
            direction = Direction.WEST;
        } else if (currentDegree == 270 || currentDegree == -90) {
            direction = Direction.SOUTH;
        }
        return direction;
    }
}
