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



                    4
                  /  \
                 5    6
                /    / \
               4    1   6
              /
             5


Write a function:
-----------------


class Solution {

    public int solution(Tree T);
}


that, given a binary tree T consisting of N nodes, returns the maximum number of distinct values that appear on

a path starting at the root of tree T. For example, given the tree shown above, the function should return 3.

Technical details A binary tree is given using a pointer data structure.




Assume that the following declarations are given:

    class Tree {

        public int key;

        public Tree left;
        public Tree right;
    }


An empty tree is represented by an empty pointer (denoted by null). A non-empty tree is represented by a pointer

to an object representing its root. The attribute key holds the integer contained in the root, whereas attributes

left and right hold the left and right subtrees of the binary tree, respectively. Assumptions Assume that: N is

an integer within the range [1..50,000]; the height of tree T (number of edges on the longest path from root to

leaf) is within the range [0..3,500]; each value in tree T is an integer within the range [1..N]. Complexity:



Time and Space complexity
-------------------------

i.  expected worst-case time complexity is O(N)

ii. expected worst-case space complexity is O(N).
*/


/**
 * Created by Chaklader on 8/8/18.
 */
public class UniqueTreeNodes {


    private static class Node {

        public int key;

        public Node left;
        public Node right;

        public Node(int key) {
            this.key = key;
        }
    }


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


    /*
     * solution - a
     * */
    public static int solution(Node root) {

        List<List<Integer>> list = new ArrayList<>();

        findPaths(root, list, new Stack<Node>());

        int max = 0;

        HashSet<Integer> set = null;

        for (List<Integer> l : list) {

            set = new HashSet<>();

            System.out.println(l);
            set.addAll(l);

            max = max < set.size() ? set.size() : max;
        }

        return max;
    }


    /*
     * find all the paths of a binary search tree
     * */
    private static void findPaths(Node node, List<List<Integer>> lists, Stack<Node> stack) {

        if (node == null) {
            return;
        }

        List<Integer> list = null;

        stack.push(node);

        while (node.left != null) {
            node = node.left;
            stack.push(node);
        }

        if (stack.peek().right != null) {
            findPaths(stack.peek().right, lists, stack);
        }

        if (!stack.isEmpty()) {
            return;
        }

        list = new ArrayList<>();

        for (Node n : stack) {
            list.add(n.key);
        }

        lists.add(list);

        Node right = null;

        /*
         * i.    pop till the stack has elements
         * ii.   delete the old left paths that are already included
         * iii.  delete the old right path that are already included
         *
         * */
        while (!stack.isEmpty() && (stack.peek().right == null || stack.peek().right.equals(right))) {
            right = stack.pop();
        }

        if (!stack.isEmpty()) {

            right = stack.peek().right;
            findPaths(right, lists, stack);
        }
    }


    /*
     * solution - b
     * */
    public static int solution2(Tree root) {

        List<ArrayList<Tree>> paths = findPaths1(root);

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


    /*
     * find all the paths of a binary tree
     * */
    private static List<ArrayList<Tree>> findPaths1(Tree root) {

        Stack<Tree> stack = new Stack<>();
        List<ArrayList<Tree>> result = new ArrayList<>();

        stack.push(root);
        root.visited = true;

        while (!stack.isEmpty()) {

            Tree top = stack.peek();

            if (top.left != null && !top.left.visited) {
                stack.push(top.left);
                top.left.visited = true;
            } else {
                if (top.right == null && top.left == null) {


                    ArrayList<Tree> tmpList = new ArrayList<>();
                    for (Tree t : stack) {
                        tmpList.add(t);
                    }
                    result.add(tmpList);
                    stack.pop();
                } else if (top.right != null && !top.right.visited) {
                    stack.push(top.right);
                    top.right.visited = true;
                } else {
                    stack.pop();
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {


        /*
                    4
                  /  \
                 5    6
                /    / \
               4    1   6
              /
             5

                    4
                  /  \
                 5    6
                /    / \
               4    1   6
              / \
             5  12
                 \
                 13

        * */

        Node root = new Node(4);

        root.left = new Node(5);
        root.left.right = new Node(15);
        root.left.right.left = new Node(115);
        root.left.right.right = new Node(215);


        root.left.left = new Node(4);


        root.left.left.right = new Node(12);
        root.left.left.right.right = new Node(13);


        root.left.left.left = new Node(5);

        root.right = new Node(6);
        root.right.left = new Node(1);
        root.right.right = new Node(6);

        System.out.println(solution(root));
    }
}
