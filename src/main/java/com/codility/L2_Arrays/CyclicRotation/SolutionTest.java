package com.codility.L2_Arrays.CyclicRotation;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void solution() throws Exception {
        assertArrayEquals(new int[]{9, 7, 6, 3, 8}, new Solution().solution(new int[]{3, 8, 9, 7, 6}, 3));
    }

    @Test
    public void solution1() throws Exception {
        assertArrayEquals(new int[]{9}, new Solution().solution(new int[]{9}, 3));
    }

    @Test
    public void solution2() throws Exception {
        assertArrayEquals(new int[]{}, new Solution().solution(new int[]{}, 3));
    }
}