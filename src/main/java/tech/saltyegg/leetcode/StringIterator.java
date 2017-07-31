package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;

public class StringIterator {

    private long cursor = 0;
    private long size = 0;
    private Map<Long, Character> map = new HashMap<>();

    public StringIterator(String compressedString) {
        char pre = ' ';
        long crt = 0;
        for (char c : compressedString.toCharArray()) {
            if (c >= '0' && c <= '9') {
                crt = 10 * crt + c - '0';
            } else {
                size += crt;
                if (pre != ' ') map.put(size, pre);
                pre = c;
                crt = 0;
            }
        }
        if (crt > 0) {
            size += crt;
            map.put(size, pre);
        }
    }

    public char next() {
        if (cursor >= size) return ' ';

        long key = map.keySet().stream()
                .filter(x -> x > cursor)
                .mapToLong(Long::longValue)
                .min()
                .orElse(0);
        cursor++;
        return map.get(key);
    }

    public boolean hasNext() {
        return cursor < size;
    }

    public static void main(String[] args) {
        StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");

        System.out.println(iterator.next()); // return 'L'
        System.out.println(iterator.next()); // return 'e'
        System.out.println(iterator.next()); // return 'e'
        System.out.println(iterator.next()); // return 't'
        System.out.println(iterator.next()); // return 'C'
        System.out.println(iterator.next()); // return 'o'
        System.out.println(iterator.next()); // return 'd'
        System.out.println(iterator.hasNext()); // return true
        System.out.println(iterator.next()); // return 'e'
        System.out.println(iterator.hasNext()); // return false
        System.out.println(iterator.next()); // return ' '
    }
}
