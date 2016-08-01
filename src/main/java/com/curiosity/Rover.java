package com.curiosity;

public class Rover {

    private String name;
    private Direction facing;
    private int x;
    private int y;

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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void rotateLeft() {

    }

    public void rotateRight() {

    }

}
