package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.TreeNode;
import org.junit.Test;

/**
 * Created by hzhou on 2015/8/8.
 * Email: i@hzhou.me
 */
public class CountUnivalueSubtrees {

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int[] result = new int[]{0};
        helper(root, result);
        return result[0];
    }

    private boolean helper(TreeNode root, int[] result) {

        if (root.right == null && root.left == null) {
            result[0]++;
            return true;
        } else if (root.right != null && root.left == null) {
            if (helper(root.right, result) && root.val == root.right.val) {
                result[0]++;
                return true;
            } else {
                return false;
            }
        } else if (root.right == null) {
            if (helper(root.left, result) && root.val == root.left.val) {
                result[0]++;
                return true;
            } else {
                return false;
            }
        } else {
            boolean l = helper(root.right, result);
            boolean r = helper(root.left, result);
            if (l && r && root.val == root.left.val && root.val == root.right.val) {
                result[0]++;
                return true;
            } else {
                return false;
            }
        }

    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(5);

        countUnivalSubtrees(root);
    }
}
