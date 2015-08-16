package com.codeashobby.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * Created by hzhou on 2015/8/10.
 * Email: i@hzhou.me
 */
public class FactorCombinations {

    public List<List<Integer>> getFactors(int n) {
        HashSet<List<Integer>> result = new HashSet<>();
        helper(result, new ArrayList<>(), n, n, 2);
        return new ArrayList<>(result);
    }

    public void helper(HashSet<List<Integer>> result, List<Integer> crt, int remain, int n, int start) {
        if (remain == 0 || start > n / 2) {
            return;
        }

        if (remain == 1) {
            result.add(crt);
        }

        // TODO: stackOverflow, maybe I can improve it here

        if (remain % start == 0) {
            int t = start;
            List<Integer> tmp = new ArrayList<>(crt);
            while (remain % t == 0) {
                tmp.add(start);
                t *= start;
            }
            helper(result, tmp, start * remain / t, n, start + 1);
        }


        helper(result, crt, remain, n, start + 1);
    }

    @Test
    public void test() {
        List<List<Integer>> result = getFactors(32);
        result = getFactors(8192);
    }
}
