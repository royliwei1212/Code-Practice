package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int max = 1;
        List<Integer> candidates = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            int count = list.size();
            if (max <= count) {
                if (max < count) {
                    candidates.clear();
                    max = count;
                }
                candidates.add(nums[i]);
            }
            map.put(nums[i], list);
        }
        if (max == 1) return 1;
        int result = nums.length;
        for (int c : candidates) {
            List<Integer> list = map.get(c);
            result = Math.min(result, list.get(list.size() - 1) - list.get(0) + 1);
        }
        return result;
    }
}
