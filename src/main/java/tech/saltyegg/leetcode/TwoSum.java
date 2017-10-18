package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hzhou on 4/23/15. codeashobby@gmail.com
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if (map.containsKey(x)) {
                result[0] = map.get(x);
                result[1] = i + 1;
                return result;
            }
            map.put(nums[i], i + 1);
        }
        return result;
    }
}
