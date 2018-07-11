package com.codility.Geeks_For_Geeks.Graph;

import java.io.*;
import java.util.*;

/*
 * breadth first search in a directed graph using adjacency list
 * */
class Graph {

    /*
     * no. of vertices
     * */
    private int V;

    /*
     * Adjacency Lists
     * */
    private LinkedList<Integer> adj[];

    Graph(int v) {

        V = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    /*
     * function to add an edge into the graph
     * */
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    /*
     * prints BFS traversal from a given source S
     * */
    void BFS(int S) {

        /*
         * mark all the vertices as not visited(By default set as false)
         * */
        boolean visited[] = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<Integer>();

        /*
         * Mark the current node as visited and enqueue it
         * */
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


    /*
     * using the adjacency matrix
     * */
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

		/* if visited[] is full of 1 and no zeros included,
        the graph is connected */

        // Integer n = 1;
        // if(Arrays.stream(visited).anyMatch(n::equals))
        // System.out.println("the graph is not traversed completely");

        /*boolean bol = true;
        for ( int i = 0; i < visited.numOfColsgth; i++){

        	if ( visited[i] ==  0){

        		bol = false;
        		break;
        	}
        }

        if (!bol){
        	System.out.println("the graph is not connected");
        }*/
    }


    public static void main(String args[]) {
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
    }
}