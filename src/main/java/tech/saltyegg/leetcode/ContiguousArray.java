package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hzhou
 * @since 8/15/17
 */
public class ContiguousArray {

    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        int sum = 0;
        int result = 0;
        Map<Integer, Integer> dict = new HashMap<>();
        dict.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] << 1) - 1;
            if (dict.containsKey(sum)) {
                result = Math.max(result, i - dict.get(sum));
            } else {
                dict.put(sum, i);
            }
        }
        return result;
    }

}
