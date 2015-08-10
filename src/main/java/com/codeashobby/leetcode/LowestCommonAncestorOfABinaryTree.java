package com.codeashobby.leetcode;

import com.codeashobby.leetcode.parent.TreeNode;

/**
 * Created by hzhou on 2015/8/9.
 * Email: i@hzhou.me
 */
public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q).node;
    }

    private Item helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new Item(0, null);
        }

        Item left = helper(root.left, p, q);
        if (left.count == 2) {
            return left;
        }

        Item right = helper(root.right, p, q);
        if (right.count == 2) {
            return right;
        }

        int total = left.count + right.count;

        if (root == p || root == q) {
            total++;
        }

        return new Item(total, root);
    }

    class Item {
        int count;
        TreeNode node;

        public Item(int count, TreeNode node) {
            this.count = count;
            this.node = node;
        }
    }
}
