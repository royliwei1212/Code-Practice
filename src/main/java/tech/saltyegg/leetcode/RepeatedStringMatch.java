package tech.saltyegg.leetcode;

public class RepeatedStringMatch {

    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        while (sb.length() < B.length()) {
            sb.append(A);
            count++;
        }

        if (sb.indexOf(B) >= 0)
            return count;
        if (sb.append(A).indexOf(B) >= 0)
            return count + 1;
        return -1;
    }
}
