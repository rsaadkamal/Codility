package com.codility.L15_Caterpiller_Method.CountTriangles;

import org.junit.Test;
import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void solution() throws Exception {
        assertEquals(4, new Solution().solution(new int[]{10, 2, 5, 1, 8, 12}));
    }
}