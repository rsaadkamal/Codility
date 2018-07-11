package com.codility.L6_Sorting.MaxProductOfThree;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void solution() throws Exception {
        assertEquals(30, new Solution().solution(new int[]{-2, -3, 5}));
    }

    @Test
    public void solution2() throws Exception {
        assertEquals(30, new Solution().solution(new int[]{-2, -3, 4, 5}));
    }

    @Test
    public void solution3() throws Exception {
        assertEquals(-12, new Solution().solution(new int[]{-2, -3, -5, -2}));
    }

    @Test
    public void solution4() throws Exception {
        assertEquals(120, new Solution().solution(new int[]{1, 2, 3, 4, 5, 6}));
    }

    @Test
    public void solution5() throws Exception {
        assertEquals(120, new Solution().solution(new int[]{-1, -2, 3, 4, 5, 6}));
    }

    @Test
    public void solution6() throws Exception {
        assertEquals(1200, new Solution().solution(new int[]{-10, -20, 3, 4, 5, 6}));
    }
}