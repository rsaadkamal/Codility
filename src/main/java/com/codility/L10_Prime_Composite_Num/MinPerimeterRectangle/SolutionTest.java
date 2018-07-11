package com.codility.L10_Prime_Composite_Num.MinPerimeterRectangle;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void solution() throws Exception {
        assertEquals(22, new Solution().solution(30));
    }

    @Test
    public void solution2() throws Exception {
        assertEquals(24, new Solution().solution(36));
    }

    @Test
    public void solution3() throws Exception {
        assertEquals(4, new Solution().solution(1));
    }

}