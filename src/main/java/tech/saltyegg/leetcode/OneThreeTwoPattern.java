package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 9/11/17
 */
public class OneThreeTwoPattern {

    public boolean find132pattern(int[] nums) {
        int first = 0;
        int second = 1;

        while (first < nums.length - 2 && second < nums.length - 1) {
            while (first + 1 < nums.length - 2 && nums[first] >= nums[first + 1]) {
                first++;
            }
            second = first + 1;

            while (second + 1 < nums.length - 1 && nums[second] <= nums[second + 1]) {
                second++;
            }

            for (int t = second + 1; t < nums.length; t++) {
                int x = nums[t];
                if (x > nums[first] && x < nums[second]) return true;
            }
            first = second + 1;
            second = first + 1;
        }
        return false;
    }


}
