package tech.saltyegg.leetcode;

import org.junit.Test;

public class LongestArithmeticProgression {

    public int lengthOfLongestAP(int nums[]) {
        if (nums == null) return 0;
        if (nums.length <= 2) return nums.length;

        int[][] dp = new int[nums.length][nums.length];
        int result = 2;

        for (int i = 0; i < nums.length; i++) {
            dp[i][nums.length - 1] = result;
        }

        for (int i = nums.length - 2; i > 0; i--) {
            int s = i - 1, e = i + 1;
            int n = 2 * nums[i];
            while (s >= 0 && e < nums.length) {
                int a = nums[s];
                int b = nums[e];
                if (a + b == n) {
                    dp[s][i] = dp[i][e] + 1;
                    result = Math.max(result, dp[s][i]);
                    s--;
                    e++;
                } else if (a + b < n) {
                    e++;
                } else {
                    dp[s][i] = 2;
                    s--;
                }
            }
            //for (int k = 0; k < s; k++) dp[k][i] = 2;
        }
        return result;
    }

    @Test
    public void test() {
        int set1[] = {1, 7, 10, 13, 14, 19};
        System.out.println(lengthOfLongestAP(set1));

        int set2[] = {1, 7, 10, 15, 27, 29};
        System.out.println(lengthOfLongestAP(set2));

        int set3[] = {2, 4, 6, 8, 10};
        System.out.println(lengthOfLongestAP(set3));


    }
}
