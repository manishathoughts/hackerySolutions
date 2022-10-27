package com.elsevier.dawkinsweasel;

import javafx.util.Pair;

import java.util.*;

public class Dawkins {

    Random random = new Random();

    String ALL_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";

    String EXPECTED_STRING = "METHINKS IT IS LIKE A WEASEL";

    public Dawkins() {
        String random28CharString = get28CharString();
        Pair<String, Integer> bestMatch = findBestMatch(random28CharString);
        while (!bestMatch.getKey().equals(EXPECTED_STRING)) {
            System.out.printf("Best Matched String: %s, score: %d \n", bestMatch.getKey(), bestMatch.getValue());
            bestMatch = findBestMatch(bestMatch.getKey());
        }
            System.out.println("Done!!!");
    }

    private Pair<String, Integer> findBestMatch(String random28CharString) {
        List<String> hundredCopyList = createHundredCopyList(random28CharString);
        int bestMatchedScore = 0;
        Pair<String, Integer> bestMatch = null;
        for(String copy: hundredCopyList) {
            String mutatedWord = mutateWordWhen5pcChance(copy);
            int score = countMatchingCharacters(mutatedWord);
            if (score > bestMatchedScore) {
                bestMatch = new Pair<>(mutatedWord, bestMatchedScore);
            }
        }
        return bestMatch;
    }

    public char getRandomChar(String s) {
        int index = random.nextInt(s.length());
        return s.charAt(index);
    }

    public String get28CharString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 28; i++) {
            sb = sb.append(getRandomChar(ALL_CHARS));
        }
        return sb.toString();
    }

    public List<String> createHundredCopyList(String random28CharString) {
        List<String> hundredCopyList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            hundredCopyList.add(random28CharString);
        }
        return hundredCopyList;
    }

    public String mutateWordWhen5pcChance(String random28CharStringCopy) {
        StringBuilder mutatedWord = new StringBuilder();
        for (int i = 0; i < random28CharStringCopy.length(); i++) {
            if (random.nextInt(100) <= 5) {
                mutatedWord.append(getRandomChar(ALL_CHARS));
            } else{
                mutatedWord.append(random28CharStringCopy.charAt(i));
            }
        }
        return mutatedWord.toString();
    }

    public int countMatchingCharacters(String mutatedString) {
        int score = 0;
        for (int i = 0; i < EXPECTED_STRING.length(); i++) {
            if (EXPECTED_STRING.charAt(i) == mutatedString.charAt(i)) {
                score = score + 1;
            }
        }
        return score;
    }
}
