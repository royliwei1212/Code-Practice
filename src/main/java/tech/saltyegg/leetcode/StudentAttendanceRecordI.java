package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 7/11/17
 */
public class StudentAttendanceRecordI {

    public boolean checkRecord(String s) {
        char[] chars = s.toCharArray();

        int a = 0;
        for (Character c : chars) {
            if (c == 'A') {
                a++;
                if (a > 1) {
                    return false;
                }
            }
        }

        if (chars.length < 3) return true;

        for (int i = 1; i < chars.length - 1; i++) {
            if (chars[i - 1] == 'L' && chars[i] == 'L' && chars[i + 1] == 'L') {
                return false;
            }
        }
        return true;
    }

}
