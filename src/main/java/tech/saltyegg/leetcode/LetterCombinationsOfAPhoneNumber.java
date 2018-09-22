package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * Created by hzhou on 2015/5/21.
 * Email: codeashobby@gmail.com
 */
public class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }

        helper(new StringBuilder(), result, 0, digits);
        return result;
    }

    private void helper(StringBuilder sb, List<String> result, int index, String digits) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String s = getString().get(digits.charAt(index));
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            helper(sb, result, index + 1, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private Map<Character, String> getString() {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        map.put('0', " ");
        return map;
    }

    @Test
    public void test() {
        List<String> result = letterCombinations("23");
    }
}
