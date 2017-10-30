package tech.saltyegg.leetcode;

import java.util.*;

public class RandomizedSet {

    private List<Integer> list;
    private Map<Integer, Integer> map;
    private Random rand;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int loc = map.get(val);
        int lastLoc = list.size() - 1;
        int lastVal = list.get(lastLoc);
        list.set(loc, lastVal);
        map.put(lastVal, loc);
        map.remove(val);
        list.remove(lastLoc);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        if (list.isEmpty()) return -1;
        return list.get(rand.nextInt(list.size()));
    }

}
