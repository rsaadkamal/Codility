package com.codility.L11_Sieve_Of_Eratosthenes.CountNonDivisible;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void solution() throws Exception {
        assertArrayEquals(new int[]{2, 4, 3, 2, 0}, new Solution().solution(new int[]{3, 1, 2, 3, 6}));
    }

    @Test
    public void solution2() throws Exception {
        assertArrayEquals(new int[]{1, 0}, new Solution().solution(new int[]{2, 4}));
    }
}