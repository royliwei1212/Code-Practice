package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.TreeNode;

/**
 * Created by hzhou on 2015/8/9. Email: i@hzhou.me
 */
public class LowestCommonAncestorOfABinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            int n = root.val;
            int a = p.val;
            int b = q.val;

            if ((n >= a && n <= b) || (n >= b && n <= a)) {
                return root;
            } else {
                root = n > a && n > b ? root.left : root.right;
            }
        }
    }

}
