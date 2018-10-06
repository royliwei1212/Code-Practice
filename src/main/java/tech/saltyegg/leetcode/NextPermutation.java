package tech.saltyegg.leetcode;

import java.util.Arrays;

import org.junit.Test;

/**
 * Description: Implement next permutation, which rearranges numbers into the lexicographically next greater permutation
 * of numbers.
 * <p/>
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending
 * order).
 * <p/>
 * The replacement must be in-place, do not allocate extra memory.
 * <p/>
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand
 * column.
 * <pre>
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * </pre>
 *
 * @author hzhou
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int s = nums.length - 1;

        for (; s > 0; s--) {
            if (nums[s] > nums[s - 1]) break;
        }

        if (s == 0) {
            Arrays.sort(nums);
            return;
        }

        int t = nums[s - 1];
        int l = s;
        int r = nums.length - 1;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (l == m) break;
            if (nums[m] > t) l = m;
            else r = m - 1;


        }
        if (nums[r] > t) l = r;
        nums[s - 1] = nums[l];
        nums[l] = t;

        Arrays.sort(nums, s, nums.length);
    }

    @Test
    public void test() {
        int[] nums = new int[]{0, 0, 4, 2, 1, 0};
        nextPermutation(nums);
/*
        nums = new int[]{3, 2, 1};
		nextPermutation(nums);

		nums = new int[]{1, 1, 5};
		nextPermutation(nums);
*/
    }
}