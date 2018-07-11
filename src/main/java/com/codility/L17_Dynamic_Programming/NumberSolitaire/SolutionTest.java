package com.codility.L17_Dynamic_Programming.NumberSolitaire;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void solution() throws Exception {
        Solution numberSolitaire = new Solution();
        int[] data = new int[]{1, -2, 0, 9, -1, -2};
        assertEquals(numberSolitaire.solution(data), 8);
    }

    @Test
    public void emptyArray() {
        Solution numberSolitaire = new Solution();
        int[] data = new int[]{};
        assertEquals(numberSolitaire.solution(data), 0);
    }

    @Test
    public void onlyOneElement() {
        Solution numberSolitaire = new Solution();
        int[] data = new int[]{-2};
        assertEquals(numberSolitaire.solution(data), -2);
    }

    @Test
    public void diceProblem() {
        Solution numberSolitaire = new Solution();
        int[] data = new int[]{-2, -1, -2, -3, -4, -3, 0, -5, 6, -2};
        assertEquals(numberSolitaire.solution(data), 2);
    }

    @Test
    public void allNegative() {
        Solution numberSolitaire = new Solution();
        int[] data = new int[]{-2, -1, -2, -3, -10, -11, -12, -14, -16, -4, -3, -1, -5, -1, -2};
        assertEquals(-11, numberSolitaire.solution(data));
    }

    @Test
    public void allNegative2() {
        Solution numberSolitaire = new Solution();
        int[] data = new int[]{0, -4, -5, -2, -7, -9, -3, -10};
        assertEquals(-12, numberSolitaire.solution(data));
    }

    public void allNegative3() {
        Solution numberSolitaire = new Solution();
        int[] data = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        assertEquals(-4, numberSolitaire.solution(data));
    }

}