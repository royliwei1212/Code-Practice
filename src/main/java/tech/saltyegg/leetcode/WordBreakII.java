package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Description:
 *
 * @author hzhou
 */
public class WordBreakII {

    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return result;
        }
        List<String> map[] = new ArrayList[s.length() + 1];
        map[0] = new ArrayList<String>();

        for (int i = 0; i < s.length(); i++) {
            if (map[i] == null) {
                continue;
            }

            for (String str : wordDict) {
                int l = str.length();
                int end = i + l;
                if (end > s.length()) {
                    continue;
                }

                if (s.substring(i, end).equals(str)) {
                    if (map[end] == null) {
                        map[end] = new ArrayList<>();
                    }
                    map[end].add(str);
                }
            }
        }

        if (map[s.length()] == null) {
            return result;
        }
        helper(s.length(), result, new ArrayList<>(), map);
        return result;
    }

    private void helper(int end, List<String> result, List<String> crt, List<String> map[]) {
        if (end <= 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = crt.size() - 1; i >= 0; i--) {
                String s = crt.get(i);
                sb.append(s).append(' ');
            }
            sb.deleteCharAt(sb.length() - 1);// remove end empty space
            result.add(sb.toString());
        }

        for (String s : map[end]) {
            List<String> tmp = new ArrayList<>(crt);
            tmp.add(s);
            helper(end - s.length(), result, tmp, map);
        }
    }
}