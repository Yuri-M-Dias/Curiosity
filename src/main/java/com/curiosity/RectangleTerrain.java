package com.curiosity;

import java.util.ArrayList;

public class RectangleTerrain extends Terrain {

    private int[][] map;

    public RectangleTerrain(int maxX, int maxY) {
        super(new ArrayList<>());
        this.map = new int[maxX][maxY];
    }

    @Override
    public void move(Rover rover, String command) {

    }

    @Override
    public void placeRover(Rover rover, int x, int y, Direction direction) {

    }
}
