package tech.saltyegg.leetcode;

import java.util.HashSet;
import java.util.Set;

public class CrackingTheSafe {

    public String crackSafe(int n, int k) {
        int SIZE = (int) Math.pow(k, n);
        StringBuilder sb = new StringBuilder();
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < n; i++) sb.append('0');
        visited.add(sb.toString());
        helper(sb, visited, SIZE, n, k);

        return sb.toString();
    }

    private boolean helper(StringBuilder sb, Set<String> visited, int t, int n, int k) {
        if (t == visited.size()) return true;

        String prev = sb.substring(sb.length() - n + 1);
        for (int i = 0; i < k; i++) {
            String next = prev + i;
            if (visited.contains(next)) continue;
            sb.append(i);
            visited.add(next);
            if (helper(sb, visited, t, n, k)) {
                return true;
            }
            sb.deleteCharAt(sb.length() - 1);
            visited.remove(next);
        }
        return false;
    }
}
