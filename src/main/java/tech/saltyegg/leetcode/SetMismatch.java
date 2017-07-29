package tech.saltyegg.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMismatch {

    public int[] findErrorNums(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int dup = 0;
        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            if (set.contains(i)) {
                dup = i;
                break;
            }
            set.add(i);
        }
        int[] result = new int[2];
        result[0] = dup;
        int n = nums.length;
        result[1] = dup + (n * (n + 1) / 2 - sum);
        return result;
    }
}
