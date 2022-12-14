package com.elsevier.connectfour;

public class Board {

    private static final int rows = 6;
    private static final int columns = 7;

    public int getColumn() {
        return columns;
    }

    public boolean someOneWon(int col, String winColor){
        boolean someOneWon = false;
        for( int row =0; row < rows ; row++){
            if(ourBoard[row][col] != null){
                int winStreak = 3;
                // check downwards
                for(int winRow =row +1 ; winRow < rows ; winRow++){
                  if(ourBoard[winRow][col].getColor() == winColor){
                      winStreak --;
                      if(winStreak == 0){
                          someOneWon = true;
                      }
                  }else{
                      winStreak =3;
                  }
                  // for any chance
                    winStreak =4;
                }
                // Check horizontal
                for(int winCol = col -3; winCol < columns + 3; winCol++){
                    if(winCol < 0) continue;
                    if(winCol >= columns) break;
                    if(ourBoard[row][winCol] != null &&  ourBoard[row][winCol].getColor() == winColor){
                        winStreak --;
                        if(winStreak == 0){
                            someOneWon = true;
                        }
                    }else{
                        winStreak =4;
                    }
                }
                break;
            }
        }

        return someOneWon;
    }

    Pieces[][] ourBoard = new Pieces[rows][columns];

    public boolean addPiece(int colToadd, String color){

       if(colToadd >= 0  && colToadd < columns){
           if (ourBoard[0][colToadd] == null) {
               boolean addedPiece= false;
                   for(int row = rows-1; row >=1 ; row--) {
                       if(ourBoard[row][colToadd] == null){
                         ourBoard[row][colToadd] = new Pieces();
                         ourBoard[row][colToadd].setColor(color);
                         addedPiece = true;
                          break;
                       }
                   }
                   return addedPiece;
           }else{
               System.err.println("specified column is already full");
               return false;
           }

       }
       else {
           System.err.println("given column is in out of range:"+colToadd);
           return false;
       }

    }

    public void printBoard() {
        for (int row = 0; row < rows; row++) {
            System.out.print("|");
            for (int col = 0; col < columns; col++) {
                if (ourBoard[row][col] == null) {
                    System.out.print("_");
                } else {
                    System.out.print(ourBoard[row][col].getColor());
                }
                System.out.print("|");
            }

            System.out.println();
        }
    }

    public Board() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                ourBoard[row][col] = null;
            }
        }
    }
}
