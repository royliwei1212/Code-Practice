package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.TreeNode;

/**
 * @author hzhou
 * @since 9/13/17
 */
public class InorderSuccessorInBST {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while (root != null) {
            if (root.val > p.val) {
                res = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return res;
    }

}
