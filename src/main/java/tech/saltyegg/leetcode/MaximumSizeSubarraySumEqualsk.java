package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hzhou on 2016/5/7.
 * Email: i@hzhou.me
 */
public class MaximumSizeSubarraySumEqualsk {

    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int size = nums.length;
        Map<Integer, Integer> map = new HashMap<>(size);

        int sum = 0;
        int max = 0;
        for (int i = 0; i < size; i++) {
            int n = nums[i];
            sum += n;
            if (sum == k) {
                max = Math.max(max, i + 1);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

            int remain = sum - k;
            if (map.containsKey(remain)) {
                max = Math.max(max, i - map.get(remain));
            }
        }
        return max;
    }

}
