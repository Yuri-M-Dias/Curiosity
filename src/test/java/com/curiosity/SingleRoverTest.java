package com.curiosity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SingleRoverTest {

    private Rover rover;
    private Terrain terrain;

    @Before
    public void setUp() throws Exception {
        rover = new Rover();
        terrain = new RectangleTerrain(5, 5);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void move() throws Exception {

    }

    @Test
    public void placeRover() throws Exception {

    }

}
