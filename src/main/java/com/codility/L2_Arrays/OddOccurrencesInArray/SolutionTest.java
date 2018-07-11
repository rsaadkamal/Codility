package com.codility.L2_Arrays.OddOccurrencesInArray;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void solution() throws Exception {
        assertEquals(7, new Solution().solution(new int[]{9, 3, 9, 3, 9, 7, 9}));
    }

    @Test
    public void solution1() throws Exception {
        assertEquals(-1, new Solution().solution(new int[]{9, 9}));
    }

    @Test
    public void solution2() throws Exception {
        assertEquals(7, new Solution().solution(new int[]{9, 9, 9, 7}));
    }

    @Test
    public void solution3() throws Exception {
        assertEquals(9, new Solution().solution(new int[]{9, 9, 9}));
    }
}