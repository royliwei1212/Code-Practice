package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hzhou
 * @since 9/11/17
 */
public class ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 2) return false;
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int pre = 0;
        for (int n : nums) {
            sum += n;
            int x = (k == 0) ? sum : sum % k;
            if (set.contains(x)) return true;
            set.add(pre);
            pre = x;
        }
        return false;
    }

    public boolean checkSubarraySum2(int[] nums, int k) {
        if (nums == null || nums.length < 2) return false;
        if (k == 0) return all0(nums);
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = (sum + nums[i]) % k;
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            } else {
                if (i - map.get(sum) > 1) return true;
            }
        }

        return false;

    }

    private boolean all0(int[] nums) {
        for (int n : nums) if (n != 0) return false;
        return true;
    }

}
