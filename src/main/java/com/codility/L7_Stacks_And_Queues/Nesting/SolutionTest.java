package com.codility.L7_Stacks_And_Queues.Nesting;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void solution() throws Exception {
        assertEquals(1, new Solution().solution("(()(())())"));
    }

    @Test
    public void solution2() throws Exception {
        assertEquals(0, new Solution().solution(")("));
    }

    @Test
    public void solution3() throws Exception {
        assertEquals(0, new Solution().solution("())"));
    }
}