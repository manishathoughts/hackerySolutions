package com.elsevier.adventofcode.rockpaperscissors;;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class RockPaperScissors {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/resources/rockpaperscissors");
        List<String> matches = Files.readAllLines(path);

        int partOneScore = scoreTournament(matches);
        System.out.println("Part one total score: " + partOneScore);

        List<String> partTwoMatches = chooseShape(matches);
        int partTwoScore = scoreTournament(partTwoMatches);
        System.out.println("Part two total score: " + partTwoScore);
    }

    private static int scoreTournament(List<String> matches) {
        int totalScore = 0;

        Map<String, Integer> lose = new HashMap<>();
               lose.put( "A Z", 3);
               lose.put("B X", 1);
                lose.put("C Y", 2);



        Map<String, Integer> win = new HashMap<>();
                win.put("A Y", 2);
               win.put("B Z", 3);
                win.put("C X", 1);


        Map<String, Integer> draw = new HashMap<>();
             draw.put(   "A X", 1);
               draw.put( "B Y", 2);
               draw.put( "C Z", 3);


        for (String match : matches) {
            if (win.containsKey(match)) {
                totalScore += (win.get(match) + 6);
            }

            if (lose.containsKey(match)) {
                totalScore += lose.get(match);
            }

            if (draw.containsKey(match)) {
                totalScore += (draw.get(match) + 3);
            }
        }

        return totalScore;
    }

    private static List<String> chooseShape(List<String> matches) {
        List<String> finalMatches = new ArrayList<>();

        String  playerOneMove = "";
        String playerTwoGoal = "";

        for (String match : matches) {
            String[] moves = match.split(" ");
            playerOneMove = moves[0];
            playerTwoGoal = moves[1];

            String playerTwoMove = "";

            switch(playerTwoGoal) {
                case "X":
                    playerTwoMove = losingShape(playerOneMove);
                    break;
                case "Y":
                    playerTwoMove = drawingShape(playerOneMove);
                    break;
                case "Z":
                    playerTwoMove = winningShape(playerOneMove);
                    break;
            }
            finalMatches.add(playerOneMove + " "  +  playerTwoMove);
        }
        return finalMatches;
    }

    private static String losingShape(String playerOneMove){
         switch(playerOneMove) {
             case "A" : playerOneMove = "Z";
             break;
             case "B" : playerOneMove= "X";
             break;
             case "C" : playerOneMove= "Y";
             break;
             default : throw new IllegalStateException("Unexpected value");
        };
         return playerOneMove;
    }

    private static String winningShape(String playerOneMove){
        switch(playerOneMove) {
            case "A" : playerOneMove="Y";
            break;
            case "B" : playerOneMove="Z";
                break;
            case "C" : playerOneMove= "X";
                break;
            default : throw new IllegalStateException("Unexpected value");
        };
        return playerOneMove;
    }

    private static String drawingShape(String playerOneMove) {
       switch(playerOneMove) {
           case "A" : playerOneMove= "X";
           break;
           case "B" : playerOneMove ="Y";
           break;
           case "C" : playerOneMove="Z";
           break;
           default : throw new IllegalStateException("Unexpected value");
        };
       return playerOneMove;
    }


}