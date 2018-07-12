package com.codility.L10_Prime_Composite_Num;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class PeaksTest {
    @Test
    public void solution() throws Exception {
        assertEquals(3, new Peaks.Solution().solution(new int[]{1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}));
    }

    @Test
    public void solution2() throws Exception {
        assertEquals(1, new Peaks.Solution().solution(new int[]{1, 3, 2, 1}));
    }

    @Test
    public void solution4() throws Exception {
        assertEquals(1, new Peaks.Solution().solution(new int[]{1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2, 1}));
    }
}