package com.codility.L10_Prime_Composite_Num.Flags;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void solution() throws Exception {
        assertEquals(3, new Solution().solution(new int[]{1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}));
    }

    @Test
    public void solution2() throws Exception {
        assertEquals(0, new Solution().solution(new int[]{5}));
    }


    @Test
    public void solution4() throws Exception {
        assertEquals(1, new Solution().solution(new int[]{1, 3, 2}));
    }

    @Test
    public void solution5() throws Exception {
        assertEquals(0, new Solution().solution(new int[]{3, 2, 1}));
    }


    @Test
    public void solution6() throws Exception {
        assertEquals(2, new Solution().solution(new int[]{0, 0, 0, 0, 0, 1, 0, 1, 0, 1}));
    }
}