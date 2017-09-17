package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm
 * should run in linear time and in O(1) space.
 *
 * @author hzhou
 */
public class MajorityElementII {

	public List<Integer> majorityElement(int[] nums) {
        int a, b, ca, cb;
        a = b = ca = cb = 0;
        for (int n : nums) {
            if(n == a) ca++;
			else if (n == b) cb++;
			else if(ca == 0) {a = n;ca++;}
			else if(cb == 0) {b = n;cb++;}
			else {ca--;cb--;}
		}

        ca = cb = 0;
        for (int n : nums) {
            if (n == a) ca++;
            else if (n == b) cb++;
        }
        List<Integer> result = new ArrayList<>();
        if (ca > nums.length / 3) result.add(a);
        if (cb > nums.length / 3) result.add(b);
        return result;
    }

}