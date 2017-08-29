package tech.saltyegg.leetcode;

import java.util.List;

public class LongestWordInDictionaryThroughDeleting {

    public String findLongestWord(String s, List<String> d) {
        d.sort((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            } else {
                return o2.length() - o1.length();
            }
        });

        for (String str : d) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (str.charAt(count) == s.charAt(i)) {
                    count++;
                }

                if (count == str.length()) return str;
            }
        }
        return "";
    }
}
