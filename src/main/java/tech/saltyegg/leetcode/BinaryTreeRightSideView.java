/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import tech.saltyegg.leetcode.parent.TreeNode;

/**
 * Description
 *
 * @author hzhou
 */
public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) {
            return result;
        }
        queue.offer(root);
        int p = 1;
        int level = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            p--;
            if (node.left != null) {
                queue.offer(node.left);
                level++;
            }

            if (node.right != null) {
                queue.offer(node.right);
                level++;
            }

            if (p == 0) {
                result.add(node.val);
                p = level;
                level = 0;
            }
        }
        return result;
    }
}