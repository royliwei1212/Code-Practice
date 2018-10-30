package tech.saltyegg.leetcode;

public class SentenceScreenFitting {

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

}
