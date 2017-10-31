package tech.saltyegg.leetcode;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] maxLen = new int[nums.length];
        int[] maxCnt = new int[nums.length];
        Arrays.fill(maxLen, 1);
        Arrays.fill(maxCnt, 1);
        int result = 1, maxLength = 0;
        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (maxLen[i] <= maxLen[j] + 1) {
                        if (maxLen[i] < maxLen[j] + 1) {
                            maxCnt[i] = maxCnt[j];
                        } else {
                            maxCnt[i] += maxCnt[j];
                        }
                        maxLen[i] = maxLen[j] + 1;
                    }
                }
            }

            if (maxLength == maxLen[i]) {
                result += maxCnt[i];
            } else if (maxLength < maxLen[i]) {
                result = maxCnt[i];
            }
            maxLength = Math.max(maxLength, maxLen[i]);
        }
        return result;
    }
}
