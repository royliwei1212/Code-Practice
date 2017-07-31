package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p.isEmpty() || s.length() < p.length()) return result;
        char[] cp = p.toCharArray();
        Arrays.sort(cp);
        p = String.valueOf(cp);

        StringBuilder sb = new StringBuilder();
        sb.append("0").append(s.substring(0, p.length() - 1));

        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            sb.deleteCharAt(0).append(s.charAt(i + p.length() - 1));
            if (isAnagram(sb.toString(), p)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isAnagram(String a, String b) {
        if (a.equals(b)) return true;
        char[] ca = a.toCharArray();
        Arrays.sort(ca);
        return String.valueOf(ca).equals(b);
    }
}
