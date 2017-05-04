package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 4/25/17
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = 0;
        int crt = 0;
        for (int i : nums) {
            if (i == 0) {
                max = Math.max(max, crt);
                crt = 0;
            } else {
                crt++;
            }
        }
        return Math.max(max, crt);
    }
}
