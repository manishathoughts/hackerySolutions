package com.elsevier.clock;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TalkingClock {
    public String getHoursInWords(int x) {

        Map<Integer, String> hours = new HashMap<>();
        hours.put(0, "twelve");
        hours.put(1, "one");
        hours.put(2, "two");
        hours.put(3, "three");
        hours.put(4, "four");
        hours.put(5, "five");
        hours.put(6, "six");
        hours.put(7, "seven");
        hours.put(8, "eight");
        hours.put(9, "nine");
        hours.put(10, "ten");
        hours.put(11, "eleven");

        return hours.get(x);
    }

    public String getMinOnce(int x) {
        Map<Integer, String> once = new HashMap<>();
        once.put(0, "");
        once.put(1, "one");
        once.put(2, "two");
        once.put(3, "three");
        once.put(4, "four");
        once.put(5, "five");
        once.put(6, "six");
        once.put(7, "seven");
        once.put(8, "eight");
        once.put(9, "nine");
        return once.get(x);
    }

    public String getMinTeens(int x) {
        Map<Integer, String> teens = new HashMap<>();
        teens.put(0, "ten");
        teens.put(1, "eleven");
        teens.put(2, "twelve");
        teens.put(3, "thirteen");
        teens.put(4, "fourteen");
        teens.put(5, "fifteen");
        teens.put(6, "sixteen");
        teens.put(7, "seventeen");
        teens.put(8, "eighteen");
        teens.put(9, "nineteen");
        return teens.get(x);
    }

    public String getMinTens(int x) {

        Map<Integer, String> tens = new HashMap<>();
        tens.put(0, "");
        tens.put(1, "");
        tens.put(2, "twenty");
        tens.put(3, "thirty");
        tens.put(4, "forty");
        tens.put(5, "fifty");
        return tens.get(x);
    }


    public String talk(String s) {

        String hourMin[] = s.split(":");
        String hours = getHoursInWords(Integer.parseInt(hourMin[0]) % 12);
        String Suffix = (Integer.parseInt(hourMin[0]) < 12) ? "am" : "pm";

        String minute = "";
        if (Integer.parseInt(hourMin[1]) <= 1) {
            minute = getMinOnce(Integer.parseInt(hourMin[1]));
        } else if (Integer.parseInt(hourMin[1]) < 10) {
            minute = "oh " + getMinOnce(Integer.parseInt(hourMin[1]));
        } else if (Integer.parseInt(hourMin[1]) < 20) {
            minute = getMinTeens(Integer.parseInt(hourMin[1]) % 10);
        } else {
            minute = getMinTens(Integer.parseInt(hourMin[1]) / 10) + " " + getMinOnce(Integer.parseInt(hourMin[1]) % 10);
        }

        return "It's" + " " + hours + " " + minute + " " + Suffix;

    }
}
