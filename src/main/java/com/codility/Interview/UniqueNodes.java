package com.codility.Interview;


import java.util.*;

/*
Q:1

In this problem we consider binary trees. The figure below shows an example binary tree consisting of
seven nodes. A binary tree is either an empty tree or a node (called the root) containing a single integer
value and linked to two further binary trees. We are interested in paths (sequences of linked adjacent nodes)
that start at the root and follow the tree edges (marked as arrows in the figure above). For example, the
sequence of nodes A, B, D is a valid path, but the sequence A, B, G is not. Problem We would like to find the
maximum number of distinct values that appear on a path starting at the root of the tree. For example, on the
path consisting of nodes A, B, D, G there are two distinct values (4 and 5). On the path A, C, E there are
three distinct values (1, 4 and 6). There is no path that contains four or more distinct values.

Write a function: class Solution { public int solution(Tree T); } that, given a binary tree T consisting of N
nodes, returns the maximum number of distinct values that appear on a path starting at the root of tree T. For
example, given the tree shown above, the function should return 3. Technical details A binary tree is given using
a pointer data structure. Assume that the following declarations are given:

class Tree { public int x; public Tree l; public Tree r; } An empty tree is represented by an empty pointer
(denoted by null). A non-empty tree is represented by a pointer to an object representing its root. The attribute
x holds the integer contained in the root, whereas attributes l and r hold the left and right subtrees of the
binary tree, respectively. Assumptions Assume that: N is an integer within the range [1..50,000]; the height of
tree T (number of edges on the longest path from root to leaf) is within the range [0..3,500]; each value in
tree T is an integer within the range [1..N]. Complexity: expected worst-case time complexity is O(N); expected
worst-case space complexity is O(N).
*/


/**
 * Created by Chaklader on 8/8/18.
 */
public class UniqueNodes {


    private static class Tree {

        public int key;

        public Tree left;
        public Tree right;

        boolean visited;

        Tree(int v) {
            this.key = v;
            this.visited = false;
        }
    }

    private static ArrayList<ArrayList<Tree>> getAllPaths(Tree root) {

        Stack<Tree> st = new Stack<>();
        ArrayList<ArrayList<Tree>> result = new ArrayList<>();

        st.push(root);
        root.visited = true;

        while (!st.isEmpty()) {

            Tree top = st.peek();

            if (top.left != null && !top.left.visited) {
                st.push(top.left);
                top.left.visited = true;
            } else {
                if (top.right == null && top.left == null) {


                    ArrayList<Tree> tmpList = new ArrayList<>();
                    for (Tree t : st) {
                        tmpList.add(t);
                    }
                    result.add(tmpList);
                    st.pop();
                } else if (top.right != null && !top.right.visited) {
                    st.push(top.right);
                    top.right.visited = true;
                } else {
                    st.pop();
                }
            }
        }

        return result;
    }


    public static int solution(Tree root) {

        ArrayList<ArrayList<Tree>> paths = getAllPaths(root);

        int result = 0;

        List<Integer> list = null;

        for (ArrayList<Tree> path : paths) {

            list = new ArrayList<>();

            for (Tree p : path) {

                if (list.contains(p.key)) {
                    continue;
                }

                list.add(p.key);
            }

            result = Math.max(result, list.size());
        }


        return result;
    }

    public static void main(String[] args) {

        Tree root = new Tree(4);

        root.left = new Tree(5);
        root.left.left = new Tree(4);
        root.left.left.left = new Tree(5);

        root.right = new Tree(6);
        root.right.left = new Tree(1);

        root.right.right = new Tree(6);

        System.out.println(solution(root));

    }
}
