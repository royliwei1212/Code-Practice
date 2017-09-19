package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author hzhou
 * @since 9/19/17
 */
public class SplitArrayIntoConsecutiveSubsequences {

    public boolean isPossible(int[] nums) {
        if (nums == null || nums.length < 3) return false;

        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int n : nums) {
            PriorityQueue<Integer> pre = map.getOrDefault(n - 1, new PriorityQueue<>());
            int len = pre.isEmpty() ? 0 : pre.poll();
            PriorityQueue<Integer> crt = map.getOrDefault(n, new PriorityQueue<>());
            crt.add(len + 1);
            map.put(n, crt);
        }

        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            for (int i : entry.getValue()) {
                if (i < 3) return false;
            }
        }
        return true;
    }

}
