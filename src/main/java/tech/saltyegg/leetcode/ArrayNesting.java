package tech.saltyegg.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hzhou
 * @since 9/14/17
 */
public class ArrayNesting {

    public int arrayNesting(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> visited = new HashSet<>();
        int result = 1;
        for (int n : nums) {
            int x = n;
            int count = 0;
            while (!visited.contains(x)) {
                visited.add(x);
                x = nums[x];
                count++;
            }
            result = Math.max(result, count);
        }
        return result;
    }

}
