package com.codility.L12_Euclidean_Algorithm.ChocolatesByNumbers;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void solution() throws Exception {
        assertEquals(5, new Solution().solution(10, 4));
    }

    @Test
    public void solution2() throws Exception {
        assertEquals(1, new Solution().solution(1, 4));
    }
}