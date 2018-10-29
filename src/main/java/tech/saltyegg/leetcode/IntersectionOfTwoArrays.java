package tech.saltyegg.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by hzhou on 2016/5/18.
 */
public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> result = new HashSet<>();

        for (int n : nums2) {
            if (set1.contains(n)) {
                result.add(n);
            }
        }
        int[] res = new int[result.size()];
        int i = 0;
        for (int x : result) {
            res[i++] = x;
        }
        return res;
    }

}
