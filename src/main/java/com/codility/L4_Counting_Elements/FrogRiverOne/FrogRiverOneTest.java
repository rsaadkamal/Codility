package com.codility.L4_Counting_Elements.FrogRiverOne;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FrogRiverOneTest {
    @Test
    public void solution() throws Exception {
        int[] data = {1, 3, 1, 4, 2, 3, 5, 4};
        assertEquals(6, new Solution().solution(5, data));
    }
}