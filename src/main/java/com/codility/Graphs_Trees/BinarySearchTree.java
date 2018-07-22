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
    public Node inorderSucc(Node n) {


        /*
        ALGORITHM
        ---------

        i.  if the parent node  does not exist or the right
            child exist, return the left most child of right
            child

        ii. if have parent and don't have the right child,
        */

        if (n == null) {
            return null;
        }

        if (getParent(n.key) == null || n.rightChild != null) {
            return leftMostChild(n.rightChild);
        }

        /*
         * have parent and dont have the right child
         * */
        else {

            Node child = n;
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
    public Node leftMostChild(Node n) {

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
    public static Node commonAncestor2(Node root, Node p, Node q) {

        /*
         * one or both of the nodes are not inside the tree
         * */
        if (!covers2(root, p) || !covers2(root, q)) {
            return null;
        }

        /*
         * both nodes are inside the tree, now find their common ancestor
         * put a condition here: if both nodes are the same, call a new
         * method to find their parent and return else, call this method
         * */
        return commonAncestorHelper(root, p, q);
    }

    /*
     * find a node from a bst by key using recursive method
     * */
    public static boolean covers2(Node root, Node node) {

        if (root == null) {
            return false;
        } else if (root == node) {
            return true;
        }

        /*
         * if we have a true here, the return will be true
         * */
        return covers2(root.leftChild, node) || covers2(root.rightChild, node);
    }

    public static Node commonAncestorHelper(Node root, Node p, Node q) {

        if (root == null) return null;

        boolean isponleft = covers2(root.leftChild, p);
        boolean isqonleft = covers2(root.leftChild, q);

        if (isponleft != isqonleft) return root;

        /*
         * nodes are the same sides
         * */
        Node childside = isponleft ? root.leftChild : root.rightChild;
        return commonAncestorHelper(childside, p, q);
    }


    static int TWO_NODE_FOUND = 2;
    static int ONE_NODE_FOUND = 1;
    static int NO_NODE_FOUND = 0;

    public static Node commonAncestor(Node root, Node p, Node q) {

        if (q == p && (root.leftChild == q || root.rightChild == q))
            return root;

        /*
         * checks every nodes of the left-subtree of the root
         * */
        int nodesFromLeft = covers(root.leftChild, p, q);

        /*
         * both of the nodes are in the left sub-tree of the
         * original root
         * */
        if (nodesFromLeft == TWO_NODE_FOUND) {

            if (root.leftChild == p || root.leftChild == q) {
                return root.leftChild;
            } else {
                return commonAncestor(root.leftChild, p, q);
            }
        }

        /*
         * one of the node exists in the left sub-tree if the other node present
         * is the root || exists in the right sub-tree, then, the root is common
         * ancestor
         * */
        else if (nodesFromLeft == ONE_NODE_FOUND) {

            if (root == p) return p;
            else if (root == q) return q;
        }

        /*
         * check every nodes of the right side of the root node
         * */
        int nodesFromRight = covers(root.rightChild, p, q);

        if (nodesFromRight == TWO_NODE_FOUND) {

            if (root.rightChild == p || root.rightChild == q)
                return root.rightChild;

            else
                return commonAncestor(root.rightChild, p, q);
        } else if (nodesFromRight == ONE_NODE_FOUND) {

            if (root == p)
                return p;

            else if (root == q)
                return q;
        }

        if (nodesFromLeft == ONE_NODE_FOUND && nodesFromRight == ONE_NODE_FOUND) {
            return root;
        } else {
            return null;
        }
    }


    public static int covers(Node root, Node p, Node q) {

        int ret = NO_NODE_FOUND;

        if (root == null)
            return ret;

        if (root == p || root == q)
            ret += 1;

        ret += covers(root.leftChild, p, q);

        if (ret == TWO_NODE_FOUND)
            return ret;

        return ret + covers(root.rightChild, p, q);
    }


    /*
     * two very large binary trees: T1, with millions of nodes, and T2,
     * with hundreds of nodes. Create an algorithm to decide if T2 is a
     * subtree of T1
     * */
    public static boolean containsTree(Node t1, Node t2) {

        if (t2 == null) {
            return true;
        } else {
            return subTree(t1, t2);
        }
    }

    /*
     * r1 is the big tree, r2 is the small tree
     * */
    public static boolean subTree(Node Node1, Node Node2) {

        /*
         * big tree empty & subtree still not found.
         * */
        if (Node1 == null) {
            return false;
        }

        /*
         * root is the same
         * */
        if (Node1.key == Node2.key) {

            if (matchTree(Node1, Node2)) {
                return true;
            }
        }

        return subTree(Node1.leftChild, Node2) || subTree(Node1.rightChild, Node2);
    }


    public static boolean matchTree(Node r1, Node r2) {

        /*
         * for the sub-tree, leaf-to-leaf match needed nothing left
         * in the subtree
         * */
        if (r1 == null && r2 == null) {
            return true;
        }

        /*
         * big tree empty & subtree still not found
         * */
        if (r1 == null || r2 == null) {
            return false;
        }

        /*
         * data doesn’t match
         * */
        if (r1.key != r2.key) {
            return false;
        }

        return (matchTree(r1.leftChild, r2.leftChild) &&
                matchTree(r1.rightChild, r2.rightChild));
    }


    /*
     * design an algorithm to find all the paths of a BST which sums
     * are equal to certain value
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

        int[] A = {555, 876, 100, 90, 5, 3, 1, 4, 8, 45, 77, 2, 6, 56};
        Node root = createBalancedTree(A);


        BTreePrinter.printNode(root);
    }
}




