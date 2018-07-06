package com.codility.Extra;

import java.util.Stack;

/**
 * Created by Chaklader on 7/6/18.
 */


    /*question 3-4: considering three rods and an entire stack, move
the entire stack to another rod, obeying that, only one disk can
be moved at a time, each move consists of taking the upper disk
from one of the stacks and placing it on top of another stack and
no disk may be placed on top of a smaller disk.*/


// tower of Hanoi
class TowerOfHanoi {


    private Stack<Integer> disks;
    private int index;

    public TowerOfHanoi(int i) {
        disks = new Stack<Integer>();
        index = i;
    }

    public int index() {
        return index;
    }

    public void add(int d) {

        if (!disks.isEmpty() && disks.peek() <= d) {
            System.out.println("Error placing disk " + d);
        } else {
            disks.push(d);
        }
    }

    public void moveTopTo(TowerOfHanoi t) {
        int top = disks.pop();
        t.add(top);
    }

    public void print() {
        System.out.println("Contents of Tower " + index() + ": " + disks.toString());
    }

    public void moveDisks(int n, TowerOfHanoi destination, TowerOfHanoi buffer) {

        if (n > 0) {

            String tag = "move" + n + "disksfrom" + this.index + "to" + destination.index + "withbuffer" + buffer.index;
            System.out.println("<" + tag + ">");
            moveDisks(n - 1, buffer, destination);
            System.out.println("<movetopfrom" + this.index + "to" + destination.index + ">");
            System.out.println("<before>");
            System.out.println("<sourceprint>");
            this.print();

            System.out.println("</sourceprint>");
            System.out.println("<destinationprint>");
            destination.print();
            System.out.println("</destinationprint>");
            System.out.println("</before>");
            moveTopTo(destination);
            System.out.println("<after>");
            System.out.println("<sourceprint>");
            this.print();

            System.out.println("</sourceprint>");
            System.out.println("<destinationprint>");
            destination.print();
            System.out.println("</destinationprint>");
            System.out.println("</after>");
            System.out.println("</movetopfrom" + this.index + "to" + destination.index + ">");
            buffer.moveDisks(n - 1, destination, this);
            System.out.println("</" + tag + ">");
        }
    }


    public static void main(String[] args) {

        int n = 5;

        TowerOfHanoi[] towers = new TowerOfHanoi[3];

        for (int i = 0; i < 3; i++) {
            towers[i] = new TowerOfHanoi(i);
        }

        for (int i = n - 1; i >= 0; i--) {
            towers[0].add(i);
        }

        // Copy and paste output into a .XML file and open it with internet explorer.
        //towers[0].print();
        towers[0].moveDisks(n, towers[2], towers[1]);
        //towers[2].print();
    }
}
/*END of solution 3-4: considering three rods and an entire
stack, move the entire stack to another rod, obeying that,
only one disk can be moved at a time, each move consists of
taking the upper disk from one of the stacks and placing it
on top of another stack and no disk may be placed on top of
a smaller disk.*/



