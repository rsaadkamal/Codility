package com.codility.Interview;

import java.util.*;

/**
 * Created by Chaklader on 7/5/18.
 */
public class I {


    // problem - lll
    // -------------

    /*
        Victor
        Veronica
        Ryan
        Dave
        Maria
        Maria
        Farah
        Farah
        Ryan
        Veronica

        ================
        answer: Veronica
        ================
    */

    // String[] votes = { "Victor", "Veronica", "Ryan", "Dave", "Maria",
    //                      "Maria", "Farah", "Farah","Ryan",  "Veronica"};

    public static String electionWinner(String[] votes) {

        // TreeMap will put the values in the ascending order
        Map<String, Integer> map = new TreeMap<String, Integer>();

        for (String vote : votes) {

            String key = vote;
            Integer value = map.containsKey(key) ? map.get(key) + 1 : 1;

            map.put(key, value);
        }

        List<String> keys = new ArrayList<String>();

        int max = Collections.max(map.values());

        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            if (entry.getValue() == max) {
                keys.add(entry.getKey());
            }
        }

        // the list is already sorded in the ascending order due
        // to the use of TreeMap

        String rst = keys.get(keys.size() - 1);
        return rst;
    }


    public static String electionWinner1(String[] votes) {

        // TreeMap will put the values in the ascending order
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();

        for (String vote : votes) {

            String key = vote;
            Integer value = map.containsKey(key) ? map.get(key) + 1 : 1;

            map.put(key, value);
        }

        int max = Collections.max(map.values());

        Iterator it = map.entrySet().iterator();

        while (it.hasNext()) {

            Map.Entry entry = (Map.Entry) it.next();

            if (!(entry.getValue()).equals(max)) {
                it.remove();
            }
        }

        // System.out.println(map.lastEntry());

        return map.lastKey();
    }

    public static void printMap(Map<String, Integer> map) {

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
        }
    }
    /* END ofsolution -III*/


    public static void mySetTest() {

        Set<Integer> set = new TreeSet<Integer>();

        set.add(3);
        set.add((int) 3.0);
        set.add(2);
        set.add(2);

        set.add(new Integer(2));
        set.add(Integer.parseInt("2"));

        System.out.println(set);
        // [2, 3]
    }
    /*END of solution*/

}
