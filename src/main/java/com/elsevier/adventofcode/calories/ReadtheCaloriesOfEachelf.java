package com.elsevier.adventofcode.calories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.toList;

public class ReadtheCaloriesOfEachelf {
    private static final String EMPTY_STR = "";

    public static void main(final String[] args) throws IOException {
        //Creating instance to avoid static member methods
        ReadtheCaloriesOfEachelf instance
                = new ReadtheCaloriesOfEachelf();

        InputStream is = instance.getFileAsIOStream("elf");
        //instance.printFileContent(is);

        is = instance.getFileAsIOStream("elf");
        instance.printFileContent(is);
    }

    private InputStream getFileAsIOStream(final String fileName) {
        InputStream ioStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(fileName);

        if (ioStream == null) {
            throw new IllegalArgumentException(fileName + " is not found");
        }
        return ioStream;
    }

    Map<Integer, Integer> all = new HashMap();

    private void printFileContent(InputStream is) throws IOException {
        try (InputStreamReader isr = new InputStreamReader(is);
             BufferedReader br = new BufferedReader(isr);) {
            String line;
            int caloriesCount = 0;
            int elfCount = 0;
            while ((line = br.readLine()) != null) {
                if (line.equals(EMPTY_STR)) {
                    all.put(elfCount++, caloriesCount);
                    caloriesCount = 0;
                } else {
                    caloriesCount = caloriesCount + Integer.parseInt(line);

                }
            }


            is.close();
        }
        // System.out.println(all);

        getTop3ElfCalories(all);
    }

    private void getTop3ElfCalories(Map<Integer, Integer> all) {
        List<Map.Entry<Integer, Integer>> top3 = all.entrySet().stream()
                .sorted(comparing(Map.Entry::getValue, reverseOrder()))
                .limit(3)
                .collect(toList());

        int sum = 0;
        //Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < top3.size(); i++) {
            sum = sum + top3.get(i).getValue();
        }
        System.out.println(sum);


    }


}