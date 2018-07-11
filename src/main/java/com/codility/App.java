package com.codility;


import java.util.*;


public class App {


    static class Graph {

        private int numberOfVertices;
        private LinkedList<Integer>[] adjacencyList;

        public Graph(int v) {

            this.numberOfVertices = v;
            this.adjacencyList = new LinkedList[v];

            for (int i = 0; i < numberOfVertices; i++) {
                adjacencyList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int v, int w) {
            adjacencyList[v].add(w);
        }

        /*
         * perform the breadth first search from the Node "S"
         * */
        public void performBFS(int S) {

            boolean[] visited = new boolean[numberOfVertices];
            Queue<Integer> queue = new LinkedList<>();

            visited[S] = true;
            queue.add(S);

            while (!queue.isEmpty()) {

                int M = queue.poll();
                System.out.println(" " + M);

                Iterator<Integer> iterator = adjacencyList[M].listIterator();

                while (iterator.hasNext()) {

                    int N = iterator.next();

                    if (!visited[N]) {

                        visited[N] = true;
                        queue.add(N);
                    }
                }
            }
        }


        /*
         * perform the depth first search
         * */
        public void performDFS(int S) {

            boolean[] visited = new boolean[S];
            helperDFS(S, visited);
        }

        public void helperDFS(int S, boolean[] visited) {

            visited[S] = true;
            System.out.print(S + " ");

            Iterator<Integer> i = adjacencyList[S].listIterator();

            while (i.hasNext()) {

                int N = i.next();

                if (!visited[N]) {
                    helperDFS(N, visited);
                }
            }
        }


        class Node {

            Node left;
            Node right;

            boolean isLeft() {
                return true;
            }
        }

        public static void main(String[] args) {

            Graph g = new Graph(6);

            g.addEdge(0, 1);
            g.addEdge(0, 2);
            g.addEdge(0, 3);

            g.addEdge(3, 4);
            g.addEdge(4, 5);


            g.performBFS(3);
        }
    }
}
