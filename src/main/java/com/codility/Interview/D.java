package com.codility.Interview;

// ZooPlus AG test
    /*question: Given an array of values, design and code
    an algorithm that returns whether there are two duplicates
    within k indices of each other? k indices and within plus
    or minus l (value) of each other? Do all, even the latter,
    in O(n) running time and O(k) space.*/
/*END OF SOLUTION*/



    /*  Running solution1...
    Compilation successful.

    Example test:    '00-44  48 5555 8361'
    WRONG ANSWER  (got 004-448-555-583-6- 8-361 expected 004-448-555-583-61)

    Example test:    '0 - 22 1985--324'
    WRONG ANSWER  (got 022-198-532-5---324 expected 022-198-53-24)

    Example test:    '555372654' */


import java.util.stream.IntStream;

/**
 * Created by Chaklader on 7/5/18.
 */
public class D {

    /*solution1-a*/
    public static String formatPhoneNumber(String S) {

        if(S == null || S.isEmpty() || S.length() < 2){
            return null;
        }

        String temp = "";

        for(int j = 0; j < S.length(); j++){

            char value = S.charAt(j);

            if(Character.isDigit(value)
                    && Character.getNumericValue(value) >= 0
                    && Character.getNumericValue(value) <= 200){

                temp += String.valueOf(value);
            }
        }

        if(temp.length() == 2){
            return temp;
        }

        String result = "";
        int len = temp.length();

        boolean bol = false;

        if(len%3 == 0)
            bol = true;

        for(int index = 0; index < len; index++){

            int rest = len - (index+1);

            if(rest % 2 == 0 && rest %3 != 0 && rest/3 == 1 && !bol){

                System.out.println(rest);

                result += String.valueOf(temp.charAt(index));

                String restString = temp.substring(index+1);

                result +=  "-"+restString.substring(0, 2)+ "-" + restString.substring(2);
                break;
            }

            if( (index+1) % 3 == 1 && index != 0) {
                result += "-";
            }

            result += String.valueOf(temp.charAt(index));

        }

        return result;
    }
    /*END of solution1-a*/


    /*solution1-b*/
    public static String formatPhoneNumber1(String s) {

        if (s == null) {
            return null;
        }

        return s.replaceAll("\\D", "")                // Discard all non-digits.
                .replaceAll("(\\d{2})(?=\\d{2}$)" +   // Final group of 4 digits
                                "|" +                     // ... or ...
                                "(\\d{3})(?!$)",          // non-final group of 3 digits,
                        "$1$2-");                 // insert separator.
    }
    /*END of solution1-b*/



    /*solution1-c*/
    // "Hello123 erere3435 efere 45 world.".replaceAll("[^\\d+]", "")
    public static String formatPhoneNumber3(String input) {

        // Guard
        if (input == null) {
            return input;
        }

        // Strip junk
        StringBuilder phone = new StringBuilder();

        IntStream.range(0, input.length())
                .filter(i -> Character.isDigit(input.charAt(i)))
                .forEachOrdered(i -> phone.append(Character.getNumericValue(input.charAt(i))));

        if (phone.length() <= 3) {
            return phone.toString();
        }

        // insert dashes... in reverse.
        // special cases for last group
        // set up the dash insert point for the end-of-groups.
        int dash = (phone.length() / 3) * 3;

        switch (phone.length() % 3) {

            case 0:
                // nothing to do for an exact grouping.
                break;
            case 1:
                // insert the dash making  2-2 groups instead of 3-1
                phone.insert(dash - 1, '-');
                break;
            case 2:
                // end up with a 3-2 group.
                phone.insert(dash, '-');
                break;
        }

        // easy cases for first groups.
        while (dash > 3) {
            dash -= 3;
            phone.insert(dash, '-');
        }

        return phone.toString();
    }
    /*END of solution1-c*/





}
