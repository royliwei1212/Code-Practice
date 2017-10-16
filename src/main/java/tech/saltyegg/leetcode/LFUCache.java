package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author hzhou
 * @since 8/27/17
 */
public class LFUCache {

    private TreeMap<Integer, List<Integer>> countMap;
    private Map<Integer, Integer> cache;
    private Map<Integer, Integer> keyCount;
    private int capacity;
    private int min = 0;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.countMap = new TreeMap<>((o1, o2) -> o2 - o1);
        this.keyCount = new HashMap<>(capacity);
        this.cache = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;

        int preCount = keyCount.get(key);
        countMap.get(preCount).remove(new Integer(key));
        if (countMap.get(preCount).isEmpty()) countMap.remove(preCount);

        int count = keyCount.get(key) + 1;
        keyCount.put(key, count);

        if (!countMap.containsKey(count)) countMap.put(count, new ArrayList<>());
        countMap.get(count).add(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        int count = keyCount.getOrDefault(key, 0);
        if (cache.size() >= capacity || cache.containsKey(key)) {
            int val2Del = key;
            if (cache.containsKey(key)) {
                countMap.get(count).remove(new Integer(key));
                if (countMap.get(count).isEmpty()) countMap.remove(count);
            } else {
                Map.Entry<Integer, List<Integer>> minEntry = countMap.lastEntry();
                val2Del = minEntry.getValue().get(0);
                countMap.get(minEntry.getKey()).remove(0);
                if (minEntry.getValue().isEmpty()) countMap.remove(minEntry.getKey());
            }
            cache.remove(val2Del);
            keyCount.remove(val2Del);
        }
        cache.put(key, value);
        keyCount.put(key, count + 1);
        if (!countMap.containsKey(count + 1)) countMap.put(count + 1, new ArrayList<>());
        countMap.get(count + 1).add(key);
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(2, 1);
        cache.put(2, 2);
        cache.get(2);       // returns 1
        cache.put(1, 1);    // evicts key 2
        cache.put(4, 1);    // evicts key 1.
        cache.get(2);       // returns 4
    }

}
