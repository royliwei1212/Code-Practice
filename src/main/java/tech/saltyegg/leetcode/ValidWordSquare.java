package tech.saltyegg.leetcode;

import java.util.List;

public class ValidWordSquare {

    public boolean validWordSquare(List<String> words) {
        if (words == null || words.isEmpty() || (words.size() == 1 && words.get(0).length() == 1)) return true;
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.get(i).length(); j++) {
                if (j >= words.size() || i >= words.get(j).length() || words.get(i).charAt(j) != words.get(j).charAt(i)) {
                    return false;
                }
            }

        }
        return true;
    }
}
