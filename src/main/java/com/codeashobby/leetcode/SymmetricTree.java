/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package com.codeashobby.leetcode;

import com.codeashobby.leetcode.parent.TreeNode;

/**
 * Description:
 *
 * @author hzhou
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return root == null || helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null && right != null || left != null && right == null || left.val != right.val) {
            return false;
        }

        return helper(left.left, right.right) && helper(left.right, right.left);

    }
}