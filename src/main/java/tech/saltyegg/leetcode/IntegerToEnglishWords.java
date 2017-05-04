package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hzhou on 2016/5/11.
 * Email: i@hzhou.me
 */
public class IntegerToEnglishWords {
    private static final Map<Integer, String> intMap = new HashMap<>();
    private static final List<String> list = new ArrayList<>();

    static {
        intMap.put(0, "Zero");
        intMap.put(1, "One");
        intMap.put(2, "Two");
        intMap.put(3, "Three");
        intMap.put(4, "Four");
        intMap.put(5, "Five");
        intMap.put(6, "Six");
        intMap.put(7, "Seven");
        intMap.put(8, "Eight");
        intMap.put(9, "Nine");
        intMap.put(10, "Ten");
        intMap.put(11, "Eleven");
        intMap.put(12, "Twelve");
        intMap.put(13, "Thirteen");
        intMap.put(14, "Fourteen");
        intMap.put(15, "Fifteen");
        intMap.put(16, "Sixteen");
        intMap.put(17, "Seventeen");
        intMap.put(18, "Eighteen");
        intMap.put(19, "Nineteen");
        intMap.put(20, "Twenty");
        intMap.put(30, "Thirty");
        intMap.put(40, "Forty");
        intMap.put(50, "Fifty");
        intMap.put(60, "Sixty");
        intMap.put(70, "Seventy");
        intMap.put(80, "Eighty");
        intMap.put(90, "Ninety");

        list.add("");
        list.add("Thousand");
        list.add("Million");
        list.add("Billion");
    }

    public String numberToWords(int num) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (num > 0) {
            int n = num % 1000;
            sb.insert(0, toStr(n, index));
            num = num / 1000;
            index++;
        }

        return sb.length() == 0 ? "Zero" : sb.toString().replace("  "," ").trim();
    }

    // num < 1000
    private String toStr(int num, int index) {
        if (num == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int n = num / 100;
        if (n > 0) {
            sb.append(intMap.get(n)).append(" Hundred ");
        }

        num = num % 100;
        n = num / 10;
        if (n == 1) {
            sb.append(intMap.get(num));
        } else {
            if (n != 0) {
                sb.append(intMap.get(n * 10));
            }
            n = num % 10;
            if (n != 0) {
                sb.append(" ").append(intMap.get(n));
            }
        }
        sb.append(" ").append(list.get(index)).append(" ");
        return sb.toString();
    }


    public static void main(String[] args) {
        IntegerToEnglishWords itew = new IntegerToEnglishWords();
        System.out.println(itew.toStr(0, 0));
        System.out.println(itew.toStr(100, 0));
        System.out.println(itew.toStr(109, 0));
        System.out.println(itew.toStr(9, 1));
        System.out.println(itew.toStr(999, 0));

        System.out.println(itew.numberToWords(50868));
        System.out.println(itew.numberToWords(1234567));
    }
}
