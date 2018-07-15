package com.codility.Fluorum_2014;

/*
* A country network consisting of N cities and N − 1 roads connecting them is given. Cities are labeled with distinct integers within the range [0..(N − 1)]. Roads connect cities in such a way that each distinct pair of cities is connected either by a direct road or through a path consisting of direct roads. There is exactly one way to reach any city from any other city.

Starting out from city K, you have to plan a series of daily trips. Each day you want to visit a previously unvisited city in such a way that, on a route to that city, you will also pass through a maximal number of other unvisited cities (which will then be considered to have been visited). We say that the destination city is our daily travel target.

In the case of a tie, you should choose the city with the minimal label. The trips cease when every city has been visited at least once.

For example, consider K = 2 and the following network consisting of seven cities and six roads:



You start in city 2. From here you make the following trips:

day 1 − from city 2 to city 0 (cities 1 and 0 become visited),
day 2 − from city 0 to city 6 (cities 4 and 6 become visited),
day 3 − from city 6 to city 3 (city 3 becomes visited),
day 4 − from city 3 to city 5 (city 5 becomes visited).
The goal is to find the sequence of travel targets. In the above example we have the following travel targets: (2, 0, 6, 3, 5).

Write a function:

    ------------------------------------------
    class Solution {

        public int[] solution(int K, int[] T){


        }
    }
    ------------------------------------------



That, given a non-empty array T consisting of N integers describing a network of N cities and N − 1 roads, returns the sequence of travel targets.

Array T describes a network of cities as follows:

if T[P] = Q and P ≠ Q, then there is a direct road between cities P and Q.
For example, given the following array T consisting of seven elements (this array describes the network shown above) and K = 2:

    T[0] = 1
    T[1] = 2
    T[2] = 3
    T[3] = 3
    T[4] = 2
    T[5] = 1
    T[6] = 4
the function should return a sequence [2, 0, 6, 3, 5], as explained above.

Assume that:

N is an integer within the range [1..90,000];
each element of array T is an integer within the range [0..(N−1)];
there is exactly one (possibly indirect) connection between any two distinct roads.
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
* */


/*
Greedy Algorithm
----------------

Greedy algorithms determine minimum number of coins to give while making change. These are the steps a
human would take to emulate a greedy algorithm to represent 36 cents using only coins with values {1, 5,
10, 20}. The coin of the highest key, less than the remaining change owed, is the local optimum. (In
general the change-making problem requires dynamic programming to find an optimal solution; however,
most currency systems, including the Euro and US Dollar, are special cases where the greedy strategy
does find an optimal solution.)

A greedy algorithm is an algorithmic paradigm that follows the problem solving heuristic of making the
locally optimal choice at each stage[1] with the intent of finding a global optimum. In many problems, a
greedy strategy does not usually produce an optimal solution, but nonetheless a greedy heuristic may yi
eld locally optimal solutions that approximate a globally optimal solution in a reasonable amount of
time.
* */


import java.util.*;


/**
 * Created by Chaklader on 7/5/18.
 */
public class TripPlanning {



    /*
     * Starting out from city K, you have to plan a series of daily trips. Each day you want
     * to visit a previously unvisited city in such a way that, on a route to that city, you
     * will also pass through a maximal number of other unvisited cities (which will then be
     * considered to have been visited). We say that the destination city is our daily travel
     * target.
     *
     * In the case of a tie, you should choose the city with the minimal label. The trips cease
     * when every city has been visited at least once.
     *
     * If T[P] = Q and P ≠ Q, then there is a direct road between cities P and Q.
     * */


    /*

         2 - 3
        / \
       1   4
      / |  |
     0  5  6


    Array T describes a network of cities as follows:

    If T[P] = Q and P ≠ Q, then there is a direct road between cities P and Q.

    For example, given the following array T consisting of seven elements (this array describes
    the network shown above) and K = 2:

        T[0] = 1
        T[1] = 2
        T[2] = 3
        T[3] = 3
        T[4] = 2
        T[5] = 1
        T[6] = 4

    The function should return a sequence [2, 0, 6, 3, 5], as explained above.
    */


    /*
     * the building block for the graph
     * */
    private static class TreeNode {

        private int key;

        private ArrayList<TreeNode> children;
        private TreeNode deepestChild;

        public TreeNode(int nodeValue) {
            this.key = nodeValue;
            this.children = new ArrayList<TreeNode>();
        }

        public int getKey() {
            return this.key;
        }

        public void addChild(TreeNode child) {
            this.children.add(child);
        }


        public ArrayList<TreeNode> getChildren() {
            return this.children;
        }

        public TreeNode getDeepestChild() {
            return this.deepestChild;
        }

        public void setDeepestChild(TreeNode child) {
            this.deepestChild = child;
        }
    }


    private static class NodeRank {

        private TreeNode node;
        private int rank;

        public NodeRank(TreeNode node, int rank) {
            this.node = node;
            this.rank = rank;
        }

        public TreeNode getNode() {
            return this.node;
        }

        public int getRank() {
            return this.rank;
        }
    }


    public static int[] solution(int K, int[] T) {

        int N = T.length;

        int[] valueToRank = new int[N];
        int[] rankToIndex = new int[N];

        boolean[] isLeaf = new boolean[N];


        TreeNode root = createGraph(T, 2);

        deepestChild(root);

        Queue<NodeRank> queue = new LinkedList<NodeRank>();
        queue.offer(new NodeRank(root, 0));


        List<List<Integer>> rank = new ArrayList<List<Integer>>(N);

        for (int i = 0; i < N; i++) {
            rank.add(new ArrayList<Integer>());
        }


        while (!queue.isEmpty()) {

            NodeRank rankedNode = queue.poll();
            TreeNode currentNode = rankedNode.getNode();

            int currentValue = currentNode.getKey();
            int currentRank = rankedNode.getRank();

            ArrayList<TreeNode> children = currentNode.getChildren();
            TreeNode deepestChildren = currentNode.getDeepestChild();

            int sizeOfChildren = children.size();

            
            /*
            rank = 0 rank = none

            rank = 1 rank = 3
            rank = 1 rank = 5

            rank = 2 rank = 0
            rank = 2 rank = 6

            rank = 3 rank = none
            rank = 4 rank = none
            rank = 5 rank = none
            rank = 6 rank = none
            * */
            /*
             * we are at the leaf
             * */
            if (sizeOfChildren == 0) {

                List<Integer> rankList = rank.get(currentRank);
                rankList.add(currentValue);

                valueToRank[currentValue] = currentRank;
                isLeaf[currentValue] = true;
            }


            /*
            node = 2, deep =  1
            node =  3
            node =  1 Deepest =  0

            node =  4 Deepest =  6

            node =  0
            node =  5
            node =  6

            // node 5 has rank 1 as the deepest node for the node 1 is 0 (0 < 5 though the paths are same)
            valueToRank = [2, 0, 0, 1, 0, 1, 2]

            isLeaf = [true, false, false, true, false, true, true]
            * */

            /*
                     2 - 3
                    / \
                   1   4
                  / |  |
                 0  5  6
            * */

            for (int i = 0; i < sizeOfChildren; i++) {

                TreeNode currentChild = children.get(i);
                int currentChildRank = 1 + ((currentChild == deepestChildren) ? currentRank : 0);

                queue.offer(new NodeRank(currentChild, currentChildRank));
            }
        }


        /*
        rank = 0 rank = none

        rank = 1 rank = 3
        rank = 1 rank = 5

        rank = 2 rank = 0
        rank = 2 rank = 6

        rank = 3 rank = none
        rank = 4 rank = none
        rank = 5 rank = none
        rank = 6 rank = none
        * */
        for (int i = N - 1, currentIndex = 0; i >= 0; i--) {

            List<Integer> rankList = rank.get(i);
            int rankListSize = rankList.size();

            if (rankListSize == 0) {
                continue;
            }

            rankToIndex[i] = currentIndex;
            currentIndex += rankListSize;
        }


        int[] answer = new int[N];
        int highestIndexSet = 0;


        for (int i = 0; i < N; i++) {

            if (!isLeaf[i]) {
                continue;
            }

            int rankI = valueToRank[i];
            int index = rankToIndex[rankI];

            rankToIndex[rankI]++;

            answer[index] = i;
            highestIndexSet = Math.max(highestIndexSet, index);
        }

        int[] result = new int[highestIndexSet + 2];
        result[0] = K;

        for (int i = 0; i <= highestIndexSet; i++) {

            result[i + 1] = answer[i];
        }

        return result;
    }


    /*
     * create graph from the provided array and starting node
     * */
    public static TreeNode createGraph(int[] T, int K) {

        final int N = T.length;

        TreeNode[] nodes = new TreeNode[N];

        for (int i = 0; i < N; i++) {
            nodes[i] = new TreeNode(i);
        }

        /*
       T[children] = parent if the children != K

            T[0] = 1
            T[1] = 2
            T[2] = 3
            T[3] = 3
            T[4] = 2
            T[5] = 1
            T[6] = 4

                 2 - 3
                / \
               1   4
              / |  |
             0  5  6
        * */

        TreeNode root = nodes[K];
        int value = root.getKey();

        if (T[K] != K) {
            nodes[K].addChild(nodes[T[K]]);
        }

        for (int i = 0; i < T.length; ++i) {

            if (K == i) {
                continue;
            }

            if (T[i] != i) {
                nodes[T[i]].addChild(nodes[i]);
            }
        }

        return root;
    }


    /*
     * set the deepest children for all the nodes. If a node has
     * more than one children that has the same depth, set the
     * children with minimum key as the deepest children
     * */
    public static int deepestChild(TreeNode root) {
        return deepestChildHelper(root, 0);
    }

    /*
     * helper function to set the deepest children for all the nodes
     * */
    public static int deepestChildHelper(TreeNode node, int depth) {

        int maxDepth = 0;
        TreeNode maxChild = null;

        ArrayList<TreeNode> children = node.getChildren();
        int sizeOfChildren = children.size();

        if (sizeOfChildren == 0) {
            return depth;
        }

        for (int i = 0; i < sizeOfChildren; i++) {

            TreeNode currentChild = children.get(i);
            int currentChildDepth = deepestChildHelper(currentChild, depth + 1);

            if (maxChild == null || currentChildDepth > maxDepth
                    || (currentChildDepth == maxDepth && currentChild.getKey() < maxChild.getKey())) {

                maxDepth = currentChildDepth;
                maxChild = currentChild;
            }
        }

        node.setDeepestChild(maxChild);
        return maxDepth;
    }


//    public static void main(String[] args) {
//
//        int[] T = new int[7];
//        int N = T.length;
//
//        T[0] = 1;
//        T[1] = 2;
//        T[2] = 3;
//        T[3] = 3;
//        T[4] = 2;
//        T[5] = 1;
//        T[6] = 4;
//
//        int[] res = solution(2, T);
//        System.out.println(Arrays.toString(res));
//    }
}
