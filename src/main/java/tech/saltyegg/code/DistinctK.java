package tech.saltyegg.code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DistinctK {

    public int distinctK(String input, int k) {
        if (input == null || input.isEmpty() || k <= 0 || input.length() < k) {
            return 0;
        }

        int length = input.length();
        Map<Character, Integer> counter = new HashMap<>();
        Set<String> set = new HashSet<>();

        int start = 0;


        for (int i = 0; i <= length - k; i++) {
            while (start < length && counter.size() < k) {
                char c = input.charAt(start);
                counter.put(c, counter.getOrDefault(c, 0) + 1);
                start++;
            }
            if (start == length && counter.size() < k) {
                break;
            }

            int virtualStart = start;
            while (virtualStart <= length && counter.size() == k) {
                set.add(input.substring(i, virtualStart));
                if (virtualStart == length) {
                    break;
                }
                char c = input.charAt(virtualStart);
                counter.put(c, counter.getOrDefault(c, 0) + 1);
                virtualStart++;
            }

            // 恢复HashMap初始状态
            for (int j = start; j <= Math.min(virtualStart, length - 1); j++) {
                decrease(counter, input.charAt(j));
            }

            decrease(counter, input.charAt(i));
        }

        // System.out.println(set);
        return set.size();
    }

    private void decrease(Map<Character, Integer> counter, char c) {
        int count = counter.get(c) - 1;
        if (count == 0) {
            counter.remove(c);
        } else {
            counter.put(c, count);
        }
    }

    public static void main(String[] args) {
        DistinctK dk = new DistinctK();
        System.out.println("======== Result =======");
        System.out.println(dk.distinctK("aaabccc", 3));
    }
}
