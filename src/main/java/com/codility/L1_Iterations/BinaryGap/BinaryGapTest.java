package com.codility.L1_Iterations.BinaryGap;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void test() throws Exception {
        assertEquals(2, new Solution().solution(9));
    }

    @Test
    public void test1() throws Exception {
        assertEquals(1, new Solution().solution(20));
    }

    @Test
    public void test2() throws Exception {
        assertEquals(0, new Solution().solution(15));
    }

    @Test
    public void test3() throws Exception {
        assertEquals(5, new Solution().solution(1041));
    }

}