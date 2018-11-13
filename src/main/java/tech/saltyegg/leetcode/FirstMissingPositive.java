package tech.saltyegg.leetcode;

import java.util.Set;
import java.util.TreeSet;

/**
 * Description: Given an unsorted integer array, find the first missing positive integer.
 * <p/>
 * For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 * <p/>
 * Your algorithm should run in O(n) time and uses constant space.
 *
 * @author hzhou
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {

        if (nums == null || nums.length < 1) {
            return 1;
        }

        for (int i = 0; i < nums.length; ) {
            int crt = nums[i];
            if (crt > 0 && crt <= nums.length && i + 1 != crt && nums[i] != nums[crt - 1]) {
                nums[i] = nums[crt - 1];
                nums[crt - 1] = crt;
            } else {
                i++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public int firstMissingPositive2(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for (int n : nums) if (n > 0) set.add(n);
        int i = 1;
        for (int n : set) {
            if (i++ != n) return i - 1;
        }
        return i;
    }
}