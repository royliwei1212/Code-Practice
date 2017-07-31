package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;

public class KdiffPairsInAnArray {

    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        Map<Integer, Integer> dict = new HashMap<>();
        for (int i : nums) {
            dict.put(i, dict.getOrDefault(i, 0) + 1);
        }

        int result = 0;
        for (int i : dict.keySet()) {
            int x = i + k;
            if (x == i) {
                if (dict.get(i) > 1) result++;
            } else if (dict.containsKey(x)) {
                result++;
            }
        }

        return result;
    }

}
