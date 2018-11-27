package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class RandomizedCollection {
    private Random rand;
    private Map<Integer, Set<Integer>> map;
    private List<Integer> list;

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {
        this.rand = new Random();
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        boolean result = false;
        if (!map.containsKey(val)) {
            result = true;
            map.put(val, new HashSet<>());
        }
        map.get(val).add(list.size());
        list.add(val);
        return result;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int loc = map.get(val).iterator().next();
        map.get(val).remove(loc);
        if (loc < list.size() - 1) {
            int lastVal = list.get(list.size() - 1);
            list.set(loc, lastVal);
            map.get(lastVal).remove(list.size() - 1);
            map.get(lastVal).add(loc);
        }
        list.remove(list.size() - 1);

        if (map.get(val).isEmpty()) map.remove(val);
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        if (list.isEmpty()) return -1;
        return list.get(rand.nextInt(list.size()));
    }
}
