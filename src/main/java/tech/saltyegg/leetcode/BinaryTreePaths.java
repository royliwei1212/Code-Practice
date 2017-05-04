package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzhou on 2015/8/16.
 * Email: i@hzhou.me
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        helper(result, new ArrayList<>(), root);

        return result;
    }

    private void helper(List<String> result, List<Integer> crt, TreeNode root) {
        if (root == null) {
            return;
        } else {
            crt.add(root.val);
        }

        if (root.right == null && root.left == null) {
            result.add(getString(crt));
            return;
        }

        if (root.left != null) {
            helper(result, new ArrayList<>(crt), root.left);
        }

        if (root.right != null) {
            helper(result, new ArrayList<>(crt), root.right);
        }
    }

    private String getString(List<Integer> crt) {
        if (crt == null || crt.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(crt.get(0));
        for (int i = 1; i < crt.size(); i++) {
            sb.append("->").append(crt.get(i));
        }
        return sb.toString();
    }
}
