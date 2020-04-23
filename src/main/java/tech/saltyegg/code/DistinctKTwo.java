package tech.saltyegg.code;

import java.util.HashSet;
import java.util.Set;

public class DistinctKTwo {

    public static int process(String input, int k) {
        if (input == null || input.isEmpty() || k > input.length()) {
            return 0;
        }
        int result = 0;

        for (int i = 0; i <= input.length() - k; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < i + k && j < input.length(); j++) {
                set.add(input.charAt(j));
            }
            if (set.size() == k - 1) {
                System.out.println(input.substring(i, i + k));
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(process("aabcasdsadasdff", 2));
    }
}
