package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {

    public int findLHS(int[] nums) {

        Map<Integer, Integer> dict = new HashMap<>();
        for (int i : nums) {
            dict.put(i, dict.getOrDefault(i, 0) + 1);
        }

        int result = 0;
        for (Map.Entry<Integer, Integer> entry : dict.entrySet()) {
            if (dict.containsKey(entry.getKey() + 1)) {
                result = Math.max(result, entry.getValue() + dict.get(entry.getKey() + 1));
            }
        }

        return result;
    }

}
