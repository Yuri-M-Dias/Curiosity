package com.curiosity;

public class Rover {

    private String name;
    private Direction facing;
    private double x;
    private double y;

    public Rover(String name) {
        this.name = name;
        this.facing = null;
        this.x = -1;
        this.y = -1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Direction getFacing() {
        return facing;
    }

    public void setFacing(Direction facing) {
        this.facing = facing;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void rotateLeft() {
        int currentIndex = facing.getIndex() - 1;
        if(currentIndex < Direction.NORTH.getIndex()){
            facing = Direction.WEST;
        } else {
            facing = Direction.fromInt(currentIndex);
        }
    }

    public void rotateRight() {
        int currentIndex = facing.getIndex() + 1;
        if(currentIndex > Direction.WEST.getIndex()){
            facing = Direction.NORTH;
        } else {
            facing = Direction.fromInt(currentIndex);
        }
    }

}
