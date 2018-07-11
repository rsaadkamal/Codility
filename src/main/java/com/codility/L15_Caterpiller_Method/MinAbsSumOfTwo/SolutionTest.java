package com.codility.L15_Caterpiller_Method.MinAbsSumOfTwo;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void solution() throws Exception {
        assertEquals(1, new Solution().solution(new int[]{1, 4, -3}));
    }

    @Test
    public void solution2() throws Exception {
        assertEquals(3, new Solution().solution(new int[]{-8, 4, 5, -10, 3}));
    }

    @Test
    public void solution3() throws Exception {
        assertEquals(2000000000, new Solution().solution(new int[]{1000000000}));
    }

    @Test
    public void testVsNative() {
        for (int i = 0; i < 100; i++) {
            int[] random = generateRandomArray(10000, 5);
            int res1 = new Solution().solution(random.clone());
            int res2 = new Solution().nativeSolution(random.clone());
            assertEquals(res1, res2);
        }
    }

    private int[] generateRandomArray(int length, int scale) {
        Random random = new Random();
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = random.nextInt(scale);
        }
        return result;
    }
}