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
        helper(num, target, 0, 0, "", result);
        return result;
    }

    public void helper(String num, int target, long diff, long crtNum, String out, List<String> result) {
        if (crtNum == target && num.length() == 0) {
            result.add(out);
        }

        for (int i = 1; i <= num.length(); i++) {
            String sub = num.substring(0, i);
            if (sub.length() > 1 && sub.charAt(0) == '0') return;
            long _diff = Long.valueOf(sub);
            String next = num.substring(i);
            if (out.length() > 0) {
                helper(next, target, _diff, crtNum + _diff, out + "+" + _diff, result);
                helper(next, target, -1 * _diff, crtNum - _diff, out + "-" + _diff, result);
                helper(next, target, diff * _diff, crtNum - diff + diff * _diff, out + "*" + _diff, result);
            } else {
                helper(next, target, _diff, _diff, sub, result);
            }
        }
    }

}
