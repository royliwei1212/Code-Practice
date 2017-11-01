package tech.saltyegg.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i < sum.length; i++) {
            if (nums[i - 1] >= s) return 1;
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        if (sum[nums.length] < s) return 0;
        int result = nums.length;
        for (int i = 0; i < sum.length - 1; i++) {
            int l = search(sum, i + 1, sum[i] + s);
            if (sum[l] - sum[i] >= s) result = Math.min(result, l - i);
        }
        return result == nums.length + 1 ? 0 : result;
    }

    private int search(int[] sum, int l, int target) {
        int r = sum.length - 1;
        if (target < sum[l]) return l;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (sum[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return r;
    }

    // solution 2
    public int minSubArrayLen2(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i < sum.length; i++) sum[i] = sum[i - 1] + nums[i - 1];
        if (sum[nums.length] < s) return 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < sum.length; i++) map.put(sum[i], i);
        int result = nums.length;
        for (int i = 0; i < sum.length; i++) {
            Map.Entry<Integer, Integer> e = map.ceilingEntry(sum[i] + s);
            if (e != null) result = Math.min(result, e.getValue() - i);
        }
        return result;
    }
}
