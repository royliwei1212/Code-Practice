package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hzhou
 * @since 9/4/17
 */
public class NumArray {

    private int[] sum;
    private Map<Integer, Integer> dict;

    public NumArray(int[] nums) {
        sum = new int[nums.length];
        dict = new HashMap<>();
        if (nums.length == 0) return;
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = nums[i] + sum[i - 1];
        }
    }

    public void update(int i, int val) {
        if (i >= 0 && i < sum.length) {
            if (val == 0) {
                dict.remove(i);
            } else {
                dict.put(i, val);
            }
        }
    }

    public int sumRange(int i, int j) {
        int result = sum[j] - (i == 0 ? 0 : sum[i - 1]);
        for (Map.Entry<Integer, Integer> entry : dict.entrySet()) {
            int key = entry.getKey();
            if (key >= i && key <= j) {
                result += entry.getValue() - sum[key] + (key == 0 ? 0 : sum[key - 1]);
            }
        }
        return result;
    }

}
