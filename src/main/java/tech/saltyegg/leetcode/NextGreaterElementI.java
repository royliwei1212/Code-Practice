package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {

    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> dict = new HashMap<>();
        for (int i : nums) {
            for (Map.Entry<Integer, Integer> entry : dict.entrySet()) {
                if (i > entry.getKey() && entry.getValue() == -1) {
                    dict.put(entry.getKey(), i);
                }
            }
            dict.put(i, -1);
        }
        int[] result = new int[findNums.length];
        for (int i = 0; i < findNums.length; i++) {
            result[i] = dict.get(findNums[i]);
        }
        return result;
    }

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                map.put(nums2[stack.pop()], nums2[i]);
            }
            stack.push(i);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }

        return result;
    }

}
