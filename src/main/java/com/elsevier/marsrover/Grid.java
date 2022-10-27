package com.elsevier.marsrover;

/**
 * @author : Manisha on 22/06/2022
 */
public class Grid {

    private int maxX;
    private int minX;
    private int maxY;
    private int minY;

    public Grid(int maxX, int maxY) {
        this.maxX = maxX;
        this.minX = 0;
        this.maxY = maxY;
        this.minY = 0;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMinX() {
        return minX;
    }


    public int getMaxY() {
        return maxY;
    }


    @Override
    public String toString() {
        return "Grid{" +
                "maxX=" + maxX +
                ", maxY=" + maxY +
                '}';
    }


}
