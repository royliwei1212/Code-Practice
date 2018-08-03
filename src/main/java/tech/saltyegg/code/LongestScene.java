package tech.saltyegg.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestScene {

    public int process(String input) {
        if (input == null || input.length() < 2) {
            return 0;
        }

        int result = 0;
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            List<Integer> list = map.getOrDefault(c, new ArrayList<>());
            list.add(i);
            map.put(c, list);
        }

        Map<Character, List<Integer>> dict = new HashMap<>();
        //清理出现次数少于2的字符
        map.entrySet().stream()
                .filter(e -> e.getValue().size() > 1)
                .forEach(e -> dict.put(e.getKey(), e.getValue()));

        for (Map.Entry<Character, List<Integer>> entry : dict.entrySet()) {
            List<Integer> list = entry.getValue();
            for (int i = 0; i < list.size() - 1; i++) {
                int start = list.get(i);
                int end = list.get(i + 1);
                result = Math.max(result, end - start + 1);
                // 查看有没有overlap
                for (int k = start + 1; k < end; k++) {
                    char c = input.charAt(k);
                    if (!dict.containsKey(c)) {
                        continue;
                    }

                    int index = getIndex(dict.get(c), k);
                    List<Integer> kList = dict.get(c);
                    // 如果当前字符前一个位子出现在start之前
                    if (index > 0 && kList.get(index - 1) < start) {
                        result = Math.max(result, end - kList.get(index - 1) + 1);
                    }
                    // 如果当前字符后一个位子出现在end之后
                    if (index < kList.size() - 1 && kList.get(index + 1) > end) {
                        result = Math.max(result, kList.get(index + 1) - start + 1);
                    }
                }
            }
        }

        return result;
    }

    private int getIndex(List<Integer> list, int val) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == val) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LongestScene ls = new LongestScene();
        System.out.println(ls.process("acafghbeb"));
        System.out.println(ls.process("abcab"));
        System.out.println(ls.process("abceewabc"));
    }

}
