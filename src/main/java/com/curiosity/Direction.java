package com.curiosity;

public enum Direction {
    NORTH(90), SOUTH(270), WEST(180), EAST(0);

    private int degree;

    Direction(int degree) {
        this.degree = degree;
    }

    public int getDegree() {
        return degree;
    }

}
