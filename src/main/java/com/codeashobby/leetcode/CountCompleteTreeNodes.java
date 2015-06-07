package com.codeashobby.leetcode;

import com.codeashobby.leetcode.parent.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hzhou on 2015/6/7.
 * Email: i@hzhou.me
 */
public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        int result = 0;
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result++;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return result;
    }
}
