/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.leetcode;

import org.junit.Test;

import java.util.TreeSet;

/**
 * Description:
 * <p>
 * http://bookshadow.com/weblog/2015/06/03/leetcode-contains-duplicate-iii/
 *
 * @author hzhou
 */

public class ContainsDuplicateIII {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) {
            return false;
        }
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (set.floor(n) != null && n <= t + set.floor(n) ||
                    set.ceiling(n) != null && set.ceiling(n) <= t + n) {
                return true;
            }
            set.add(n);
            if (i >= k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }


    @Test
    public void test() {
        int[] nums = new int[]{1, 3, 6, 2};
        boolean b = containsNearbyAlmostDuplicate(nums, 1, 2);
    }
}