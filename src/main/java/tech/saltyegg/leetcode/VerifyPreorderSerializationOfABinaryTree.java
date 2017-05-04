package tech.saltyegg.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Created by hzhou on 2016/5/23.
 * Email: i@hzhou.me
 */
public class VerifyPreorderSerializationOfABinaryTree {

    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.isEmpty()) {
            return true;
        }

        List<Character> chars = Arrays.stream(preorder.split(",")).map(s -> s.charAt(0)).collect(Collectors.toList());
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            stack.push(c);
            while (stack.size() > 2 && stack.peek() == '#' && stack.get(stack.size() - 2) == '#' && stack.get(stack.size() - 3) != '#') {
                stack.pop();
                stack.pop();
                stack.pop();
                stack.push('#');
            }
        }

        return stack.size() == 1 && stack.peek() == '#';
    }

    public static void main(String[] args) {
        VerifyPreorderSerializationOfABinaryTree t = new VerifyPreorderSerializationOfABinaryTree();
        t.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
    }

}
