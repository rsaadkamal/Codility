package com.codility.Interview;


import java.util.*;


/*
Q:3

//A prefix of a string S is any leading contiguous part of S. For example, the string "codility" has the following
//prefixes: "", "c", "co", "cod", "codi", "codil", "codili", "codilit" and "codility". A prefix of S is called
//proper if it is shorter than S. A suffix of a string S is any trailing contigous part of S. For example, the string
//"codility" has the following suffixes: "", "y", "ty", "ity", "lity", "ility", "dility", "odility" and "codility".
//A suffix of S is called proper if it is shorter than S.

Write a function: class Solution { public int solution(String S); } that, given a string S consisting of N
characters, returns the length of the longest string that is both a proper prefix of S and a proper suffix of S.
For example, given S = "abbabba" the function should return 4, because:

proper prefixes of S are: "", "a", "ab", "abb", "abba", "abbab", "abbabb"; proper suffixes of
S are: "", "a", "ba", "bba", "abba", "babba", "bbabba"; string "abba" is both a proper prefix and a proper suffix
of S; this is the longest such string. For example, given S = "codility" the function should return 0, because:
string "" is both a proper prefix and a proper suffix of S; this is the longest such string.

Complexity: expected worst-case time complexity is O(N); expected worst-case space complexity is O(N) (not
counting the storage required for input arguments). Assume that: the length of S is within the range [1..1,000,000];
string S consists only of lowercase letters (a−z). Copyright 2009–2018 by Codility Limited.
*/


/*
* Correctness: 100%
* Performance: 0%
* */

/**
 * Created by Chaklader on 8/8/18.
 */
public class CountPrefix {


    public static int solution(String S) {

        List<String> prefixes = new ArrayList<>();
        List<String> suffixes = new ArrayList<>();

        int N = S.length();

        for (int i = 0; i < N - 1; i++) {

            String prefix = S.substring(0, i + 1);
            prefixes.add(prefix);
        }

        for (int i = N - 1; i >= 1; i--) {

            String suffix = S.substring(i, N);
            suffixes.add(suffix);
        }

        int M = prefixes.size();
        int result = 0;

        for (int i = M - 1; i >= 0; i--) {

            if (prefixes.get(i).equals(suffixes.get(i))) {

                result = prefixes.get(i).length();
                return result;
            }
        }

        return result;
    }

}
