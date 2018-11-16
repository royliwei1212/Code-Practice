package tech.saltyegg.leetcode;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.Test;

public class MinimumAreaRectangle {

    public int minAreaRect(int[][] points) {
        if (points == null || points.length < 4) return 0;
        TreeMap<Integer, Set<Integer>> map = new TreeMap<>();
        for (int[] p : points) {
            map.putIfAbsent(p[1], new TreeSet<>());
            map.get(p[1]).add(p[0]);
        }

        int result = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Set<Integer>> e : map.entrySet()) {
            Map.Entry<Integer, Set<Integer>> n = map.ceilingEntry(e.getKey() + 1);
            while (n != null) {
                result = Math.min(helper(e, n), result);
                n = map.ceilingEntry(n.getKey() + 1);
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    private int helper(Map.Entry<Integer, Set<Integer>> a, Map.Entry<Integer, Set<Integer>> b) {
        int result = Integer.MAX_VALUE;
        TreeSet<Integer> set = new TreeSet<>(a.getValue());
        set.retainAll(b.getValue());
        if (set.size() < 2) return result;
        int x = b.getKey() - a.getKey();
        for (int s : set) {
            Integer n = set.ceiling(s + 1);
            if (n != null) {
                result = Math.min((n - s) * x, result);
            }
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(minAreaRect(new int[][]{{1, 1}, {1, 3}, {3, 1}, {3, 3}, {2, 2}}));
    }
}
