package tech.saltyegg.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class NumberOfAtoms {

    public String countOfAtoms(String formula) {
        if (formula == null || formula.isEmpty()) return "";
        return helper(formula, 1);
    }

    private String helper(String s, int factor) {
        if (s == null || s.isEmpty()) return "";
        if (s.contains("(")) {
            int a = s.lastIndexOf("(");
            int b = s.indexOf(")", a);
            int i = b + 1;
            int f = 0;
            for (; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c < '0' || c > '9') break;
                f = 10 * f + (c - '0');
            }
            f = Math.max(f, 1);
            return helper(s.substring(0, a) + helper(s.substring(a + 1, b), factor * f) + s.substring(i), factor);

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
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Integer> e : map.entrySet()) {
                sb.append(e.getKey());
                if (e.getValue() > 1) sb.append(e.getValue());
            }
            return sb.toString();
        }
    }
}
