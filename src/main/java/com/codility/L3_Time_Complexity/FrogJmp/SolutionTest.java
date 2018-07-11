package com.codility.L3_Time_Complexity.FrogJmp;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void solution() throws Exception {
        assertEquals(3, new Solution().solution(10, 85, 30));
    }

    @Test
    public void solution2() throws Exception {
        assertEquals(2, new Solution().solution(1, 3, 1));
    }

}