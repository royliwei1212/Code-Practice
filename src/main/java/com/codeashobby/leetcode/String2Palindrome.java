package com.codeashobby.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

/**
 * Created by hzhou on 2015/6/9.
 * Email: i@hzhou.me
 */
public class String2Palindrome {

    public String palindrome(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int value = 1;
            if (map.containsKey(c)) {
                value += map.get(c);
            }
            map.put(c, value);
        }

        int oddCount = 0;

        if (s.length() % 2 != 0) {
            oddCount--;
        }
        String oddStr = "";
        for (char c : map.keySet()) {
            if (map.get(c) % 2 != 0) {
                oddStr = genStr(c, map.get(c));
                oddCount++;
                if (oddCount > 0) {
                    return null;
                }

            } else {
                sb.insert(sb.length() / 2, genStr(c, map.get(c)));
            }
        }

        if (oddStr.length() > 0) {
            sb.insert(sb.length() / 2, oddStr);
        }

        return sb.toString();
    }

    private String genStr(char c, int count) {
        StringBuilder sb = new StringBuilder();
        while (count > 0) {
            sb.append(c);
            count--;
        }
        return sb.toString();
    }

    @Test
    public void test() {
        String s = palindrome("2121");
        assertNotNull(s);
        System.out.println(s);

        s = palindrome("212145");
        assertNull(s);
        System.out.println(s);

        s = palindrome("21214");
        assertNotNull(s);
        System.out.println(s);

        s = palindrome("11111111111111111111511");
        assertNotNull(s);
        System.out.println(s);
    }
}
