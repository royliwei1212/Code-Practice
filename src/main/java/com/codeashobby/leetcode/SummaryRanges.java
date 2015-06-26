package com.codeashobby.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzhou on 2015/6/25.
 * Email: i@hzhou.me
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        int head, last;
        head = last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            if (last + 1 != x) {
                result.add(helper(head, last));
                head = last = x;
            } else {
                last = x;
            }
        }

        result.add(helper(head, last));
        return result;
    }

    private String helper(int a, int b) {
        if (a == b) {
            return a + "";
        } else {
            return a + "->" + b;
        }
    }
}
