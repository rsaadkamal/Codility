package com.codility.Additional;

/*
 * design an algorithm to compute the largest possible number
 * of people in the tower with descending weight and height
 * */

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Chaklader on 7/6/18.
 */
public class LargestNumberOfPeople {


    static class Property implements Comparable {

        private int Height;
        private int Weight;

        public Property(int h, int w) {
            this.Height = h;
            this.Weight = w;
        }

        public int compareTo(Object o) {

            Property other = (Property) o;

            if (this.Height != other.Height) {
                return ((Integer) this.Height).compareTo(other.Height);
            } else {
                return ((Integer) this.Weight).compareTo(other.Weight);
            }
        }

        public boolean isBefore(Property other) {

            if (this.Height < other.Height && this.Weight < other.Weight) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public String toString() {
            return "Property{" +
                    "Height=" + Height +
                    ", Weight=" + Weight +
                    '}';
        }
    }


    public static ArrayList<Property> initialize() {


        ArrayList<Property> people = new ArrayList<Property>();

        Property item = new Property(65, 60);
        people.add(item);

        item = new Property(70, 150);
        people.add(item);

        item = new Property(56, 90);
        people.add(item);

        item = new Property(75, 190);
        people.add(item);

        item = new Property(60, 95);
        people.add(item);

        item = new Property(68, 110);
        people.add(item);

        item = new Property(35, 65);
        people.add(item);

        item = new Property(40, 60);
        people.add(item);

        item = new Property(45, 63);
        people.add(item);

        return people;
    }


    public static ArrayList<Property> getIncreasingSequence(ArrayList<Property> items) {

        Collections.sort(items);
        return longestIncreasingSubsequence(items);
    }

    private static ArrayList<Property> longestIncreasingSubsequence(ArrayList<Property> people) {

        ArrayList<Property>[] updatedPeople = new ArrayList[people.size()];
        longestIncreasingSubsequence(people, updatedPeople, 0);

        ArrayList<Property> bestSequence = null;

        for (int i = 0; i < people.size(); i++) {
            bestSequence = largerSequence(bestSequence, updatedPeople[i]);
        }

        return bestSequence;
    }


    private static void longestIncreasingSubsequence(ArrayList<Property> people, ArrayList<Property>[] updatedPeople, int currentindex) {


        if (currentindex < 0 || currentindex >= people.size()) {
            return;
        }

        Property currentelement = people.get(currentindex);

        // Find longest sequence that we can append currentelement to
        ArrayList<Property> bestsequence = null;

        for (int i = 0; i < currentindex; i++) {

            // If currentelement is bigger than list tail
            // Set bestsequence to our new max
            if (people.get(i).isBefore(currentelement)) {
                bestsequence = largerSequence(bestsequence, updatedPeople[i]);
            }
        }

        // Append currentelement
        ArrayList<Property> newsolution = new ArrayList<Property>();

        if (bestsequence != null) {
            newsolution.addAll(bestsequence);
        }

        newsolution.add(currentelement);

        // Add to list and recurse
        updatedPeople[currentindex] = newsolution;
        longestIncreasingSubsequence(people, updatedPeople, currentindex + 1);
    }


    // Returns longer sequence
    private static ArrayList<Property> largerSequence(ArrayList<Property> seq1, ArrayList<Property> seq2) {

        if (seq1 == null) {
            return seq2;
        } else if (seq2 == null) {
            return seq1;
        }

        return seq1.size() > seq2.size() ? seq1 : seq2;
    }

    public static void printList(ArrayList<Property> list) {

        for (Property item : list) {
            System.out.println(item.toString() + " ");
        }
    }


    public static void main(String[] args) {

        ArrayList<Property> items = initialize();
        ArrayList<Property> solution = getIncreasingSequence(items);
        printList(solution);
    }
}
