package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PerfectSquares {

    public int numSquares(int n) {
        if (n <= 0) return 0;
        Map<Integer, Integer> dict = new HashMap<>();

        for (int i = 1; i * i <= n; i++) {
            dict.put(i * i, 1);
        }

        Set<Integer> candidates = new HashSet<>(dict.keySet());
        int first = 2;
        while (first <= n) {
            findMin(dict, candidates, first++);
        }
        return dict.get(n);
    }

    private void findMin(Map<Integer, Integer> dict, Set<Integer> candidates, int key) {
        int result = dict.getOrDefault(key, Integer.MAX_VALUE);
        for (int c : candidates) {
            result = Math.min(result, dict.getOrDefault(key - c, Integer.MAX_VALUE - 1) + 1);
        }
        dict.put(key, result);
    }
}
