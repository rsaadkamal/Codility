package com.codility.L10_Prime_Composite_Num.CountFactors;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void solution() throws Exception {
        assertEquals(8, new Solution().solution(24));
    }

    @Test
    public void solution2() throws Exception {
        assertEquals(8, new Solution().solution(69));
    }

    @Test
    public void solution3() throws Exception {
        assertEquals(3, new Solution().solution(4));
    }

    @Test(timeout = 2750)
    public void solution4() throws Exception {
        new Solution().solution(Integer.MAX_VALUE);
    }
}