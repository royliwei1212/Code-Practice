package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;

public class KthSymbolInGrammar {
    private Map<Integer, String> map = new HashMap<>();

    public int kthGrammar(int N, int K) {
        if (K - 1 > Math.pow(2, N - 1)) return -1;
        String s = helper(N);
        return s.charAt(K - 1) - '0';
    }

    private String helper(int n) {
        if (n == 1) return "0";
        if (map.containsKey(n)) return map.get(n);
        String s = helper(n - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') sb.append("01");
            if (c == '1') sb.append("10");
        }
        String result = sb.toString();
        map.put(n, result);
        return result;
    }

    public int kthGrammar2(int N, int K) {
        if (N == 1 && K == 1) {
            return 0;
        }
        int quotient = K / 2;
        int reminder = K % 2;
        int sum = quotient + reminder;
        if (reminder == 1) {
            return kthGrammar(N - 1, sum);
        }
        return 1 - kthGrammar(N - 1, sum);
    }
}
