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

    public static Direction fromChar(char letter){
        switch (letter){
            case 'N':
                return NORTH;
            case 'E':
                return EAST;
            case 'S':
                return SOUTH;
            case 'W':
                return WEST;
        }
        return null;// Not implemented
    }

    public char toChar(){
        switch (this){
            case NORTH:
                return 'N';
            case EAST:
                return 'E';
            case SOUTH:
                return 'S';
            case WEST:
                return 'W';
        }
        return 'X';// Not implemented
    }

    public int getIndex() {
        return index;
    }

}
