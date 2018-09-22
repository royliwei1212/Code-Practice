package tech.saltyegg.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import tech.saltyegg.leetcode.parent.TreeNode;

/**
 * @author hzhou
 * @since 9/15/17
 */
public class FindBottomLeftTreeValue {

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int result = root.val;
        queue.add(root);
        queue.add(null);

        boolean isPreNull = true;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                isPreNull = true;
                if (!queue.isEmpty()) queue.add(null);
                continue;
            }
            if (isPreNull) {
                result = node.val;
                isPreNull = false;
            }
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);

        }

        return result;
    }

}
