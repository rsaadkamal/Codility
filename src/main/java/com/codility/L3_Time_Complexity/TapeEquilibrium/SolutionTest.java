package com.codility.L3_Time_Complexity.TapeEquilibrium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void solution() throws Exception {
        assertEquals(1, new Solution().solution(new int[]{3, 1, 2, 4, 3}));
    }
}