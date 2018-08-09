package com.codility;


import java.util.Stack;

public class App {


    class Tree {

        public int x;

        public Tree l;
        public Tree r;
    }


    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        System.out.println(stack.peek());
    }
}

