package com.codeashobby.leetcode;

import com.codeashobby.leetcode.parent.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hzhou on 2015/6/13.
 * Email: i@hzhou.me
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.left = right;
            node.right = left;
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
        }

        return root;
    }
}
