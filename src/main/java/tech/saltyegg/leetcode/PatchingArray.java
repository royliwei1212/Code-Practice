package tech.saltyegg.leetcode;

/**
 * Created by hzhou on 2016/5/23.
 * Email: i@hzhou.me
 */
public class PatchingArray {

    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int i = 0;
        int result = 0;
        while (miss <= n) {
            if (i < nums.length && miss >= nums[i]) {
                miss += nums[i++];
            } else {
                miss *= 2;
                result++;
            }
        }
        return result;
    }

}
