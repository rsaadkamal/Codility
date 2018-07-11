package com.codility.Interview;

/*An integer X and a non-empty zero-indexed array A consisting of N integers are given.
    We are interested in which elements of A are equal to X and which are different from X.
    The goal is to split array A into two parts, such that the number of elements equal to X
    in the first part is the same as the number of elements different from X in the other part.
    More formally, we are looking for an index K such that:

    0 ≤ K < N and
    the number of elements equal to X in A[0..K−1] is the same as the number of elements different
    from X in A[K..N−1]. (For K = 0, A[0..K−1] does not contain any elements. For K = N, A[K..N-1]
    does not contain any elements.)

    For example, given integer X = 5 and array A such that:

    A = [5, 5, 1, 7, 2, 3, 5]

    K equals 4, because:

    two of the elements of A[0..3] are equal to X, namely A[0] = A[1] = X, and
    two of the elements of A[4..6] are different from X, namely A[4] and A[5].
    Write a function:

    int solution1(int X, int A[], int N);

    that, given an integer X and a non-empty zero-indexed array A consisting of N integers,
    returns the value of index K satisfying the above conditions. It can be shown such index
    K always exists and it is unique.

    For example, given integer X and array A as above, the function should return 4, as explained
    above.

    Assume that:

    N is an integer within the range [1..100,000];
    X is an integer within the range [0..100,000];
    Each element of array A is an integer within the range [0..100,000].
    Complexity:

    Expected worst-case time complexity is O(N);
    Expected worst-case space complexity is O(1), beyond input storage (not counting the storage
    required for input arguments).

    Elements of input arrays can be modified.
    Except of one edge case the solution1 is as simple as counting for a number of X within the A
    and then calculating K as that number substracted from an array length... Just think
    of it a bit:

    e.g. assume there're 4 occurences of X within a given A;
    divide an array by cutting off 4 element from the right;
    whatever remained is gonna be on the left;
    even if after such a cut some of X's was 'lost' on the right - not a big deal; logically
    enough that after division every X found on the right side is gracefully leveled by a
    non-X on the left side. [3,5,1,5,7,8,3,2,8] -> [3,5,1,5,7,8,3 | 2,8] Two of X on the left = two
    of non-X on the right

    [3,5,1,5,7,8,5,5,8] -> [3,5,1,5,7 | 8,5,5,8] Are two of X 'trapped' on the right side? Not
    problem at all! That only means that we have got for two less X on the left and for two less
    non-X on the right, thus anyway 2 of X on the left = 2 of non-X on the right;

    As for an exception mentioned earlier, the described solution1 will fail when all the X values
    are grouped in one rightmost sequence, e.g. [3,5,5,5,5] -> [3 | 5,5,5,5] is wrong because for
    X=5 by cutting 4 elements from the right eventually we will get an index of 1 thus leaving
    no elements equal to X on the left at all. But as you may remember according to the condition
    it's the first (i.e. left) part of an array that must contain X in quantity equal to a quantity
    of non-X's in the second part (i.e. right). And as for this very edge case we're gonna return
    just length of an input array which is a sort of an acceptable answer due to this:
    "for K = N, A[K..N-1] does not contain any elements".*/

/**
 * Created by Chaklader on 7/5/18.
 */
public class F {


    public int splitArray(int X, int[] A) {

        if(A == null || A.length == 0){
            return -1;
        }

        if(X < 0 || X > 100000) return -1;

        int N = A.length;

        if(N < 1 || N > 100000) return -1;

        int sum = 0, seg  = 0;

        for (int j = 0; j < N; j++){

            if(A[j]< 0 || A[j] > 100000)
                return -1;

            if(A[j] == X){
                sum++;
                seg++;
            }

            else
                seg = 0;
        }

        return (A[N-1]!=X || sum > seg) ? (N - sum) : N;
    }
    /*END of solution1:*/
    /*eDreams ODIGEO*/
    /*================*/



}
