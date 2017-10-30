package tech.saltyegg.leetcode;

import java.util.HashSet;
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

}
