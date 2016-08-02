package com.curiosity;

public enum Direction {
    NORTH(1), EAST(2), SOUTH(3), WEST(4);

    private int index;

    Direction(int index) {
        this.index = index;
    }

    public static Direction fromInt(int number){
        switch (number){
            case 1:
                return NORTH;
            case 2:
                return EAST;
            case 3:
                return SOUTH;
            case 4:
                return WEST;
        }
        return null;// Not implemented
    }

    public int getIndex() {
        return index;
    }

}
