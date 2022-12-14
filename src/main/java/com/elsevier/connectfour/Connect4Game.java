package com.elsevier.connectfour;

import java.util.Random;
import java.util.Scanner;

public class Connect4Game {

    private Board board;
    private String color1;
    private String color2;

    private boolean is1Playing;


    public Connect4Game( String color1, String color2){
        this.board = new Board();
        this.color1 = color1;
        this.color2 = color2;
        is1Playing = (new Random()).nextBoolean();
    }

    public boolean checkForWinner(int column){
        String winColor;
        if(is1Playing){
            winColor = color1;
        }
        else{
            winColor = color2;
        }
        return board.someOneWon(column, winColor);
    }

    public void startGame(){
        boolean running = true;
        while(running){
            board.printBoard();
            String color;
            if(is1Playing){
                color = color1;
                System.out.println("player1 turn");
            }else{
                color = color2;
                System.out.println("player2 turn");
            }
            System.out.println("please select the desirable column");
            System.out.println("please choose the colums between 1 to" +board.getColumn() +":");
            Scanner input = new Scanner(System.in);
            int column= input.nextInt()-1;
           boolean success= board.addPiece(column,color);
           if(success) {
               //board.printBoard();
               if(checkForWinner(column)){
                   running =false;
                   if(is1Playing){
                       System.out.println("player 1 won");
                   }
                   else {
                       System.out.println("player 2 won");
                   }
               }
               is1Playing = !is1Playing;
           }
        }

    }

}
