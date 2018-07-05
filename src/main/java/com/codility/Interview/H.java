package com.codility.Interview;

/**
 * Created by Chaklader on 7/5/18.
 */
public class H {


    // problem - ll
    // ------------

    static String mergeStrings(String a, String b) {

        boolean eql =  a.length() ==  b.length();
        boolean less =  a.length() < b.length();
        // boolean greater =  a.length() > b.length();

        int min = less ? a.length(): b.length();

        String rst = "";

        for (int i = 0; i < min; i++){

            rst +=  "" + a.charAt(i) + b.charAt(i);
            // rst +=   new StringBuilder().append(a.charAt(i)).append(b.charAt(i)).toString();
            // rst += String.valueOf(a.charAt(i)) + String.valueOf(b.charAt(i));
        }

        if(eql){
            return rst;
        }

        else if(less){
            return rst += b.substring(min);
        }

        return rst += a.substring(min);
    }
    /* END ofsolution -  ll*/




}
