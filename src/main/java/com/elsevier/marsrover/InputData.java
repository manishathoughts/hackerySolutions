package com.elsevier.marsrover;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author : Manisha on 21/06/2022
 */
public class InputData {


    public Scanner sc;

    public InputData() {

        this.sc = new Scanner(System.in);

    }

    public void enterInputData() {
        System.out.println("Enter the grid dimensions");
        String input = sc.nextLine();
        Grid grid = parseGrid(input);

        System.out.println("Enter the rover one location and bearing details");
        input = sc.nextLine();
        Rover roverOne = parseLocationAndBearing(input,grid);

        System.out.println("Enter the rover one instructions");
        input = sc.nextLine();
        roverOne.instructions(input);

        System.out.println("Enter the rover two location and bearing details");
        input= sc.nextLine();
        Rover roverTwo = parseLocationAndBearing(input,grid);

        System.out.println("Enter the rover two instructions");
        input= sc.nextLine();
        roverTwo.instructions(input);

        System.out.println("Final position of rovers: " + roverOne +"" + roverTwo);
    }

    private Grid parseGrid(String input) {

        String dimensions [] = input.split( " ");

        return new Grid(Integer.parseInt(dimensions[0]),Integer.parseInt(dimensions[1]));


    }

    private Rover parseLocationAndBearing(String input, Grid grid){

        String locAndBearing [] = input.split("");

        return new Rover(Integer.parseInt(locAndBearing[0]), Integer.parseInt(locAndBearing[1]), locAndBearing[2],grid);
    }

}
