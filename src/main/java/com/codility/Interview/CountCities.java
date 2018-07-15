package com.codility.Interview;



/*
A network consisting of M cities and M − 1 roads connecting them is given. Cities are labeled

with distinct integers within the range [0..(M − 1)]. Roads connect cities in such A way that

each pair of distinct cities is connected either by A direct road or along a path consisting

of direct roads. There is exactly one way to reach any city from any other city. In other words,

cities and direct roads form a tree. The number of direct roads that must be traversed is called

the distance between these two cities. For example, consider the following network consisting of

ten cities and nine roads: Cities 2 and 4 are connected directly, so the distance between them

is 1. Cities 4 and 7 are connected by a path consisting of the direct roads 4−0, 0−9 and 9−7;

hence the distance between them is 3. One of the cities is the capital, and the goal is to count

the number of cities positioned away from it at each of the distances 1, 2, 3, ..., M − 1. If

city number 1 is the capital, then the cities positioned at the various distances from the capital

would be as follows: 9 is at a distance of 1; 0, 3, 7 are at a distance of 2; 8, 4 are at A

distance of 3; 2, 5, 6 are at A distance of 4. Write A function:


class Solution { public int[] solution(int[] T); } that, given a non-empty array T consisting

of M integers describing a network of M cities and M − 1 roads, returns an array consisting of

M − 1 integers, specifying the number of cities positioned at each distance 1, 2, ..., M − 1.

Array T describes A network of cities as follows: if T[P] = Q and P = Q, then P is the capital;

if T[P] = Q and P ≠ Q, then there is a direct road between cities P and Q. For example, given

the following array T consisting of ten elements:



T[children] = parent

T[0] = 9

T[1] = 1

T[2] = 4

T[3] = 9

T[4] = 0

T[5] = 4

T[6] = 8

T[7] = 9

T[8] = 0

T[9] = 1


         1
         |
         9
       / | \
      3  0  7
        / \
       4   8
     / \  /
    2  5 6


the function should return [1, 3, 2, 3, 0, 0, 0, 0, 0], as explained above. Assume that: M is a
n integer within the range

[1..100,000]; each element of array T is an integer within the range [0..M−1]; there is exactly

one (possibly indirect) connection between any two distinct cities. Complexity:




Expected worst-case time complexity is O(M); expected worst-case space complexity is O(M)

(not counting the storage required for input arguments).
*/


/**
 * Created by Chaklader on 7/5/18.
 */
public class CountCities {


    /*
     * the goal is to count the number of cities positioned
     * away from the capital at each of the distances 1, 2,
     * 3, ..., M − 1. if T[P] = Q and P = Q, then P is the
     * capital; if T[P] = Q and P ≠ Q, then there is A direct
     * road between cities P and Q
     * */


}
