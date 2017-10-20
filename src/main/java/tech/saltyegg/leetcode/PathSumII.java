package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzhou on 4/22/15. codeashobby@gmail.com
 */
@SuppressWarnings("Duplicates")
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        helper(root, new ArrayList<>(), result, sum);
        return result;
    }

    private void helper(TreeNode root, List<Integer> crt, List<List<Integer>> result, int target) {
        if (root == null) return;

        crt.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                result.add(new ArrayList<>(crt));
            }
        } else {
            if (root.left != null) {
                helper(root.left, new ArrayList<>(crt), result, target - root.val);
            }

            if (root.right != null) {
                helper(root.right, crt, result, target - root.val);
            }
        }

    }
}
