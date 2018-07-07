package com.codility.Additional;

/*
 * Given a matrix in which each row and each column is sorted, write a method to find an element in it
 * */


/**
 * Created by Chaklader on 7/6/18.
 */
public class Coordinate implements Cloneable {

    public int row;
    public int column;

    public Coordinate(int r, int c) {
        row = r;
        column = c;
    }

    public boolean inbounds(int[][] matrix) {

        return row >= 0 &&
                column >= 0 &&
                row < matrix.length &&
                column < matrix[0].length;
    }

    public boolean isBefore(Coordinate p) {
        return row <= p.row && column <= p.column;
    }

    public Object clone() {
        return new Coordinate(row, column);
    }

    public void moveDownRight() {
        row++;
        column++;
    }

    public void setToAverage(Coordinate min, Coordinate max) {
        row = (min.row + max.row) / 2;
        column = (min.column + max.column) / 2;
    }


    /*solution - b*/
    public static Coordinate findElementUpdated(int[][] matrix, int x) {

        Coordinate origin = new Coordinate(0, 0);
        Coordinate dest = new Coordinate(matrix.length - 1, matrix[0].length - 1);
        return findElementUpdated(matrix, origin, dest, x);
    }

    public static Coordinate findElementUpdated(int[][] matrix, Coordinate origin, Coordinate dest, int x) {

        if (!origin.inbounds(matrix) || !dest.inbounds(matrix)) {
            return null;
        }

        if (matrix[origin.row][origin.column] == x) {
            return origin;
        } else if (!origin.isBefore(dest)) {
            return null;
        }

		/*Set start to start of diagonal and end to
		the end of the diagonal. Since the grid may
		not be square, the end of the diagonal may
		not equal dest*/

        Coordinate start = (Coordinate) origin.clone();
        int diagDist = Math.min(dest.row - origin.row, dest.column - origin.column);
        Coordinate end = new Coordinate(start.row + diagDist, start.column + diagDist);
        Coordinate p = new Coordinate(0, 0);

		/*Do binary search on the diagonal, looking
		for the first element greater than x*/
        while (start.isBefore(end)) {

            p.setToAverage(start, end);

            if (x > matrix[p.row][p.column]) {

                start.row = p.row + 1;
                start.column = p.column + 1;
            } else {

                end.row = p.row - 1;
                end.column = p.column - 1;
            }
        }

		/*Split the grid into quadrants. Search
		the bottom left and the top right.*/
        return partitionAndSearch(matrix, origin, dest, start, x);
    }

    public static Coordinate partitionAndSearch(int[][] matrix, Coordinate origin,
                                                Coordinate dest, Coordinate pivot, int elem) {

        Coordinate lowerLeftOrigin = new Coordinate(pivot.row, origin.column);
        Coordinate lowerLeftDest = new Coordinate(dest.row, pivot.column - 1);

        Coordinate upperRightOrigin = new Coordinate(origin.row, pivot.column);
        Coordinate upperRightDest = new Coordinate(pivot.row - 1, dest.column);

        Coordinate lowerLeft = findElementUpdated(matrix, lowerLeftOrigin, lowerLeftDest, elem);

        if (lowerLeft == null) {

            return findElementUpdated(matrix, upperRightOrigin, upperRightDest, elem);
        }

        return lowerLeft;
    }

    /*END of solution - b*/

	/*END fo solution 9- 6: Given a matrix in which each
	row and each column is sorted, write a method to find
	an element in it.*/



	/*
	* print matrix
	* */
    private static void printMatrix(int[][] matrix) {

    }


    /*
     * solution - a
     * */
    public static boolean findElement(int[][] matrix, int elem) {

        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {

            if (matrix[row][col] == elem) {

                return true;
            } else if (matrix[row][col] > elem) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }
    /*
     * END of solution - a
     * */


    public static void main(String[] args) {


        /*
         * solution - a
         * */
//        int M = 10;
//        int N = 5;
//        int[][] matrix = new int[M][N];
//        for (int i = 0; i < M; i++) {
//            for (int j = 0; j < N; j++) {
//                matrix[i][j] = 10 * i + j;
//            }
//        }
//
//        printMatrix(matrix);
//
//        for (int i = 0; i < M; i++) {
//            for (int j = 0; j < M; j++) {
//                int v = 10 * i + j;
//                System.out.println(v + ": " + findElement(matrix, v));
//            }
//        }



        /*
         * solution - b
         * */
        int[][] matrix = {{15, 30, 50, 70, 73},
                {35, 40, 100, 102, 120},
                {36, 42, 105, 110, 125},
                {46, 51, 106, 111, 130},
                {48, 55, 109, 140, 150}};

        printMatrix(matrix);
        int m = matrix.length;
        int n = matrix[0].length;

        int count = 0;
        int littleOverTheMax = matrix[m - 1][n - 1] + 10;
        for (int i = 0; i < littleOverTheMax; i++) {

            Coordinate c = findElementUpdated(matrix, i);
            if (c != null) {
                System.out.println(i + ": (" + c.row + ", " + c.column + ")");
                count++;
            }
        }
        System.out.println("Found " + count + " unique elements.");

    }


}
