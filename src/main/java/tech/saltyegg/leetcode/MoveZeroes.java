package tech.saltyegg.leetcode;

/**
 * Created by hzhou on 2016/5/24.
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int z, nz;
        z = nz = 0;
        while (z < nums.length && nz < nums.length) {
            while (z < nums.length && nums[z] != 0) z++;
            while (nz < nums.length && nums[nz] == 0) nz++;
            if (z < nums.length && nz < nums.length && z < nz) {
                swap(z, nz, nums);
                z++;
            }
            nz++;
        }
    }

    private void swap(int a, int b, int[] nums) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    public static void main(String[] args) {
        MoveZeroes mz = new MoveZeroes();
        mz.moveZeroes(new int[]{1, 0});
    }

}
