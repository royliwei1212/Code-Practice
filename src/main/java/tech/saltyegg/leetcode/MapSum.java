package tech.saltyegg.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class MapSum {

    private TreeMap<String, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        map = new TreeMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int result = 0;
        Map.Entry<String, Integer> entry = map.ceilingEntry(prefix);
        while (entry != null && entry.getKey().startsWith(prefix)) {
            result += entry.getValue();
            entry = map.higherEntry(entry.getKey());
        }
        return result;
    }

}
