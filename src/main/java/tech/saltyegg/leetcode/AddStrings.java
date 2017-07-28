package tech.saltyegg.leetcode;

public class AddStrings {

    public String addStrings(String num1, String num2) {
        char[] x = new StringBuilder(num1).reverse().toString().toCharArray();
        char[] y = new StringBuilder(num2).reverse().toString().toCharArray();

        char[] l, s;
        if (num1.length() > num2.length()) {
            l = x;
            s = y;
        } else {
            l = y;
            s = x;
        }
        StringBuilder sb = new StringBuilder();

        int carry = 0;
        int i = 0;
        for (; i < l.length; i++) {
            int a = l[i] - '0';
            int b = (i >= s.length) ? 0 : s[i] - '0';
            sb.append((a + b + carry) % 10);
            if (a + b + carry >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
        }
        if (carry > 0) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }
}
