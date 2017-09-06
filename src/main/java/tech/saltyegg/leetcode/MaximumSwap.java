package tech.saltyegg.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hzhou
 * @since 9/5/17
 */
public class MaximumSwap {

    public int maximumSwap(int num) {
        Integer[] arr = new Integer[("" + num).length()];
        Integer[] nums = new Integer[arr.length];

        int copy = num;
        int i = 0;
        while (copy > 0) {
            int mod = copy % 10;
            arr[i] = mod;
            nums[arr.length - i - 1] = mod;
            i++;
            copy /= 10;
        }
        Arrays.sort(arr, Comparator.reverseOrder());

        int swapMax, toSwap;
        swapMax = toSwap = 0;

        for (i = 0; i < arr.length; i++) {
            if (!arr[i].equals(nums[i])) {
                swapMax = arr[i];
                toSwap = nums[i];
                break;
            }
        }
        if (i == arr.length) return num;

        for (i = 0; i < nums.length; i++) {
            if (nums[i].equals(toSwap)) {
                nums[i] = swapMax;
                break;
            }
        }
        for (i = nums.length - 1; i >= 0; i--) {
            if (nums[i].equals(swapMax)) {
                nums[i] = toSwap;
                break;
            }
        }
        int result = 0;
        for (int x : nums) {
            result = 10 * result + x;
        }
        return result;
    }

}
