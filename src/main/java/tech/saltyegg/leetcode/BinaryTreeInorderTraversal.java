package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import tech.saltyegg.leetcode.parent.TreeNode;

/**
 * Created by hzhou on 4/27/15. codeashobby@gmail.com
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root == null) {
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            } else {
                stack.push(root);
                root = root.left;
            }
        }
        return result;
    }

}
