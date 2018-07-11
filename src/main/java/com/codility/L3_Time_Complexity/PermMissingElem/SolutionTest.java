package com.codility.L3_Time_Complexity.PermMissingElem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void solution() throws Exception {
        assertEquals(4, new Solution().solution(new int[]{2, 3, 1, 5}));
    }

    @Test
    public void solution2() throws Exception {
        assertEquals(8, new Solution().solution(new int[]{1, 2, 3, 4, 5, 6, 7, 9, 10}));
    }

    @Test
    public void solution3() throws Exception {
        int[] data = generateArray(10, 8);
        assertEquals(1, new Solution().solution(generateArray(191111000, 1)));
    }

    public int[] generateArray(int count, int missing) {
        int[] result = new int[count-2];
        int counter = 0;
        for (int i = 1; i < count; i++) {
            if (i != missing) {
                result[counter] = i;
                counter++;
            }

        }
        return result;
    }
}