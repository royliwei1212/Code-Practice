package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementI {

    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> dict = new HashMap<>();
        for (int i : nums) {
            for (Map.Entry<Integer, Integer> entry : dict.entrySet()) {
                if (i > entry.getKey() && entry.getValue() == -1) {
                    dict.put(entry.getKey(), i);
                }
            }
            dict.put(i, -1);
        }
        int[] result = new int[findNums.length];
        for (int i = 0; i < findNums.length; i++) {
            result[i] = dict.get(findNums[i]);
        }
        return result;
    }

}
