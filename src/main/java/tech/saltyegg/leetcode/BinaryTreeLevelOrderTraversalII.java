package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tech.saltyegg.leetcode.parent.TreeNode;

/**
 * Description
 *
 * @author hzhou
 */
public class BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int c1 = 1;
        int c2 = 0;
        List<Integer> crt = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            crt.add(node.val);
            c1--;
            if (node.left != null) {
                queue.offer(node.left);
                c2++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                c2++;
            }
            if (c1 == 0) {
                c1 = c2;
                c2 = 0;
                result.add(0, new ArrayList<>(crt));
                crt.clear();
            }
        }
        if (!crt.isEmpty()) {
            result.add(0, new ArrayList<>(crt));
        }
        return result;
    }
}