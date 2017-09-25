package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzhou on 2015/8/10.
 * Email: i@hzhou.me
 */
public class FactorCombinations {

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(n, 2, result, new ArrayList<>());
        return result;
    }

    private void helper(int n, int start, List<List<Integer>> result, List<Integer> out) {
        for (int i = start; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                List<Integer> newOut = new ArrayList<>(out);
                newOut.add(i);
                helper(n / i, i, result, newOut);
                newOut.add(n / i);
                result.add(newOut);
            }
        }
    }
}
