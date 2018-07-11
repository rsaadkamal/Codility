package com.codility.L11_Sieve_Of_Eratosthenes.CountSemiprimes;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void solution() throws Exception {
        int[] result = new Solution().solution(26, new int[]{1, 4, 16}, new int[]{26, 10, 20});
        assertArrayEquals(new int[]{10, 4, 0}, result);
    }
}