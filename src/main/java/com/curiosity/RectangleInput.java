package com.curiosity;

import java.util.List;
import java.util.Scanner;

public class RectangleInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] plateauMax = scanner.nextLine().replace("\n", "").split(" ");
        int plateauMaxX = Integer.parseInt(plateauMax[0]);
        int plateauMaxY = Integer.parseInt(plateauMax[1]);
        Terrain terrain = new RectangleTerrain(plateauMaxX, plateauMaxY);
        String[] roverInformation = scanner.nextLine().replace("\n", "").split(" ");
        while (!"".equals(roverInformation[0])) {
            int roverX = Integer.parseInt(roverInformation[0]);
            int roverY = Integer.parseInt(roverInformation[1]);
            Direction roverDirection = Direction
                    .fromChar(roverInformation[2].charAt(0));
            Rover rover = new Rover();
            terrain.placeRover(rover, roverX, roverY, roverDirection);
            char[] roverCommands = scanner.nextLine().replace("\n", "").toCharArray();
            for (int i = 0; i < roverCommands.length; i++) {
                terrain.executeCommand(rover, String.valueOf(roverCommands[i]));
            }
            roverInformation = scanner.nextLine().replace("\n", "").split(" ");
        }
        List<Rover> rovers = terrain.getRovers();
        for (Rover rover : rovers) {
            System.out.println(String.format("%.0f %.0f %c", rover.getX(), rover
                    .getY(), rover.getFacing().toChar()));
        }
    }

}
