package com.elsevier.marsrover;

/**
 * @author : Manisha on 22/06/2022
 */
public class Rover {

    private int xLoc;
    private int yLoc;
    private String bearing;
    public Grid grid;



    public Rover(int xLoc, int yLoc, String bearing, Grid grid) {
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        this.bearing = bearing;
        this.grid = grid;
    }



    public void instructions(String input){

        String instructions[] = input.split("");

         for( String instruction : instructions){

             if(instruction.startsWith("L")){
                 rotateLeft();
             }
             else if( instruction.startsWith("R")){
                 rotateRight();
             }
             else moveForward();
         }


    }

    private void rotateLeft() {
        switch (this.bearing) {
            case "N":
                this.bearing = "W";
                break;
            case "W":
                this.bearing = "S";
                break;
            case "S":
                this.bearing = "E";
                break;
            case "E":
                this.bearing = "N";
                break;
        }
    }

    public void rotateRight(){

        switch (this.bearing) {
            case "N" :
                this.bearing = "E";
                break;
            case "E":
                this.bearing= "S";
                break;
            case "S" :
                this.bearing ="W";
                break;
            case "W" :
                this.bearing= "N";
                break;
        }


    }

    public void moveForward() {

        if (this.bearing.startsWith("E") && this.xLoc < grid.getMaxX()) {
            this.xLoc++;
        } else if (this.bearing.startsWith("W") && this.xLoc > grid.getMinX()) {
            this.xLoc--;
        } else if (this.bearing.startsWith("N") && this.yLoc < grid.getMaxY()) {
            this.yLoc++;
        } else if (this.bearing.startsWith("S") && this.yLoc > grid.getMinX()) {
            this.yLoc--;

        }

    }

    @Override
    public String toString() {
        return "\n"+ xLoc + " " + yLoc + " " + bearing ;

    }
}
