package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hzhou
 * @since 9/14/17
 */
public class CountOfSmallerNumbersAfterSelf {

    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();

        List<Integer> sorted = new ArrayList<>();
        List<Integer> result = new ArrayList<>(nums.length);

        for (int i = nums.length - 1; i >= 0; i--) {
            int l = 0;
            int r = sorted.size();
            while (l < r) {
                int m = l + (r - l) / 2;
                if (sorted.get(m) >= nums[i]) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            result.add(0, r);
            sorted.add(r, nums[i]);
        }

        return result;
    }

}
