package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hzhou
 * @since 9/4/17
 */
public class ExpressionAddOperators {

    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.isEmpty()) return result;
        helper(num, target, 0L, 0L, "", result);
        return result;
    }

    private void helper(String num, int target, long sum, long lastNum, String out, List<String> result) {
        if (target == sum && num.length() == 0) {
            result.add(out);
            return;
        }

        for (int i = 1; i <= num.length(); i++) {
            String sub = num.substring(0, i);
            if (sub.length() > 1 && sub.charAt(0) == '0') continue;
            long crtNum = Long.valueOf(sub);
            String leftNum = num.substring(i);
            if (!out.isEmpty()) {
                helper(leftNum, target, sum + crtNum, crtNum, out + "+" + crtNum, result);
                helper(leftNum, target, sum - crtNum, -crtNum, out + "-" + crtNum, result);
                helper(leftNum, target, sum - lastNum + lastNum * crtNum, lastNum * crtNum, out + "*" + crtNum, result);
            } else {
                helper(leftNum, target, crtNum, crtNum, sub, result);
            }
        }
    }

}
