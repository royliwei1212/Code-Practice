package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhouhao on 5/20/2015.
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);
        helper(0, result, new ArrayList<>(), nums);

        return result;
    }

    private void helper(int start, List<List<Integer>> result, List<Integer> crt, int[] nums) {
        if (start >= nums.length) {
            result.add(crt);
            return;
        }

        helper(start + 1, result, new ArrayList<>(crt), nums);
        crt.add(nums[start]);
        helper(start + 1, result, new ArrayList<>(crt), nums);

    }

}
