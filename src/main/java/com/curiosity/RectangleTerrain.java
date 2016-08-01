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
        if ("L".equals(command)) {
            rover.rotateLeft();
        } else if ("R".equals(command)) {
            rover.rotateRight();
        } else if ("M".equals(command)) {
            Direction roverDirection = rover.getFacing();
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
                    if(currentX < 0){
                        System.out.println("Rover reached edge.");
                        break;
                    }
                    rover.setX(currentX);
                    break;
                case EAST:
                    currentX++;
                    if(currentX > maxX){
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

    }
}
