package tech.saltyegg.leetcode;

public class SentenceScreenFitting {

    // TLE
    public int wordsTyping(String[] sentence, int rows, int cols) {

        int[] nums = new int[sentence.length];
        for (int i = 0; i < sentence.length; i++) nums[i] = sentence[i].length();

        int line = 1, count = 0, tmp = 0;

        while (line <= rows) {
            while (cols >= tmp) {
                if (tmp != 0) tmp += 1;
                tmp += nums[count % nums.length];
                count++;
            }
            count--;
            tmp = 0;
            line++;
        }
        return count / nums.length;
    }

    public int wordsTyping2(String[] sentence, int rows, int cols) {
        StringBuilder sb = new StringBuilder();
        for (String s : sentence) sb.append(s).append(" ");
        int start = 0, len = sb.length();

        for (int i = 0; i < rows; i++) {
            start += cols;
            if (sb.charAt(start % len) == ' ') {
                start++;
            } else {
                while (start > 0 && sb.charAt((start - 1) % len) != ' ') {
                    start--;
                }
            }
        }
        return start / len;
    }

}
