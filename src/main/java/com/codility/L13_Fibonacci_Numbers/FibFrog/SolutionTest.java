package com.codility.L13_Fibonacci_Numbers.FibFrog;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test(timeout = 2000)
    public void solution() throws Exception {
        assertEquals(3, new Solution().solution(new int[]{0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0}));
    }


    @Test(timeout = 2000)
    public void solution5() throws Exception {
        assertEquals(1, new Solution().solution(new int[]{}));
    }

    @Test(timeout = 2000)
    public void solution6() throws Exception {
        assertEquals(-1, new Solution().solution(new int[]{0, 0, 0, 0, 0}));
    }

    @Test(timeout = 2000)
    public void solution7() throws Exception {
        assertEquals(2, new Solution().solution(new int[]{1, 1, 1}));
    }

    @Test(timeout = 2000)
    public void solution8() throws Exception {
        assertEquals(2, new Solution().solution(new int[]{0, 0, 0, 0, 1}));
    }

    @Test(timeout = 2000)
    public void solution9() throws Exception {
        assertEquals(2, new Solution().solution(new int[]{1, 1, 0, 0, 0}));
    }
}