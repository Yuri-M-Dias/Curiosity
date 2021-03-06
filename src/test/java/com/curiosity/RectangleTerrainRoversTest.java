package com.curiosity;

import org.junit.Assert;
import org.junit.Test;

public class RectangleTerrainRoversTest {

    @Test
    public void twoRovers() throws Exception {
        Rover endeavour = new Rover("Endeavour");
        Terrain terrain= new RectangleTerrain(5, 5);
        terrain.placeRover(endeavour, 1, 2, Direction.NORTH);
        terrain.executeCommand(endeavour, "L");
        terrain.executeCommand(endeavour, "M");
        terrain.executeCommand(endeavour, "L");
        terrain.executeCommand(endeavour, "M");
        terrain.executeCommand(endeavour, "L");
        terrain.executeCommand(endeavour, "M");
        terrain.executeCommand(endeavour, "L");
        terrain.executeCommand(endeavour, "M");
        terrain.executeCommand(endeavour, "M");
        Assert.assertEquals("Rover not ending on the right X position.", 1,
                endeavour.getX(), 0);
        Assert.assertEquals("Rover not ending on the right Y position.", 3,
                endeavour.getY(), 0);
        Assert.assertEquals("Rover not facing the right direction.",
                Direction.NORTH, endeavour.getFacing());
        Rover curiosity = new Rover("Curiosity");
        terrain.placeRover(curiosity, 3, 3, Direction.EAST);
        Assert.assertTrue("Rovers not being registered to the terrain.",
                terrain.getRovers().size() == 2);
        terrain.executeCommand(curiosity, "M");
        terrain.executeCommand(curiosity, "M");
        terrain.executeCommand(curiosity, "R");
        terrain.executeCommand(curiosity, "M");
        terrain.executeCommand(curiosity, "M");
        terrain.executeCommand(curiosity, "R");
        terrain.executeCommand(curiosity, "M");
        terrain.executeCommand(curiosity, "R");
        terrain.executeCommand(curiosity, "R");
        terrain.executeCommand(curiosity, "M");
        Assert.assertEquals("Rover not ending on the right X position.", 5,
                curiosity.getX(), 0);
        Assert.assertEquals("Rover not ending on the right Y position.", 1,
                curiosity.getY(), 0);
        Assert.assertEquals("Rover not facing the right direction.",
                Direction.EAST, curiosity.getFacing());
    }

}
