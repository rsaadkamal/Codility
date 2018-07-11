package com.codility.L5_Prefix_Sums.GenomicRangeQuery;

import static org.junit.Assert.*;

public class SolutionTest {
    @org.junit.Test
    public void solution() throws Exception {
        assertArrayEquals(new int[]{2, 4, 1}, new Solution().solution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6}));
    }


    @org.junit.Test
    public void solution2() throws Exception {
        assertArrayEquals(new int[]{3, 3, 3}, new Solution().solution("GGGGGGG", new int[]{2, 5, 0}, new int[]{4, 5, 6}));
    }

    @org.junit.Test
    public void solution3() throws Exception {
        int[] result = new Solution().solution("AC", new int[]{0, 0, 1}, new int[]{0, 1, 1});
        assertArrayEquals(new int[]{1, 1, 2}, result);
    }

    @org.junit.Test
    public void solution4() throws Exception {
        int[] result = new Solution().solution("TC", new int[]{0, 0, 1}, new int[]{0, 1, 1});
        assertArrayEquals(new int[]{4, 2, 2}, result);
    }
}