package tech.saltyegg.leetcode;

public class MinimumMovesToEqualArrayElements {

    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i : nums) {
            min = Math.min(i, min);
        }

        int result = 0;
        for (int i : nums) {
            result += i - min;
        }

        return result;
    }

}
