package tech.saltyegg.leetcode;

public class TotalHammingDistance {

    public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                result += hammingDistance(nums[i], nums[j]);
            }
        }
        return result;
    }

    private int hammingDistance(int a, int b) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int x = a >> i;
            int y = b >> i;
            result += (x & 1) ^ (y & 1);
        }
        return result;
    }
}
