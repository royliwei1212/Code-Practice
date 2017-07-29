package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.TreeNode;

public class ConvertBSTToGreaterTree {

    public TreeNode convertBST(TreeNode root) {
        int[] sum = new int[]{0};
        helper(root, sum);
        return root;
    }

    private void helper(TreeNode node, int[] sum) {
        if (node == null) {
            return;
        }

        helper(node.right, sum);
        node.val += sum[0];
        sum[0] = node.val;
        helper(node.left, sum);
    }

}
