package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length < 2) {
            return result;
        }
        for (int i : nums) {
            if (nums[Math.abs(i) - 1] > 0) {
                nums[Math.abs(i) - 1] = -nums[Math.abs(i) - 1];
            } else {
                result.add(Math.abs(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindAllDuplicatesInAnArray f = new FindAllDuplicatesInAnArray();
        List<Integer> result = f.findDuplicates(new int[]{4, 3, 2, 7, 7, 2, 3, 1});
    }

}
