package tech.saltyegg.leetcode;

import java.util.Set;

/**
 * Description: Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 * <p/>
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * <p/>
 * Return true because "leetcode" can be segmented as "leet code".
 *
 * @author hzhou
 */
public class WordBreak {

    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.isEmpty()) return true;
        if (wordDict == null || wordDict.isEmpty()) return false;

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            if (!dp[i]) continue;
            String sub = s.substring(i);
            for (String w : wordDict) {
                if (sub.length() < w.length() || dp[i + w.length()]) continue;
                if (sub.startsWith(w)) dp[i + w.length()] = true;
            }
        }
        return dp[s.length()];
    }
}