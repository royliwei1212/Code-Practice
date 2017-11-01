package tech.saltyegg.leetcode;

public class StringCompression {

    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) return 0;
        char pre = chars[0];
        int count = 1;
        int result = 1;
        for (int i = 1; i <= chars.length; i++) {
            if (i < chars.length && chars[i] == pre) {
                count++;
            } else {
                if (count > 1) {
                    for (char c : String.valueOf(count).toCharArray()) {
                        chars[result++] = c;
                    }
                }
                if (i == chars.length) break;
                chars[result++] = chars[i];
                pre = chars[i];
                count = 1;
            }
        }
        return result;
    }
}
