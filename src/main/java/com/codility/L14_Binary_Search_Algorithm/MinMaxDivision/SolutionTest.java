package com.codility.L14_Binary_Search_Algorithm.MinMaxDivision;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void solution() throws Exception {
        assertEquals(6, new Solution().solution(3, 5, new int[]{2, 1, 5, 1, 2, 2, 2}));
    }
}