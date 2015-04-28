package com.codeashobby.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.codeashobby.leetcode.parent.TreeNode;

/**
 * Created by hzhou on 4/27/15. codeashobby@gmail.com
 */
public class BinaryTreeInorderTraversal {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}

		helper(root, result);
		return result;
	}

	private void helper(TreeNode root, List<Integer> result) {
		if (root != null && root.left == null && root.right == null) {
			result.add(root.val);
		} else {

			if (root.left != null) {
				helper(root.left, result);
			}

			result.add(root.val);

			if (root.right != null) {
				helper(root.right, result);
			}
		}
	}

}
