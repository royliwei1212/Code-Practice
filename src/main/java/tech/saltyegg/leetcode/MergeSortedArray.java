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
        for (int i = n + m - 1, j = m - 1; i >= n; i--, j--) {
            nums1[i] = nums1[j];
        }

        int i = n;
        int j = 0;
        int k = 0;

        while (i < m + n || j < n) {
            int a = i == m + n ? Integer.MAX_VALUE : nums1[i];
            int b = j == n ? Integer.MAX_VALUE : nums2[j];
            if (a >= b) {
                nums1[k++] = b;
                j++;
            } else {
                nums1[k++] = a;
                i++;
            }
        }
    }
}