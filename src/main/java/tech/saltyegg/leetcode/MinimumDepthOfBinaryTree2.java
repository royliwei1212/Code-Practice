/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import tech.saltyegg.leetcode.parent.TreeNode;

/**
 * Description
 *
 * @author hzhou
 */
public class MinimumDepthOfBinaryTree2 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int nextLevelCount = 1;
        int counter = 0;
        int depth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            nextLevelCount--;

            if (node.left == null && node.right == null) {
                return depth;
            }

            if (node.left != null) {
                queue.add(node.left);
                counter++;
            }

            if (node.right != null) {
                queue.add(node.right);
                counter++;
            }

            if (nextLevelCount == 0) {
                nextLevelCount = counter;
                counter = 0;
                depth++;
            }
        }

        return 0;
    }
}