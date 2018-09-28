package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hzhou
 * @since 8/28/17
 */
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int p = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            p += nums[i];

            result += map.getOrDefault(p - k, 0);
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        return result;
    }

}
