package tech.saltyegg.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MostFrequentlyUsedWord {

    // TODO: this list may need to be updated
    private Set<Character> punctuation = new HashSet<>(Arrays.asList(',', '.', '/', '?', '<', '>', '{', '}', '[', ']', '|', '\\', ';', ':', '\'', '\"'));

    public List<String> process(String text, List<String> wordToExclude) {
        if (text == null || text.trim().isEmpty()) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        // 转化成hash set，减少查询时间
        Set<String> dictSet = wordToExclude.stream().map(String::toLowerCase).collect(Collectors.toSet());

        int maxCount = 0;
        Map<String, Integer> counter = new HashMap<>();
        int start = 0;
        int end = 0;
        int length = text.length();
        while (start <= length) { // 时间复杂度 = O(n)
            while (start < length && isDelimiter(text.charAt(start))) {
                start++;
            }
            if (start == length) {
                break;
            }
            end = start + 1;
            while (end < length && !isDelimiter(text.charAt(end))) {
                end++;
            }

            String sub = text.substring(start, end).toLowerCase();
            if (!dictSet.contains(sub)) {
                int currentCount = counter.getOrDefault(sub, 0) + 1;
                maxCount = Math.max(maxCount, currentCount);
                counter.put(sub, currentCount);
            }
            start = end + 1;
        }

        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            if (entry.getValue() == maxCount) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    private boolean isDelimiter(char c) {
        return c == ' ' || punctuation.contains(c);
    }

    public static void main(String[] args) {
        MostFrequentlyUsedWord mfuw = new MostFrequentlyUsedWord();
        String text = "Jack and Jill went to the market to buy bread and cheese. Cheese is Jack's and Jill's favorite food.";
        List<String> toExclude = Arrays.asList("and", "he", "the", "to", "is", "Jack", "Jill");
        System.out.println(mfuw.process(text, toExclude));
    }
}
