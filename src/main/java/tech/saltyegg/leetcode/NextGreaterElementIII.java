package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hzhou
 * @since 9/14/17
 */
public class NextGreaterElementIII {
    public int nextGreaterElement(int n) {
        if (n < 12) return -1;

        List<Integer> number = new ArrayList<>();
        while (n > 0) {
            number.add(n % 10);
            n /= 10;
        }

        Integer[] nums = number.toArray(new Integer[number.size()]);

        long result = 0;
        int i = 1;
        for (; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                break;
            }
        }
        if (i >= nums.length) return -1;

        int t = i - 1;
        for (int k = t; k >= 0; k--) {
            if (nums[k] > nums[i] && nums[t] > nums[k]) {
                t = k;
            }
        }
        int tmp = nums[i];
        nums[i] = nums[t];
        nums[t] = tmp;

        Arrays.sort(nums, 0, i);

        for (int j = nums.length - 1; j >= 0; j--) {
            int x = nums[j];
            if (j < i) {
                x = nums[i - j - 1];
            }
            result = 10 * result + x;
        }

        if (result > Integer.MAX_VALUE) return -1;
        return (int) result;
    }
}
