package tech.saltyegg.leetcode;

public class StringIterator {

    private int cursor = 0;
    private StringBuilder value = new StringBuilder();

    public StringIterator(String compressedString) {
        char pre = ' ';
        int crt = 0;
        for (char c : compressedString.toCharArray()) {
            if (c >= '0' && c <= '9') {
                crt = 10 * crt + c - '0';
            } else {
                while (crt > 0) {
                    value.append(pre);
                    crt--;
                }
                pre = c;
            }
        }
        while (crt > 0) {
            value.append(pre);
            crt--;
        }
    }

    public char next() {
        if (cursor >= value.length()) return ' ';

        return value.charAt(cursor++);
    }

    public boolean hasNext() {
        return cursor < value.length();
    }
}
