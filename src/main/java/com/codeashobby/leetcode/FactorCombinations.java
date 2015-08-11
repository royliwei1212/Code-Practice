package com.codeashobby.leetcode;

import java.util.*;

/**
 * Created by hzhou on 2015/8/10.
 * Email: i@hzhou.me
 */
public class FactorCombinations {

    public List<List<Integer>> getFactors(int n) {
        Set<List<Integer>> result = new HashSet<>();

        int dist = (int) Math.sqrt(n);

        for (int i = 2; i <= dist; i++) {
            if (n % i == 0) {
                List<List<Integer>> tmp = helper(n / i);
                for (List<Integer> l : tmp) {
                    l.add(i);
                    Collections.sort(l);
                    result.add(l);
                }
            }
        }
        return new ArrayList<>(result);
    }

    public List<List<Integer>> helper(int n) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> t = new ArrayList<>();
        t.add(n);
        result.add(t);

        int dist = (int) Math.sqrt(n);

        for (int i = 2; i <= dist; i++) {
            if (n % i == 0) {
                List<List<Integer>> tmp = helper(n / i);
                for (List<Integer> l : tmp) {
                    l.add(i);
                    result.add(l);
                }
            }
        }
        return result;
    }
}
