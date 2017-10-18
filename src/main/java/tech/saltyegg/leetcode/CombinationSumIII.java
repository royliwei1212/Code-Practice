/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author hzhou
 */
public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();

        if (k < 1 || n < k || n > 9 * k) {
            return result;
        }
        helper(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void helper(int start, int sum, int k, List<Integer> crt, List<List<Integer>> result) {
        if (crt.size() == k) {
            if (sum == 0) {
                result.add(crt);
            }
            return;
        }

        for (int i = start; i < 10; i++) {
            if (sum >= i) {
                List<Integer> tmp = new ArrayList<>(crt);
                tmp.add(i);
                helper(i + 1, sum - i, k, tmp, result);
            } else {
                break;
            }
        }
    }

    @Test
    public void test() {
        List<List<Integer>> result = combinationSum3(3, 7);
    }
}