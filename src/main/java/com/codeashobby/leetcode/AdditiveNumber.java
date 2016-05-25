package com.codeashobby.leetcode;

/**
 * Created by hzhou on 2016/5/24.
 * Email: i@hzhou.me
 */
public class AdditiveNumber {

    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) {
            return false;
        }

        for (int i = 1; i < num.length(); i++) {
            for (int j = i + 1; j < num.length(); j++) {
                String s1 = num.substring(0, i);
                String s2 = num.substring(i, j);
                if (s2.isEmpty() || (s2.length() > 1 && s2.charAt(0) == '0') || (s1.length() > 1 && s1.charAt(0) == '0')) {
                    continue;
                }

                long x = Long.valueOf(s1);
                long y = Long.valueOf(s2);

                long z = x + y;
                String pre = s1 + s2 + z;
                if (!num.startsWith(pre)) {
                    continue;
                }

                while (pre.length() < num.length()) {
                    x = y;
                    y = z;
                    z = x + y;
                    pre += z;
                }

                if (pre.equals(num)) {
                    return true;
                }
            }

        }
        return false;
    }

}
