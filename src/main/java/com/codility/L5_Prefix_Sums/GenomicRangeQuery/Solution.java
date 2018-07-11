package com.codility.L5_Prefix_Sums.GenomicRangeQuery;

class Solution {

    public int[] solution(String S, int[] P, int[] Q) {
        int[] data = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            switch (S.charAt(i)) {
                case 'A':
                    data[i] = 0;
                    break;
                case 'C':
                    data[i] = 1;
                    break;
                case 'G':
                    data[i] = 2;
                    break;
                case 'T':
                    data[i] = 3;
                    break;
            }
        }
        int[][] map = new int[4][data.length + 1];
        map[data[0]][0] = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < data.length; j++) {
                if (data[j] == i) {
                    map[i][j] = map[i][j - 1] + 1;
                } else {
                    map[i][j] = map[i][j - 1];
                }
            }
        }
        int[] result = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            for (int j = 0; j < 4; j++) {
                if (map[j][Q[i]] - (P[i] - 1 >= 0 ? map[j][P[i] - 1] : 0) > 0) {
                    result[i] = j + 1;
                    break;
                }
            }
        }
        return result;
    }
}