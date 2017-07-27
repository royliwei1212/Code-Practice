package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BinaryWatch {

    public List<String> readBinaryWatch(int num) {
        if (num < 0 || num > 10) return null;

        List<String> result = new ArrayList<>();

        for (int i = Math.max(0, num - 6); i < Math.min(num + 1, 5); i++) {
            Set<Integer> hours = new HashSet<>();
            helper(hours, new int[]{1, 2, 4, 8}, 0, 0, i, 0);

            Set<Integer> minutes = new HashSet<>();
            helper(minutes, new int[]{1, 2, 4, 8, 16, 32}, 0, 0, num - i, 0);

            for (int x : hours) {
                if (x > 11) continue;
                for (int y : minutes) {
                    if (y > 59) continue;
                    result.add(x + ":" + (y < 10 ? "0" + y : y));
                }
            }
        }
        return result;
    }


    public void helper(Set<Integer> result, int[] nums, int num, int start, int total, int count) {
        if (count == total) {
            result.add(num);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            int c = nums[i];
            if ((num & c) == 0) {
                helper(result, nums, num | c, start + 1, total, count + 1);
            }
            helper(result, nums, num, start + 1, total, count);
        }
    }
}
