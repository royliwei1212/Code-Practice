package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hzhou on 2016/5/11.
 */
public class IntegerToEnglishWords {
    private final Map<Integer, String> map;
    private final String[] list;

    public IntegerToEnglishWords() {
        map = new HashMap<>();
        map.put(0, "Zero");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
        list = new String[]{" Billion ", " Million ", " Thousand ", ""};
    }

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        int i = 3;
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int n = num % 1000;
            String s = hundredToString(n);
            if (!s.isEmpty()) {
                s += list[i];
                sb.insert(0, s);
            }
            i--;
            num /= 1000;
        }
        return sb.toString().trim();
    }

    private String hundredToString(int n) {
        if (n == 0) return "";
        StringBuilder sb = new StringBuilder();
        int x = n / 100;
        if (x > 0) {
            sb.append(map.get(x)).append(" Hundred");
        }
        int y = (n - x * 100);
        if (y == 0) return sb.toString();
        if (y <= 20 || y % 10 == 0) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(map.get(y));
        } else {
            if (sb.length() > 0) sb.append(" ");
            sb.append(map.get(y - n % 10)).append(" ").append(map.get(n % 10));
        }
        return sb.toString();
    }
}
