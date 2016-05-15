package com.codeashobby.leetcode;

/**
 * Created by hzhou on 2016/5/14.
 * Email: i@hzhou.me
 */
public class ReverseString {

    public String reverseString(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        return new StringBuilder(s).reverse().toString();
    }
}
