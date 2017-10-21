package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by hzhou on 2016/5/11.
 * Email: i@hzhou.me
 * <p>
 * https://segmentfault.com/a/1190000003797291
 */
public class ClosestBinarySearchTreeValueII {

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Queue<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (result.size() < k) {
                result.offer(node.val);
            } else {
                int first = result.peek();
                if (Math.abs(first - target) > Math.abs(node.val - target)) {
                    result.poll();
                    result.offer(node.val);
                } else {
                    break;
                }
            }

            if (node.right != null) {
                TreeNode right = node.right;
                while (right != null) {
                    stack.add(right);
                    right = right.left;
                }
            }
        }

        return new ArrayList<>(result);
    }
}
