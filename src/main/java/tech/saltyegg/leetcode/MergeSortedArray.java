/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.leetcode;

/**
 * Description:
 *
 * @author hzhou
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;

        for (int i = m + n - 1; i >= n; i--) {
            nums1[i] = nums1[i - n];
        }

        int l = n, r = 0, start = 0;
        while (r < n) {
            if (l < m + n && nums1[l] < nums2[r]) {
                nums1[start++] = nums1[l++];
            } else {
                nums1[start++] = nums2[r++];
            }
        }
    }
}