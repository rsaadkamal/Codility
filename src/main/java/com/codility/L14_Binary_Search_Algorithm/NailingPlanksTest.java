//package com.codility.L14_Binary_Search_Algorithm;
//
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.Random;
//
//import static org.junit.Assert.*;
//
//public class NailingPlanksTest {
//    @Test
//    public void solution() throws Exception {
//        assertEquals(4, new NailingPlanks.Solution().solution(new int[]{1, 4, 5, 8}, new int[]{4, 5, 9, 10}, new int[]{4, 6, 7, 10, 2}));
//    }
//
//    @Test
//    public void solution2() {
//        assertEquals(5, new NailingPlanks.Solution().solution(
//                new int[]{1, 4, 0, 5, 2, 6, 5, 4, 2, 4},
//                new int[]{1, 10, 4, 12, 4, 15, 8, 6, 3, 9},
//                new int[]{2, 8, 1, 7, 4}
//                )
//        );
//    }
//
//    @Test
//    public void solution3() {
//        assertEquals(4, new NailingPlanks.Solution().solution(
//                new int[]{4, 4, 2, 5, 7, 0, 7, 8, 8, 5},
//                new int[]{10, 11, 4, 10, 12, 1, 9, 15, 15, 14},
//                new int[]{3, 3, 1, 8, 5, 1, 5, 6, 9, 9}
//                )
//        );
//    }
//
//    @Test
//    public void solution4() {
//        assertEquals(5, new NailingPlanks.Solution().solution(
//                new int[]{5, 5, 1, 3, 2, 5, 4, 0, 8, 1},
//                new int[]{8, 9, 6, 11, 10, 5, 7, 7, 12, 8},
//                new int[]{9, 6, 4, 4, 5}
//                )
//        );
//    }
//
//    @Test
//    public void solution5() {
//        assertEquals(4, new NailingPlanks.Solution().solution(
//                new int[]{7, 4, 5, 7},
//                new int[]{12, 7, 5, 15},
//                new int[]{7, 4, 4, 5, 7}
//                )
//        );
//    }
//
//    @Test
//    public void solution6() {
//        assertEquals(5, new NailingPlanks.Solution().solution(
//                new int[]{1, 5, 2, 7},
//                new int[]{9, 6, 8, 14},
//                new int[]{4, 7, 1, 4, 6}
//                )
//        );
//    }
//
//    @Test
//    public void testVersusNativeSolution() {
//        int testsCount = 1000;
//        int wrong = 0;
//        for (int i = 0; i < testsCount; i++) {
//            ArrayList<int[]> testData = this.getRandomTestData(1000, 50, 100);
//            int res1 = new NailingPlanks.Solution().nativeSolution(testData.get(0).clone(), testData.get(1).clone(), testData.get(2).clone());
//            int res2 = new NailingPlanks.Solution().solution(testData.get(0).clone(), testData.get(1).clone(), testData.get(2).clone());
//            if (res1 != res2) {
//                int[] start = testData.get(0);
//                int[] end = testData.get(1);
//                int[] nails = testData.get(2);
//                for (int j = 0; j < start.length; j++) {
//                    System.out.print(start[j] + ", ");
//                }
//                System.out.println();
//                for (int j = 0; j < end.length; j++) {
//                    System.out.print(end[j] + ", ");
//                }
//                System.out.println();
//                for (int j = 0; j < nails.length; j++) {
//                    System.out.print(nails[j] + ", ");
//                }
//                wrong++;
//            }
//        }
//        assertEquals(0, wrong);
//    }
//
//    private ArrayList<int[]> getRandomTestData(int planksCount, int nailsCount, int scale) {
//        Random rnd = new Random();
//        int[] starts = new int[planksCount];
//        int[] ends = new int[planksCount];
//        for (int i = 0; i < planksCount; i++) {
//            starts[i] = rnd.nextInt(scale);
//            ends[i] = starts[i] + rnd.nextInt(scale);
//        }
//        int[] nails = new int[nailsCount];
//        for (int i = 0; i < nailsCount; i++) {
//            nails[i] = rnd.nextInt(scale);
//        }
//        ArrayList<int[]> result = new ArrayList<>();
//        result.add(0, starts);
//        result.add(1, ends);
//        result.add(2, nails);
//        return result;
//    }
//}