package tech.saltyegg.leetcode;

public class TotalHammingDistance {

    public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        int result = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int n : nums) {
                cnt += (n >> i) & 1;
            }
            result += (nums.length - cnt) * cnt;
        }
        return result;
    }
}
