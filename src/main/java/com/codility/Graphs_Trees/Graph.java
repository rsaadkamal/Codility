package com.codility.Graphs_Trees;

import java.util.*;

/**
 * Created by Chaklader on 7/22/18.
 */
public class Graph {


    private static class Node {

        public int index;

        private Node adjacent[];

        public Node(int count) {
            index = 0;
            adjacent = new Node[count];
        }

        public void addAdjacent(Node node) {
            this.adjacent[index++] = node;
        }

        public Node[] getAdjacent() {
            return adjacent;
        }
    }


    ///////////////////////////////////////////
    private int V;

    private LinkedList<Integer> adj[];

    Graph(int v) {

        this.V = v;
        this.adj = new LinkedList[v];

        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    /*
     * function to add an edge into the graph
     * */
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }


    /*
     * prints BFS traversal from a given source S
     * */
    public void BFS(int S) {

        /*
         * Mark all the vertices as not visited(By default set as false)
         * */
        boolean visited[] = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[S] = true;
        queue.add(S);


        while (queue.size() != 0) {

            // Dequeue a vertex from queue and print it
            S = queue.poll();
            System.out.print(S + " ");


            // Get all adjacent vertices of the dequeued vertex S
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj[S].listIterator();

            while (i.hasNext()) {

                int n = i.next();

                if (!visited[n]) {

                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }


    void performDFS(int v) {

        boolean visited[] = new boolean[V];
        DFSUtil(v, visited);
    }

    void DFSUtil(int v, boolean visited[]) {

        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> i = adj[v].listIterator();

        while (i.hasNext()) {

            int n = i.next();

            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }


    ///////////////////////////////////////////


    /*solution-a*/
    // use the adjacency matrix for the DFS
    public static void depthFirstSearch(int[][] mat, int start) {

        // we will count node# from 1 upwards
        if (start < 1) {
            return;
        }

        Stack<Integer> stack = new Stack<Integer>();

        // columns
        int numOfCols = mat[0].length;
        int row, col;

        int[] visited = new int[numOfCols];

        // may be, row =  strat - 1
        // then, use the value of row

        visited[start - 1] = 1;
        stack.push(start - 1);

        System.out.println();
        System.out.print(start + "\t");

        /*
         * check if the stack is empty
         */
        while (!stack.isEmpty()) {

            row = stack.peek();
            col = row;

            while (col < numOfCols) {

                if (mat[row][col] == 1 && visited[col] == 0) {

                    System.out.print(row + 1 + "\t");

                    stack.push(col);
                    visited[col] = 1;

                    row = col;
                    col = 0;

                    continue;
                }

                col++;
            }

            stack.pop();
        }


        boolean isTraverse = isFullTraverse(visited);
    }


    public static boolean isFullTraverse(int[] visited) {

        for (int i = 0; i < visited.length; i++) {

            if (visited[i] == 0) {
                return false;
            }
        }

        return true;
    }
    /*END of solution -a*/







    /*solution-b*/
    // web link: <http://www.mathcs.emory.edu/~cheung/Courses/323/Syllabus/Graph/dfs. l>

    // primitives are initiated with values,
    // for the booelan it will be false
    // boolean [] bol =  new boolean[10];
    public static void depthFirstSearch1(int i, int[][] mat) {

        // we will need to provide i-1 as it will be used inside the
        // adjcency matrix
        // i >= 0
        dfsHelper(i, mat, new boolean[mat[0].length]);
    }

    public static void dfsHelper(int row, int[][] mat, boolean[] visited) {

        if (!visited[row]) {

            visited[row] = true; // Mark node as "visited"
            System.out.print((row + 1) + " ");

            for (int col = 0; col < mat[row].length; col++) {

                if (mat[row][col] == 1 && !visited[col]) {
                    dfsHelper(col, mat, visited); // Visit node
                }
            }
        }
    }
    /*END fo solution -b*/

	/* END OF SOLUTION: depth first search
	with uni-directional */


    /*solution-a*/
    public static void breadthFirstSearch(int[][] mat, int start) {


        int numOfCols = mat[0].length;
        int row, col;

        // array to keep track of visiting
        int[] visited = new int[numOfCols];

        Queue<Integer> queue = new LinkedList<Integer>();

        visited[start - 1] = 1;
        queue.add(start - 1);

        System.out.println();

        while (!queue.isEmpty()) {

            row = queue.remove();
            col = row;

            System.out.print((col + 1) + " ");

            while (col < numOfCols) {

                if (mat[row][col] == 1 && visited[col] == 0) {

                    queue.add(col);
                    visited[col] = 1;
                }

                col++;
            }
        }

        System.out.println();
    }


    /* question: write an algorithm to
    perform breadth first search recursively*/
    public void recursiveBFS(Node root) {

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);

        BfsHelper(queue);
    }


    // breadth frist search in a graph with recursive algorithm
    public void BfsHelper(LinkedList<Node> queue) {

        while (!queue.isEmpty()) {

            Node node = queue.pop();

            System.out.println("Node: " + node);

            for (Node n : node.getAdjacent()) {
                queue.push(n);
            }

            BfsHelper(queue);
        }
    }


    public static void main(String[] args) {

        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex 2)");

        g.BFS(2);
        g.performDFS(2);
    }
}
