package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Description
 *
 * @author hzhou
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 4) return result;
        Arrays.sort(nums);

        for(int i = 0; i < nums.length-3; i++){
            for(int j = i + 1; j < nums.length-2; j++){
                int sum = nums[i] + nums[j];
                int t = target-sum;
                int l = j + 1, r = nums.length -1;
                while(l < r){
                    int s = nums[l] + nums[r];
                    if(s == t) {
                        List<Integer> res = helper(i,j,l,r, nums);
                        result.add(res);
                        while(l < r &&nums[l] == res.get(2)) {l++;}
                        while(l < r &&nums[r] == res.get(3)) {r--;}
                        continue;
                    }
                    if(s > t) r--; else l++;
                }

                while(j < nums.length-2 && nums[j+1] == nums[j]) j++;
            }
            while(i < nums.length-3 && nums[i+1] == nums[i]) i++;
        }
        return result;
    }

    private List<Integer> helper(int a, int b, int i, int j, int[] nums){
        List<Integer> result = new ArrayList<>();
        result.add(nums[a]);
        result.add(nums[b]);
        result.add(nums[i]);
        result.add(nums[j]);
        return result;
    }
}