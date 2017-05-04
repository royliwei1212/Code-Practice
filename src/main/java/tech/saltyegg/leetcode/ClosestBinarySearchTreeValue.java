package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.TreeNode;

/**
 * Created by hzhou on 2016/5/10.
 * Email: i@hzhou.me
 */
public class ClosestBinarySearchTreeValue {

    public int closestValue(TreeNode root, double target) {
        int closet = root.val;
        while (root != null) {
            int r = root.val;
            closet = Math.abs(closet - target) > Math.abs(r - target) ? r : closet;
            root = r > target ? root.left : root.right;
        }
        return closet;
    }
}
