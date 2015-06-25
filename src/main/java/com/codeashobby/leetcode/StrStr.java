package com.codeashobby.leetcode;

/**
 * Created by hzhou on 5/1/15. codeashobby@gmail.com
 */
public class StrStr {

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack == null || haystack.length() == 0) {
            return -1;
        }

        for (int i = 0; i < haystack.length(); ) {
            if (haystack.length() - i < needle.length()) {
                return -1;
            }
            int j = 0;
            for (; j < needle.length(); j++) {
                if (haystack.charAt(i++) != needle.charAt(j)) {
                    break;
                }
            }

            if (j == needle.length()) {
                return i - j;
            } else {
                // reset i
                i -= j;
            }
        }
        return -1;
    }
}
