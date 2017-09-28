/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.leetcode;

/**
 * Description: Given two numbers represented as strings, return multiplication of the numbers as a string.
 * <p/>
 * Note: The numbers can be arbitrarily large and are non-negative.
 *
 * @author hzhou
 */
public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        if (num1 == null || num1.isEmpty() || num2 == null || num2.isEmpty()) return "0";
        int[] ch1 = new int[num1.length()];
        int[] ch2 = new int[num2.length()];
        for (int i = 0; i < num1.length(); i++) ch1[i] = num1.charAt(num1.length() - i - 1) - '0';
        for (int i = 0; i < num2.length(); i++) ch2[i] = num2.charAt(num2.length() - i - 1) - '0';

        int[] result = new int[num1.length() + num2.length()];
        for (int i = 0; i < ch1.length; i++) {
            for (int j = 0; j < ch2.length; j++) {
                int m = ch1[i] * ch2[j];
                result[i + j] += m;
            }
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int aResult : result) {
            int x = aResult + carry;
            sb.append(x % 10);
            carry = x / 10;
        }
        sb.reverse();
        while (sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.toString();
    }
}