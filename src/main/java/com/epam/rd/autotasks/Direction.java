package com.epam.rd.autotasks;

import java.util.Optional;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private int degrees;

    public static Direction ofDegrees(int degrees) {
        int n = degrees / 360;
        for (Direction dir: Direction.values()) {
            if (dir.degrees == (360*(n+1)+degrees)%360){
                return dir;
            }
        }
        return null;
    }

    public static Direction closestToDegrees(int degrees) {
        int n = degrees / 360;
        int distance = Math.abs(degrees);
        Direction closestDirection = Direction.N;
        for (Direction dir: Direction.values()) {
            if (Math.abs((360*(n+1)+degrees)%360 - dir.degrees) < distance) {
                distance = Math.abs((360*(n+1)+degrees)%360 - dir.degrees);
                closestDirection = dir;
            }
        }
        return closestDirection;
    }

    public Direction opposite() {
        int oppositeDegrees = (this.degrees + 180) % 360;
        for (Direction dir: Direction.values()) {
            if (dir.degrees == oppositeDegrees){
                return dir;
            }
        }
        return null;
    }

    public int differenceDegreesTo(Direction direction) {
        return  Math.abs(this.degrees - direction.degrees) > 180 ? Math.abs(this.degrees - direction.degrees+360) :
                Math.abs(this.degrees - direction.degrees);
    }
}
