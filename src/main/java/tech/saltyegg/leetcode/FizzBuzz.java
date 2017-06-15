package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hzhou
 * @since 6/15/17
 */
public class FizzBuzz {

    public List<String> fizzBuzz(int n) {

        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 != 0) {
                result.add(String.valueOf(i));
            }
            if (i % 15 == 0) {
                result.add("FizzBuzz");
                continue;
            }
            if (i % 3 == 0) {
                result.add("Fizz");
            }
            if (i % 5 == 0) {
                result.add("Buzz");
            }
        }
        return result;
    }
}
