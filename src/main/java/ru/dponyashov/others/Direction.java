package ru.dponyashov.others;

public enum Direction {
    LEFT(0),
    RIGHT(2),
    UP(1),
    DOWN(3);

    private final int value;
    Direction(int value){
        this.value = value;
    }
    public int value(){
        return value;
    }
}
