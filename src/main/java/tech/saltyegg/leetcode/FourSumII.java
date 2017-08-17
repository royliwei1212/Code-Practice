package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hzhou
 * @since 8/16/17
 */
public class FourSumII {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> dict = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                dict.put(a + b, dict.getOrDefault(a + b, 0) + 1);
            }
        }

        int result = 0;
        for (int c : C) {
            for (int d : D) {
                int t = 0 - c - d;
                result += dict.getOrDefault(t, 0);
            }
        }
        return result;
    }

}
