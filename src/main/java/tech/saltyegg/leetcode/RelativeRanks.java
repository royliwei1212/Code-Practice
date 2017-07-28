package tech.saltyegg.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RelativeRanks {

    public String[] findRelativeRanks(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);
        int rank = nums.length;
        Map<Integer, Integer> orderMap = new HashMap<>();
        for (int i : arr) {
            orderMap.put(i, rank--);
        }

        String[] result = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (orderMap.get(n) == 1) {
                result[i] = "Gold Medal";
            } else if (orderMap.get(n) == 2) {
                result[i] = "Silver Medal";

            } else if (orderMap.get(n) == 3) {
                result[i] = "Bronze Medal";
            } else {
                result[i] = orderMap.get(n) + "";
            }

        }

        return result;
    }

}
