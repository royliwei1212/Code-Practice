package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 9/11/17
 */
public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) return false;

        int m1, m2;
        m1 = m2 = Integer.MAX_VALUE;

        for (int n : nums) {
            if (m1 >= n) {
                m1 = n;
            } else if (m2 >= n) {
                m2 = n;
            } else {
                return true;
            }
        }
        return false;
    }

}
