package com.codility.Graphs_Trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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


    public static void main(String[] args) {

        int[] A = {555, 876, 100, 90, 5, 3, 1, 4, 8, 45, 77, 2, 6, 56};
        Node root = createBalancedTree(A);



        BTreePrinter.printNode(root);
    }
}




