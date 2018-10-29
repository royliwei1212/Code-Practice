package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

/**
 * Created by hzhou on 2015/8/16.
 */
public class VerifyPreorderSequenceInBinarySearchTree {

    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length < 3) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        for (int i : preorder) {
            if (!list.isEmpty() && i < list.get(list.size() - 1)) {
                return false;
            }

            while (!stack.isEmpty() && i > stack.peek()) {
                list.add(stack.pop());
            }
            stack.add(i);
        }

        return true;
    }

    @Test
    public void test() {
        int[] arrays = new int[]{7, 5, 3, 1, 4, 6, 10, 8, 11, 13, 17};
        boolean result = verifyPreorder(arrays);
    }
}
