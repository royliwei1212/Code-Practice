package tech.saltyegg.java;

import java.util.Arrays;

/**
 * @author hzhou
 * @since 9/27/17
 */
public class KMPSolution {

    private static int[] KMPPreProcessing(String s) {
        int n = s.length();
        int[] match = new int[n];
        Arrays.fill(match, -1);
        int j = -1;
        for (int i = 1; i < n; i++) {
            while (j >= 0 && s.charAt(i) != s.charAt(j + 1)) j = match[j];
            if (s.charAt(i) == s.charAt(j + 1)) j++;
            match[i] = j;
        }
        return match;
    }


    public static int strStr(String haystack, String needle) {
        if (needle == null) return 0;
        if (haystack == null) return -1;
        int m = haystack.length(), n = needle.length();
        int[] match = KMPPreProcessing(needle);
        int j = -1;
        for (int i = 0; i < m; i++) {
            while (j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)) j = match[j];
            if (haystack.charAt(i) == needle.charAt(j + 1)) j++;
            if (j == n - 1) return (i - n + 1);
        }
        return -1;

    }

    public static void main(String[] args) {
        strStr("abababaababacb", "ababacb");
    }
}
