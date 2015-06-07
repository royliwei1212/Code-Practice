package com.codeashobby.leetcode;

import com.codeashobby.leetcode.parent.TreeNode;

/**
 * Created by hzhou on 2015/6/7.
 * Email: i@hzhou.me
 */
public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l, r;
        l = r = 0;
        TreeNode cursor = root;
        while (cursor != null) {
            l++;
            cursor = cursor.left;
        }
        cursor = root;
        while (cursor != null) {
            r++;
            cursor = cursor.right;
        }

        if (l == r) {
            return (int) Math.pow(2, l) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }

}
