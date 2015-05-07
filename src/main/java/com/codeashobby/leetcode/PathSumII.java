package com.codeashobby.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.codeashobby.leetcode.parent.TreeNode;

/**
 * Created by hzhou on 4/22/15. codeashobby@gmail.com
 */
public class PathSumII {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		List<Integer> crt = new ArrayList<Integer>();
		helper(root, crt, result, sum);
		return result;
	}

	private void helper(TreeNode root, List<Integer> crt, List<List<Integer>> result, int target) {
		if (root == null) {
			return;
		}
		crt.add(root.val);
		if (root.left == null && root.right == null) {
			if (root.val == target) {
				List<Integer> tmp = new ArrayList<Integer>(crt);
				result.add(tmp);
			}
		} else {
			if (root.left != null) {
				helper(root.left, new ArrayList<Integer>(crt), result, target - root.val);
			}

			if (root.right != null) {
				helper(root.right, crt, result, target - root.val);
			}
		}

	}
}
