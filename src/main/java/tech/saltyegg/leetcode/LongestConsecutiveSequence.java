package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import static org.junit.Assert.assertSame;

/**
 * Description: Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * <p/>
 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements sequence is [1, 2, 3, 4]. Return its
 * length: 4.
 * <p/>
 * Your algorithm should run in O(n) complexity.
 *
 * @author hzhou
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> dp = new HashMap<>();
        int result = 1;
        for (int n : nums) {
            if (dp.containsKey(n)) continue;
            int left = dp.getOrDefault(n - 1, 0);
            int right = dp.getOrDefault(n + 1, 0);
            int sum = left + right + 1;
            result = Math.max(result, sum);
            dp.put(n, sum);
            dp.put(n - left, sum);
            dp.put(n + right, sum);
        }
        return result;
    }

    @Test
    public void test() {
        int[] nums = new int[]{2147483646, -2147483647, 0, 2, 2147483644, -2147483645, 2147483645};
        assertSame(3, longestConsecutive(nums));
    }
}