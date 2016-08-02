package com.curiosity;

import org.junit.Assert;
import org.junit.Test;

public class CircularTerrainRoversTest {

    @Test
    public void singleRover() throws Exception {
        Rover endeavour = new Rover("Endeavour");
        Terrain terrain= new CircularTerrain(5);
        terrain.placeRover(endeavour, 3, 0, Direction.NORTH);
        terrain.executeCommand(endeavour, "M");
        terrain.executeCommand(endeavour, "M");
        terrain.executeCommand(endeavour, "L");
        terrain.executeCommand(endeavour, "M");
        terrain.executeCommand(endeavour, "L");
        terrain.executeCommand(endeavour, "M");
        terrain.executeCommand(endeavour, "R");
        terrain.executeCommand(endeavour, "M");
        Assert.assertEquals("Rover not ending on the right X position.", 4,
                endeavour.getX(), 0);
        Assert.assertEquals("Rover not ending on the right Y position.", 0.4,
                endeavour.getY(), 0);
        Assert.assertEquals("Rover not facing the right direction.",
                Direction.WEST, endeavour.getFacing());
    }

    @Test
    public void twoRovers() throws Exception {
        Rover endeavour = new Rover("Endeavour");
        Terrain terrain= new CircularTerrain(5);
        terrain.placeRover(endeavour, 3, 0, Direction.NORTH);
        terrain.executeCommand(endeavour, "M");
        terrain.executeCommand(endeavour, "M");
        terrain.executeCommand(endeavour, "L");
        terrain.executeCommand(endeavour, "M");
        terrain.executeCommand(endeavour, "L");
        terrain.executeCommand(endeavour, "M");
        terrain.executeCommand(endeavour, "R");
        terrain.executeCommand(endeavour, "M");
        Assert.assertEquals("Rover not ending on the right X position.", 4,
                endeavour.getX(), 0);
        Assert.assertEquals("Rover not ending on the right Y position.", 0.4,
                endeavour.getY(), 0);
        Assert.assertEquals("Rover not facing the right direction.",
                Direction.WEST, endeavour.getFacing());
        Rover curiosity = new Rover("Curiosity");
        terrain.placeRover(curiosity, 5, 6, Direction.SOUTH);
        Assert.assertTrue("Rovers not being registered to the terrain.",
                terrain.getRovers().size() == 2);
        terrain.executeCommand(curiosity, "M");
        terrain.executeCommand(curiosity, "R");
        terrain.executeCommand(curiosity, "M");
        terrain.executeCommand(curiosity, "M");
        terrain.executeCommand(curiosity, "L");
        terrain.executeCommand(curiosity, "M");
        terrain.executeCommand(curiosity, "L");
        terrain.executeCommand(curiosity, "M");
        terrain.executeCommand(curiosity, "R");
        terrain.executeCommand(curiosity, "M");
        Assert.assertEquals("Rover not ending on the right X position.", 2,
                curiosity.getX(), 0);
        Assert.assertEquals("Rover not ending on the right Y position.", 6.2,
                curiosity.getY(), 0);
        Assert.assertEquals("Rover not facing the right direction.",
                Direction.SOUTH, curiosity.getFacing());
    }

}
