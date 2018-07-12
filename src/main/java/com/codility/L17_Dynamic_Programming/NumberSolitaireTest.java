//package com.codility.L17_Dynamic_Programming;
//
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class NumberSolitaireTest {
//    @Test
//    public void solution() throws Exception {
//        NumberSolitaire.Solution numberSolitaire = new NumberSolitaire.Solution();
//        int[] data = new int[]{1, -2, 0, 9, -1, -2};
//        assertEquals(numberSolitaire.solution(data), 8);
//    }
//
//    @Test
//    public void emptyArray() {
//        NumberSolitaire.Solution numberSolitaire = new NumberSolitaire.Solution();
//        int[] data = new int[]{};
//        assertEquals(numberSolitaire.solution(data), 0);
//    }
//
//    @Test
//    public void onlyOneElement() {
//        NumberSolitaire.Solution numberSolitaire = new NumberSolitaire.Solution();
//        int[] data = new int[]{-2};
//        assertEquals(numberSolitaire.solution(data), -2);
//    }
//
//    @Test
//    public void diceProblem() {
//        NumberSolitaire.Solution numberSolitaire = new NumberSolitaire.Solution();
//        int[] data = new int[]{-2, -1, -2, -3, -4, -3, 0, -5, 6, -2};
//        assertEquals(numberSolitaire.solution(data), 2);
//    }
//
//    @Test
//    public void allNegative() {
//        NumberSolitaire.Solution numberSolitaire = new NumberSolitaire.Solution();
//        int[] data = new int[]{-2, -1, -2, -3, -10, -11, -12, -14, -16, -4, -3, -1, -5, -1, -2};
//        assertEquals(-11, numberSolitaire.solution(data));
//    }
//
//    @Test
//    public void allNegative2() {
//        NumberSolitaire.Solution numberSolitaire = new NumberSolitaire.Solution();
//        int[] data = new int[]{0, -4, -5, -2, -7, -9, -3, -10};
//        assertEquals(-12, numberSolitaire.solution(data));
//    }
//
//    public void allNegative3() {
//        NumberSolitaire.Solution numberSolitaire = new NumberSolitaire.Solution();
//        int[] data = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
//        assertEquals(-4, numberSolitaire.solution(data));
//    }
//
//}