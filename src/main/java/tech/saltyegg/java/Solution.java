package tech.saltyegg.java;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hzhou
 * @since 9/24/17
 */
public class Solution {

    public static int solution(int[] A, int[] B, int M, int X, int Y) {
        if (A == null || A.length == 0 || B == null || B.length == 0 || A.length != B.length || M <= 0 || X <= 0 || Y <= 0) {
            return 0;
        }
        Set<Integer> stoppedFloors = new HashSet<>(M);
        int peopleCount = 0;
        int weightCount = 0;
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            int b = B[i];

            if (peopleCount + 1 > X || weightCount + a > Y) {
                if (peopleCount > 0 && peopleCount <= X && weightCount > 0 && weightCount <= Y) {
                    result += stoppedFloors.size() + 1;
                    stoppedFloors.clear();
                    peopleCount = weightCount = 0;
                }
            }
            peopleCount++;
            weightCount += a;
            stoppedFloors.add(b);

        }
        if (peopleCount > 0 && peopleCount <= X && weightCount > 0 && weightCount <= Y && !stoppedFloors.isEmpty()) {
            result += stoppedFloors.size() + 1;
        }
        return result;
    }

public boolean isNumber(String s) {
    int len = s.length();
    int i = 0, e = len - 1;
    while (i <= e && Character.isWhitespace(s.charAt(i))) i++;
    if (i > len - 1) return false;
    while (e >= i && Character.isWhitespace(s.charAt(e))) e--;
    // skip leading +/-
    if (s.charAt(i) == '+' || s.charAt(i) == '-') i++;
    boolean num = false; // is a digit
    boolean dot = false; // is a '.'
    boolean exp = false; // is a 'e'
    while (i <= e) {
        char c = s.charAt(i);
        if (Character.isDigit(c)) {
            num = true;
        } else if (c == '.') {
            if (exp || dot) return false;
            dot = true;
        } else if (c == 'e') {
            if (exp || !num) return false;
            exp = true;
            num = false;
        } else if (c == '+' || c == '-') {
            if (s.charAt(i - 1) != 'e') return false;
        } else {
            return false;
        }
        i++;
    }
    return num;
}

    public static void main(String[] args) {
        System.out.println(solution(new int[]{60, 80, 40}, new int[]{2, 3, 5}, 5, 2, 200));
    }
}
