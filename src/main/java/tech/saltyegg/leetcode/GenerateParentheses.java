package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Created by hzhou on 2015/5/21.
 * Email: codeashobby@gmail.com
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(0, 0, n, result, "");
        return result;
    }

    private void helper(int l, int r, int n, List<String> result, String sb) {
        if (l > n || r > n) return;
        if (l == n && r == n) {
            result.add(sb);
            return;
        }
        if (l < n) helper(l + 1, r, n, result, sb + "(");
        if (l > r) helper(l, r + 1, n, result, sb + ")");
    }

    @Test
    public void test() {
        List<String> result = generateParenthesis(3);
    }
}
