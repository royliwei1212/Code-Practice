package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.TreeNode;

/**
 * Created by hzhou on 4/28/15. codeashobby@gmail.com
 */
public class BinaryTreeUpsideDown {

    public TreeNode UpsideDownBinaryTree(TreeNode root) {
        TreeNode node = root, parent = null, right = null;
        while (node != null) {
            TreeNode left = node.left;
            node.left = right;
            right = node.right;
            node.right = parent;
            parent = node;
            node = left;
        }
        return parent;
    }
}
