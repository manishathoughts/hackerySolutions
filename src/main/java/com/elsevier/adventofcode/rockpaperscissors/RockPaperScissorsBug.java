package com.elsevier.adventofcode.rockpaperscissors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RockPaperScissorsBug {

    static final int ROCK = 1;
    static final int PAPER = 2;
    static final int SCISSORS = 3;

    private static Map<String, String> playerChoiceToOptionsMap = new HashMap<>();


    private static Map<String, String> computerChoiceToOptionsMap = new HashMap<>();

    private static Map<String, Integer> score = new HashMap<>();


    public static void main(String[] args) {
        Path path = Paths.get("src/main/resources/rockpaperscissors");
        try {
            playerChoiceToOptionsMap.put("X", "rock");
            playerChoiceToOptionsMap.put("Y", "paper");
            playerChoiceToOptionsMap.put("Z", "scissors");

            computerChoiceToOptionsMap.put("A", "rock");
            computerChoiceToOptionsMap.put("B", "paper");
            computerChoiceToOptionsMap.put("C", "scissors");

            score.put("rock", 1);
            score.put("paper", 2);
            score.put("scissors", 3);

            List<String> contents = Files.readAllLines(path);
            int totalPlayerScore = 0;
            for (String content : contents) {
                int playScore = 0;

                String contentSplit[] = content.split(" ");
                String opponentChoice = contentSplit[0];
                String myChoice = contentSplit[1];

                int playerChoiceScore = getChoiceScore(myChoice, "human");
                int computerChoiceScore = getChoiceScore(opponentChoice, "computer");

//                String opponentMove;
//                if (opponentChoice.equals("A")) {
//                    opponentMove = "rock";
//                } else if (opponentChoice.equals("B")) {
//                    opponentMove = "paper";
//                } else {
//                    opponentMove = "scissors";
//                }
//
//                String myMove;
//                if (myChoice.equals("X")) {
//                    myMove = "rock";
//
//                } else if (myChoice.equals("Y")) {
//                    myMove = "paper";
//
//                } else {
//                    myMove = "scissors";
//
//                }

                // Print results
                if (playerChoiceScore == computerChoiceScore) {
                    playScore = 2 * playerChoiceScore;
                    System.out.printf("It's a draw, player: %s, computer: %s, score: %d!\n", myChoice, opponentChoice, playScore);
                } else if (playerChoiceScore > computerChoiceScore) {
                    playScore = playerChoiceScore + 6;
                    System.out.printf("Player wins! player: %s, computer: %s, score: %d!\n", myChoice, opponentChoice,playScore);
                } else {
                    playScore = playerChoiceScore;
                    System.out.printf("Computer wins!player: %s, computer: %s, score: %d!\n", myChoice, opponentChoice, playScore);
                }
                totalPlayerScore = playScore + totalPlayerScore;
            }
            System.out.printf("Gross Player Score is %d \n", totalPlayerScore);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static int getChoiceScore(String choice, String player) {
        return player.equals("human") ? score.get(playerChoiceToOptionsMap.get(choice))
                : score.get(computerChoiceToOptionsMap.get(choice));
    }
}
