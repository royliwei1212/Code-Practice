package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NextGreaterElementII {

    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[max]) {
                max = i;
            }
        }

        int x = max + nums.length;
        int[] result = new int[nums.length];
        result[max] = -1;
        List<Integer> queue = new ArrayList<>();
        queue.add(nums[max]);
        for (int i = x - 1; i > max; i--) {
            int index = i % nums.length;
            if (nums[index] == nums[max]) result[index] = -1;
            for (int n = queue.size() - 1; n >= 0; n--) {
                if (queue.get(n) > nums[index]) {
                    result[index] = queue.get(n);
                    break;
                }
            }
            if (nums[index] > nums[(i - 1) % nums.length]) queue.add(nums[index]);

        }
        return result;
    }
}
