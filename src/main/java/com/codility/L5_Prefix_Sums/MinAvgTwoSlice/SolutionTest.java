package com.codility.L5_Prefix_Sums.MinAvgTwoSlice;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test(timeout = 2000)
    public void solution() throws Exception {
        assertEquals(1, new Solution().solution(new int[]{4, 2, 2, 5, 1, 5, 8}));
    }

    @Test(timeout = 1)
    public void solution2() throws Exception {
        assertEquals(0, new Solution().solution(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1}));
    }

    @Test
    public void solution4() throws Exception {
        assertEquals(0, new Solution().solution(new int[]{1, 1}));
    }

    @Test
    public void solution5() throws Exception {
        assertEquals(0, new Solution().solution(new int[]{1, 1, 7, 7, 7, 7, 7}));
    }

    @Test
    public void solution6() throws Exception {
        assertEquals(5, new Solution().solution(new int[]{7, 7, 7, 7, 7, 1, 1}));
    }

    @Test
    public void solution7() throws Exception {
        assertEquals(2, new Solution().solution(new int[]{-3, -5, -8, -4, -10}));
    }

    @Test
    public void solution8() throws Exception {
        assertEquals(0, new Solution().solution(new int[]{-1, 0, 1, 0, 0, 0, 0, 1}));
    }

    @Test
    public void solution9() throws Exception {
        for (int i = 0; i < 100; i++) {
            int[] data = getRandomArray(100);
            int[] data2 = data.clone();
            int result = -1;
            try {
                result = new Solution().nativeSolution(data);
                assertEquals(result, new Solution().solution(data2));
            } catch (AssertionError e) {
                System.out.print(result + ": ");
                for (int j = 0; j < data.length; j++) {
                    System.out.print(data[j] + ", ");
                }
                System.out.println();
            }
        }
    }

    private int[] getRandomArray(int length) {
        int[] result = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            result[i] = random.nextInt(10000);
        }
        return result;
    }

    @Test
    public void solution10() throws Exception {
        assertEquals(1, new Solution().solution(new int[]{9, 2, 1, 2, 6, 4, 3, 9, 4, 7}));
    }

    @Test(timeout = 2000)
    public void solution11() throws Exception {
        assertEquals(0, new Solution().solution(getMonotonicArray(200000, 1)));
    }

    private int[] getMonotonicArray(int length, int value) {
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = 1;
        }
        return result;
    }

}