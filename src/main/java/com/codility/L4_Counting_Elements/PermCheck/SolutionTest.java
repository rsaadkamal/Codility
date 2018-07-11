package com.codility.L4_Counting_Elements.PermCheck;

import static org.junit.Assert.*;

public class SolutionTest {
    @org.junit.Test
    public void solution() throws Exception {
        assertEquals(0, new Solution().solution(new int[]{4, 3, 1}));
    }

    @org.junit.Test
    public void solution2() throws Exception {
        assertEquals(1, new Solution().solution(new int[]{1, 2, 3}));
    }
}