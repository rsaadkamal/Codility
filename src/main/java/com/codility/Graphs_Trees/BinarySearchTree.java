package com.codility.Graphs_Trees;

import java.util.*;

/**
 * Created by Chaklader on 7/22/18.
 */
public class BinarySearchTree {

    public static Node root = null;

    /*
     * node for the binary tree
     * */
    public static class Node<T extends Comparable<?>> {

        int key;

        Node<T> leftChild, rightChild;

        Node(int key) {
            this.key = key;
        }

        public String toString() {
            return "\n" + key + " ";
        }
    }


    public static void addNode(int key) {

        Node node = new Node(key);

        if (root == null) {
            root = node;
        } else {

            Node focus = root;
            Node parent;

            while (true) {

                parent = focus;

                if (key < focus.key) {

                    focus = focus.leftChild;

                    if (focus == null) {

                        parent.leftChild = node;
                        return;
                    }

                } else {

                    focus = focus.rightChild;

                    if (focus == null) {

                        parent.rightChild = node;
                        return;
                    }
                }
            }
        }
    }


    public static int depth(Node root) {

        if (root == null) {
            return 0;
        }

        Node focusNode = root;

        int leftHeight = focusNode.leftChild != null ? depth(focusNode.leftChild) : 0;
        int rightHeight = focusNode.rightChild != null ? depth(focusNode.rightChild) : 0;

        return 1 + Math.max(leftHeight, rightHeight);
    }


    public static int depth1(Node node) {

        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(depth1(node.leftChild), depth1(node.rightChild));
        }
    }


    public static Node findNode(int key) {

        Node focus = root;

        while (focus.key != key) {

            if (key < focus.key) {
                focus = focus.leftChild;
            } else {
                focus = focus.rightChild;
            }

            if (focus == null) {
                return null;
            }
        }

        return focus;
    }


    public static boolean remove(int key) {

        Node focus = root;
        Node parent = null;

        /*
         * determine the relationship with the parent
         * */
        boolean isItALeftChild = true;

        /*
         * we get the node needs to be removed,  it's parent and
         * the  relation between removable node and it's parent
         * */
        while (focus.key != key) {

            parent = focus;

            if (key < focus.key) {

                isItALeftChild = true;
                focus = focus.leftChild;
            } else {

                isItALeftChild = false;
                focus = focus.rightChild;
            }

            if (focus == null)
                return false;
        }

        /*
         * no child exist
         * */
        if (focus.leftChild == null && focus.rightChild == null) {

            if (focus == root) {
                root = null;
            } else if (isItALeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        }

        /*
         * has left child exist
         * */
        else if (focus.rightChild == null) {

            if (focus == root) {
                root = focus.leftChild;
            } else if (isItALeftChild) {
                parent.leftChild = focus.leftChild;
            } else {
                parent.rightChild = focus.leftChild;
            }
        }


        /*
         * has right child exit
         * */
        else if (focus.leftChild == null) {

            if (focus == root) {
                root = focus.rightChild;
            } else if (isItALeftChild) {
                parent.leftChild = focus.rightChild;
            } else {
                parent.rightChild = focus.rightChild;
            }
        }


        /*
         * two children exits
         * */
        else {

            Node replacement = getReplacementNode(focus);

            /*
             * focus node doesn't have parent
             * */
            if (focus == root) {
                root = replacement;
            }

            /*
             * focus node has parent
             * */
            else if (isItALeftChild) {
                parent.leftChild = replacement;
            } else {
                parent.rightChild = replacement;
            }

            replacement.leftChild = focus.leftChild;
        }

        return true;
    }


    public static Node getReplacementNode(Node replacedNode) {

        Node replacementParent = replacedNode;
        Node replacement = replacedNode;
        Node focusNode = replacedNode.rightChild;

        while (focusNode != null) {

            replacementParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.leftChild;
        }


        if (replacement != replacedNode.rightChild) {

            replacementParent.leftChild = replacement.rightChild;
            replacement.rightChild = replacedNode.rightChild;
        }

        return replacement;
    }


    public static boolean isWithinTree(int n) {

        if (n == root.key) {
            return true;
        } else {

            Node focusNode = root;
            Node parent;

            while (focusNode != null) {

                parent = focusNode;

                if (focusNode != null) {

                    if (n < focusNode.key) {
                        focusNode = focusNode.leftChild;
                    } else {
                        focusNode = focusNode.rightChild;
                    }
                }

                if (focusNode != null && n == focusNode.key) {
                    return true;
                }
            }
        }

        return false;
    }

    public static Node getNode(int n) {

        if (n == root.key) {
            return root;
        } else {

            Node focusNode = root;
            Node parent;

            while (focusNode != null) {

                parent = focusNode;

                if (focusNode != null) {

                    if (n < focusNode.key) {
                        focusNode = focusNode.leftChild;
                    } else {
                        focusNode = focusNode.rightChild;
                    }
                }

                if (focusNode != null && n == focusNode.key) {
                    return focusNode;
                }
            }
        }

        return null;
    }


    public static Node getParent(int n) {

        if (!isWithinTree(n)) {
            return null;
        }

        if (n == root.key) {
            return null;
        } else {

            Node focusNode = root, parent;

            while (focusNode != null) {

                parent = focusNode;

                if (focusNode != null) {

                    if (n < focusNode.key) {
                        focusNode = focusNode.leftChild;
                    } else {
                        focusNode = focusNode.rightChild;
                    }
                }

                if (focusNode != null && n == focusNode.key) {
                    return parent;
                }
            }
        }

        return null;
    }

    public static boolean isValidBST(Node root, int min, int max) {

        if (root == null) {
            return true;
        }

        return (root.key > min) &&
                (root.key < max) &&
                isValidBST(root.leftChild, min, root.key) &&
                isValidBST(root.rightChild, root.key, max);
    }


    public static boolean isValidBST(Node root) {

        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(root);

        /*
         * using breadth first search
         * */
        while (!queue.isEmpty()) {

            Node cur = queue.poll();

            if ((cur.leftChild != null && cur.key < cur.leftChild.key) || (cur.rightChild != null && cur.key > cur.rightChild.key)) {
                return false;
            }

            queue.offer(cur.leftChild);
            queue.offer(cur.rightChild);
        }

        return queue.isEmpty();
    }

    public static boolean isValidBST1(Node node) {

        if (node == null) {
            return true;
        }

        if (node.leftChild != null &&
                (node.key < node.leftChild.key || !isValidBST1(node.leftChild))) {
            return false;
        } else if (node.rightChild != null && (node.key > node.rightChild.key
                || !isValidBST1(node.rightChild))) {

            return false;
        } else
            return true;

    }

    public static boolean isValidBST2(Node root) {

        LinkedList<Node> nodesToCheck = new LinkedList<>();

        nodesToCheck.offer(root);

        while (!nodesToCheck.isEmpty()) {

            Node current = nodesToCheck.poll();

            if (current.leftChild != null) {

                if (current.key < current.leftChild.key)
                    return false;

                nodesToCheck.offer(current.leftChild);
            }

            if (current.rightChild != null) {

                if (current.key > current.rightChild.key)
                    return false;

                nodesToCheck.offer(current.rightChild);
            }
        }

        return true;
    }


    public static Node createBstFromArray(int[] array) {

        /*
         * assuming that we are using an unique array
         * */
        if (array.length > 0) {

            root = new Node(array[0]);

            Queue<Node> queue = new LinkedList<Node>();
            queue.add(root);

            boolean terminate = false;
            int i = 1;

            while (!terminate) {

                /*
                 * get the current element of the queue similar to peek
                 * */
                Node node = (Node) queue.element();

                if (node.leftChild == null && array[i] < node.key) {

                    node.leftChild = new Node(array[i]);
                    i++;
                    queue.add(node.leftChild);
                } else if (node.rightChild == null && array[i] > node.key) {

                    node.rightChild = new Node(array[i]);
                    i++;
                    queue.add(node.rightChild);
                } else {

                    /*
                     * have child in both left and right sides
                     * */
                    queue.remove();
                }

                if (i == array.length) {
                    terminate = true;
                }
            }

            return root;
        }

        return null;
    }


    public static boolean isBalanced(Node root) {

        if (root == null) {
            return true;
        }

        int heightDiff = depth1(root.leftChild) - depth1(root.rightChild);

        if (Math.abs(heightDiff) > 1) {
            return false;
        } else {
            return isBalanced(root.leftChild) && isBalanced(root.rightChild);
        }
    }

    /*
     * create minimum binary search tree  from  a  sorted   array
     * */

    /*
    *
                      10
                      / \
                     /   \
                    /     \
                   /       \
                  /         \
                 /           \
                /             \
               /               \
               5               15
              / \             / \
             /   \           /   \
            /     \         /     \
           /       \       /       \
           2       7       12       18
          / \     / \     / \     / \
         /   \   /   \   /   \   /   \
         1   3   6   8   11   13   16   19
              \       \       \   \   \
              4       9       14   17   20
    * */


    public static Node createBalancedTree(int array[]) {

        Arrays.sort(array);
        root = createBalancedTree(array, 0, array.length - 1);

        return root;
    }

    private static Node createBalancedTree(int arr[], int start, int end) {

        if (end < start) {
            return null;
        }

        int mid = (start + end) / 2;

        Node node = new Node(arr[mid]);

        node.leftChild = createBalancedTree(arr, start, mid - 1);
        node.rightChild = createBalancedTree(arr, mid + 1, end);

        return node;
    }


    /*
     * create linked list of the same level of the tree with BFS
     * */
    public static ArrayList<LinkedList<Node>> createLevelLinkedList(Node root) {

        ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();

        LinkedList<Node> current = new LinkedList<Node>();

        if (root != null) {
            current.add(root);
        }

        while (current.size() > 0) {

            result.add(current); // Add previous level
            LinkedList<Node> parents = current; // Go to next level

            current = new LinkedList<Node>();

            for (Node parent : parents) {

                if (parent.leftChild != null) {
                    current.add(parent.leftChild);
                }

                if (parent.rightChild != null) {
                    current.add(parent.rightChild);
                }
            }
        }

        return result;
    }

    public static void printResult(ArrayList<LinkedList<Node>> result) {

        int depth = 0;

        for (LinkedList<Node> entry : result) {

            Iterator<Node> i = entry.listIterator();
            System.out.print("Link list at depth " + depth + ":");

            while (i.hasNext()) {

                System.out.print(" " + ((Node) i.next()).key);
            }

            System.out.println();
            depth++;
        }
    }


    /*
     * create linked list of the same level of the tree with DFS
     * */
    public static ArrayList<LinkedList<Node>> createLevelLinkedList1(Node root) {

        ArrayList<LinkedList<Node>> lists = new ArrayList<LinkedList<Node>>();

        createLevelLinkedList1(root, lists, 0);
        return lists;
    }

    public static void createLevelLinkedList1(Node root, ArrayList<LinkedList<Node>> lists, int level) {

        /*
        ALGORITHM
        ---------

        i.    if the list size is the same as the level, create a
              new instance of list

        ii.   otherwise, get the list using the level

        iii.  add the node in the list

        iv.   continue the recursive process till where is no child
        */


        if (root == null) {
            return;
        }

        LinkedList<Node> list = null;

        if (lists.size() == level) {
            list = new LinkedList<Node>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }

        list.add(root);

        createLevelLinkedList1(root.leftChild, lists, level + 1);
        createLevelLinkedList1(root.rightChild, lists, level + 1);
    }

    /*
     * design an algorithm to find the ‘next’ node (e.g., in-order
     * successor) of a given node in a binary search tree
     * */
    public static Node inOrderSuccessor(Node node) {
        
        /*
        ALGORITHM
        ---------

        i.  if the parent node  does not exist or the right
            child exist, return the left most child of right
            child

        ii. if have parent and don't have the right child,
        */

        if (node == null) {
            return null;
        }

        if (getParent(node.key) == null || node.rightChild != null) {
            return leftMostChild(node.rightChild);
        }

        /*
         * have parent but no right child
         * */
        else {

            Node child = node;
            Node parent = getParent(child.key);

            while (parent != null && parent.leftChild != child) {
                child = parent;
                parent = getParent(parent.key);
            }

            return parent;
        }
    }


    /*
     * get the smallest node of the right sub-tree
     */
    public static Node leftMostChild(Node n) {

        if (n == null) {
            return null;
        }

        while (n.leftChild != null) {
            n = n.leftChild;
        }

        return n;
    }


    /*
     * find out the common ancestor of the two nodes
     * */
    /*
     * solution - a
     * */
    public static Node commonAncestor(Node root, Node p, Node q) {


        if (!covers(root, p) || !covers(root, q)) {
            return null;
        }

        return commonAncestorHelper(root, p, q);
    }

    public static boolean covers(Node root, Node node) {

        if (root == null) {
            return false;
        } else if (root == node) {
            return true;
        }

        return covers(root.leftChild, node) || covers(root.rightChild, node);
    }

    public static Node commonAncestorHelper(Node node, Node p, Node q) {

        if (node == null) {
            return null;
        }

        boolean p_OnLeft = covers(node.leftChild, p);
        boolean q_OnLeft = covers(node.leftChild, q);

        if (p_OnLeft != q_OnLeft) {
            return node;
        }

        /*
         * both of the nodes are in the same sides of root. Check
         * if they are in the left or right side of the root
         * */
        Node childSide = p_OnLeft ? node.leftChild : node.rightChild;

        return commonAncestorHelper(childSide, p, q);
    }


    /*
     * solution - b
     * */
    public static Node commonAncestor1(Node root, Node p, Node q) {

        if (q == p && (root.leftChild == q || root.rightChild == q)) {
            return root;
        }

        int nodesFromLeft = covers1(root.leftChild, p, q);

        if (nodesFromLeft == 2) {

            if (root.leftChild == p || root.leftChild == q) {
                return root.leftChild;
            } else {
                return commonAncestor1(root.leftChild, p, q);
            }
        }

        /*
         * nodes are in opposite sides of the tree. Check if
         * one of them is root
         * */
        else if (nodesFromLeft == 1) {

            if (p == root || q == root) {
                return root;
            }
        }


        int nodesFromRight = covers1(root.rightChild, p, q);

        if (nodesFromRight == 2) {

            if (root.rightChild == p || root.rightChild == q)
                return root.rightChild;

            else
                return commonAncestor1(root.rightChild, p, q);
        } else if (nodesFromRight == 1) {

            if (root == p)
                return p;

            else if (root == q)
                return q;
        }

        if (nodesFromLeft == 1 && nodesFromRight == 1) {
            return root;
        } else {
            return null;
        }
    }


    public static int covers1(Node node, Node p, Node q) {

        int count = 0;

        if (node == null) {
            return count;
        }

        if (node == p || node == q) {
            count += 1;
        }

        count += covers1(node.leftChild, p, q);

        if (count == 2) {
            return count;
        }

        return count + covers1(node.rightChild, p, q);
    }


    /*
     * two very large binary trees: T1, with millions of nodes, and T2,
     * with hundreds of nodes. Create an algorithm to decide if T2 is a
     * subtree of T1
     * */
    public static boolean containsTree(Node big, Node small) {

        if (small == null) {
            return true;
        } else {
            return subTree(big, small);
        }
    }


    public static boolean subTree(Node big, Node small) {

        if (big == null) {
            return false;
        }

        if (big.key == small.key) {

            if (matchTree(big, small)) {
                return true;
            }
        }

        return subTree(big.leftChild, small) || subTree(big.rightChild, small);
    }

    public static boolean matchTree(Node big, Node small) {

        if (big == null && small == null) {
            return true;
        }

        if (big == null || small == null) {
            return false;
        }

        if (big.key != small.key) {
            return false;
        }

        return (matchTree(big.leftChild, small.leftChild) &&
                matchTree(big.rightChild, small.rightChild));
    }


    /*
     * design an algorithm to find all the paths of
     * a BST which sums are equal to certain value
     * */
    public static void findSum(Node node, int sum) {

        int depth = depth(node);

        /*
         * primitives initiated with zeros
         * */
        int[] path = new int[depth];

        findSum(node, sum, path, 0);
    }

    public static void findSum(Node node, int sum, int[] path, int level) {

        if (node == null) {
            return;
        }

        path[level] = node.key;
        int t = 0;

        for (int i = level; i >= 0; i--) {

            t += path[i];

            if (t == sum) {
                print(path, i, level);
            }
        }

        findSum(node.leftChild, sum, path, level + 1);
        findSum(node.rightChild, sum, path, level + 1);

        /*
         * remove current node from path
         * */
        path[level] = Integer.MIN_VALUE;
    }

    private static void print(int[] path, int start, int end) {

        for (int i = start; i <= end; i++) {
            System.out.print(path[i] + " ");
        }
    }


    public static void main(String[] args) {

        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};


        Node root = createBalancedTree(A);
        BTreePrinter.printNode(root);


        findSum(root, 22);
    }
}




