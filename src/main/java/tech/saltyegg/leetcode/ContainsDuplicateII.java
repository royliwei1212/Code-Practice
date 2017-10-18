/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: Given an array of integers and an integer k, return true if and only if there are two distinct indices i
 * and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
 *
 * @author hzhou
 */
public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k < 1) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {
                if (map.get(nums[i]) < i - k) {
                    map.put(nums[i], i);
                } else {
                    return true;
                }
            }

        }
        return false;
    }
}