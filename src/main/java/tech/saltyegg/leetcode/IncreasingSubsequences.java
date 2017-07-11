package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hzhou
 * @since 7/11/17
 */
public class IncreasingSubsequences {

    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        go(0, nums, new ArrayList<>(), result);
        return new ArrayList<>(result);
    }

    private void go(int start, int[] nums, List<Integer> crt, Set<List<Integer>> result) {

        if (start == nums.length) {
            if (crt.size() > 1) {
                result.add(crt);
            }
        }

        for (int i = start; i < nums.length; i++) {
            if (crt.isEmpty() || nums[i] >= crt.get(crt.size() - 1)) {
                go(i + 1, nums, new ArrayList<>(crt), result);
                crt.add(nums[i]);
                go(i + 1, nums, new ArrayList<>(crt), result);
            }
        }
    }

}
