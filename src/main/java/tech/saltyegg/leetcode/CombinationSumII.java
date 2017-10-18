package tech.saltyegg.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by hzhou on 5/10/15. codeashobby@gmail.com
 */
public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList<Integer>(), result);
        return new ArrayList<List<Integer>>(new HashSet<List<Integer>>(result));
    }

    private void helper(int[] candidates, int start, int target, List<Integer> crt, List<List<Integer>> result) {
        for (int i = start; i < candidates.length; i++) {
            int c = candidates[i];
            if (c == target) {
                crt.add(c);
                result.add(new ArrayList<Integer>(crt));
                return;
            }

            if (c < target) {
                crt.add(c);
                helper(candidates, i + 1, target - c, new ArrayList<Integer>(crt), result);
                crt.remove(crt.size() - 1);

            } else {
                return;
            }
        }
    }

    @Test
    public void test() {
        int[] nums = new int[]{10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> result = combinationSum2(nums, 8);
    }
}
