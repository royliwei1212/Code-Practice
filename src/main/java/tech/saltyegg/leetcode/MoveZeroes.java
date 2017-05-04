package tech.saltyegg.leetcode;

/**
 * Created by hzhou on 2016/5/24.
 * Email: i@hzhou.me
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int firstZero = getFirstZeroIndex(-1, nums);
        int firstNonZero = getFirstNonZeroIndex(-1, nums);
        while (firstNonZero != nums.length) {
            if (firstNonZero > firstZero) {
                nums[firstZero] = nums[firstNonZero];
                nums[firstNonZero] = 0;
                firstZero = getFirstZeroIndex(firstZero, nums);
            }
            firstNonZero = getFirstNonZeroIndex(firstZero, nums);
        }
    }

    private int getFirstZeroIndex(int start, int[] nums) {
        for (int i = start + 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                return i;
            }
        }
        return nums.length;
    }

    private int getFirstNonZeroIndex(int start, int[] nums) {
        for (int i = start + 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        MoveZeroes mz = new MoveZeroes();
        mz.moveZeroes(new int[]{0, 1, 0, 3, 12});
    }

}
