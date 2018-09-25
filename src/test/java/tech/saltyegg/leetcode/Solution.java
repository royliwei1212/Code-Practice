package tech.saltyegg.leetcode;

import org.junit.Test;

public class Solution {

    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        for(int i = 0; i < nums.length; i++){
            if(i != nums[i] && nums[i] < nums.length && nums[nums[i]] < nums.length) {
                int t = nums[i];
                nums[i] = nums[nums[i]];
                nums[nums[i]] = t;
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(i != nums[i]) return i;
        }
        return nums.length;
    }

    @Test
    public void test() {
        missingNumber(new int[]{3,0,1});
    }
}
