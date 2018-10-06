package tech.saltyegg.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class LIS {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        int result = 1;
        for (int n : nums) {
            Map.Entry<Integer, Integer> entry = map.floorEntry(n - 1);
            int val = entry == null ? 1 : entry.getValue() + 1;
            map.put(n, val);
            result = Math.max(result, val);
        }

        return result;
    }

    @Test
    public void test() {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 3, 3, 3, 101, 18}));
    }
}
