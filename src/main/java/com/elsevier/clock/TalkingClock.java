package com.elsevier.clock;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TalkingClock {

    Map<Integer, String> hours = new HashMap<>();

    public String getHoursInWords(int x) {
        hours.put(0, "Twelve");
        hours.put(1, "one");
        hours.put(2, "Two");
        hours.put(3, "Three");
        hours.put(4, "Four");
        hours.put(5, "Five");
        hours.put(6, "Six");
        hours.put(7, "Seven");
        hours.put(8, "Eight");
        hours.put(9, "Nine");
        hours.put(10, "Ten");
        hours.put(11, "Eleven");

        return hours.get(x);
    }

    public String getMinOnce(int x) {
        Map<Integer, String> once = new HashMap<>();
        once.put(0, "");
        once.put(1, "one");
        once.put(2, "Two");
        once.put(3, "three");
        once.put(4, "Four");
        once.put(5, "Five");
        once.put(6, "Six");
        once.put(7, "Seven");
        once.put(8, "Eight");
        once.put(9, "Nine");
        return once.get(x);
    }

    public String getMinTeens(int x) {
        Map<Integer, String> teens = new HashMap<>();
        teens.put(0, "Ten");
        teens.put(1, "Eleven");
        teens.put(2, "Twelve");
        teens.put(3, "Thirteen");
        teens.put(4, "Fourteen");
        teens.put(5, "Fifteen");
        teens.put(6, "Sixteen");
        teens.put(7, "Seventeen");
        teens.put(8, "Eighteen");
        teens.put(9, "Nineteen");
    return teens.get(x);
    }

    public String getMinTens(int x) {

        Map<Integer, String> tens = new HashMap<>();
        tens.put(0, "");
        tens.put(1,"");
        tens.put(2,"Twenty");
        tens.put(3,"Thirty");
        tens.put(4,"Forty");
        tens.put(5,"Fifty");
        return tens.get(x);
    }


    public String talk(String s) {

     String hourMin []=  s.split(":");
    String hours = getHoursInWords(Integer.parseInt(hourMin[0]) % 12);
   String Suffix = (Integer.parseInt(hourMin[0]) < 12 ) ? "am" : "PM";

   String minute = "";
   if(Integer.parseInt(hourMin[1]) < 10){
       minute = getMinOnce(Integer.parseInt(hourMin[1]));
   }
   else if (Integer.parseInt(hourMin[1]) < 20){
       minute = getMinTeens(Integer.parseInt(hourMin[1]) % 10);
   }
   else {
       minute = getMinTens(Integer.parseInt(hourMin[1]) /10 )+ " " + getMinOnce(Integer.parseInt(hourMin[1]) % 10);
   }

   return "It's" + " " + hours + " " +minute + " " + Suffix;

    }
}
