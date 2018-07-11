package com.codility.L4_Counting_Elements.MaxCounters;

import static org.junit.Assert.*;

public class SolutionTest {
    @org.junit.Test
    public void solution() throws Exception {
        assertArrayEquals(new int[]{3, 2, 2, 4, 2}, new Solution().solution(5, new int[]{3, 4, 4, 6, 1, 4, 4}));
    }
}