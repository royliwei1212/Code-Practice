package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hzhou
 * @since 9/7/17
 */
public class ReconstructOriginalDigitsFromEnglish {

    // Zero, One, Two, Three, Four, Five, Six, Seven, Eight, Nine
    // zero      -> z
    // six       -> x
    // seven     -> s - six
    // five      -> v - seven
    // four      -> f - five
    // three     -> r - four
    // eight     -> g
    // two       -> w
    // one       -> o - two - four
    // nine      -> i - five - six - eight
    public String originalDigits(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int[] counter = new int[10];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        counter[0] = map.getOrDefault('z', 0);
        counter[6] = map.getOrDefault('x', 0);
        counter[7] = map.getOrDefault('s', 0) - counter[6];
        counter[5] = map.getOrDefault('v', 0) - counter[7];
        counter[4] = map.getOrDefault('f', 0) - counter[5];
        counter[3] = map.getOrDefault('r', 0) - counter[4] - counter[0];
        counter[8] = map.getOrDefault('g', 0);
        counter[2] = map.getOrDefault('w', 0);
        counter[1] = map.getOrDefault('o', 0) - counter[2] - counter[4] - counter[0];
        counter[9] = map.getOrDefault('i', 0) - counter[5] - counter[6] - counter[8];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            while (counter[i]-- > 0) {
                sb.append(i);
            }
        }
        return sb.toString();
    }

}
