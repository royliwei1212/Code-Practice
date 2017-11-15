package tech.saltyegg.leetcode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class NumberOfAtoms {

    public String countOfAtoms(String formula) {
        if (formula == null || formula.isEmpty()) return "";
        Map<String, Integer> map = helper(formula, 1);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            sb.append(e.getKey());
            if (e.getValue() > 1) sb.append(e.getValue());
        }
        return sb.toString();
    }

    private Map<String, Integer> helper(String s, int factor) {
        if (s == null || s.isEmpty()) return new TreeMap<>();
        if (s.contains("(")) {
            int a = s.indexOf("(");
            int b = s.lastIndexOf(")");
            int i = b + 1;
            int f = 0;
            for (; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c < '0' || c > '9') break;
                f = 10 * f + (c - '0');
            }
            f = Math.max(f, 1);
            Map<String, Integer> left = helper(s.substring(0, a), factor);
            Map<String, Integer> root = helper(s.substring(a + 1, b), factor * f);
            Map<String, Integer> right = i >= s.length() ? new TreeMap<>() : helper(s.substring(i), factor);
            return merge(left, root, right);
        } else {
            // H2O4
            Map<String, Integer> map = new TreeMap<>();
            String str = s.substring(0, 1);
            int f = 0;
            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= 'a' && c <= 'z') {
                    str += c;
                } else if (c >= '0' && c <= '9') {
                    f = 10 * f + (c - '0');
                } else {
                    f = Math.max(f, 1);
                    int n = map.getOrDefault(str, 0);
                    map.put(str, n + f * factor);
                    f = 0;
                    str = "" + c;
                }
            }
            if (!str.isEmpty()) {
                f = Math.max(f, 1);
                int n = map.getOrDefault(str, 0);
                map.put(str, n + f * factor);
            }
            return map;
        }
    }

    private Map<String, Integer> merge(Map<String, Integer> a, Map<String, Integer> b, Map<String, Integer> c) {
        Set<String> set = new HashSet<>();
        set.addAll(b.keySet());
        set.addAll(c.keySet());
        for (String s : set) {
            int n = a.getOrDefault(s, 0) + b.getOrDefault(s, 0) + c.getOrDefault(s, 0);
            a.put(s, n);
        }
        return a;
    }

    public static void main(String[] args) {
        NumberOfAtoms noa = new NumberOfAtoms();
        noa.countOfAtoms("((N42)24(OB40Li30CHe3O48LiNN26)33(C12Li48N30H13HBe31)21(BHN30Li26BCBe47N40)15(H5)16)14");
    }
}
