package tech.saltyegg.code;

import org.junit.Test;

public class StringParse {

    public String solution(String s) {
        if (s == null || s.isEmpty()) return s;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!(c == ' ' || c == '-')) {

                sb.append(c);

            }
        }
        return sb.toString();

    }

    @Test
    public void test() {
        System.out.println(solution("1  90-5454   -54"));
        System.out.println(solution("1  90-5454   -547"));
        System.out.println(solution("1  90-54  0 -54   -547"));
        System.out.println(solution("431  90-54  0 -54   -547"));
    }
}
