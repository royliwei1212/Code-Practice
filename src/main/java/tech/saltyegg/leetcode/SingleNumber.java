package tech.saltyegg.leetcode;

/**
 * Description
 *
 * @author hzhou
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        assert nums.length > 0;

        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }

        return result;
    }
}