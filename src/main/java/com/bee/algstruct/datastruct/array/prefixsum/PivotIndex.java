package com.bee.algstruct.datastruct.array.prefixsum;

/**
 * 剑指 Offer II 012. 左右两边子数组的和相等:https://leetcode.cn/problems/tvdfij/
 *
 * @author yangying
 * @version 1.0
 * @since 2022/5/20
 **/

public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int[] prefixSumm = new int[nums.length];
        int sum =0;
        for(int i =0;i<nums.length;i++){
            sum = nums[i] +sum;
            prefixSumm[i] = sum;
        }

        for(int i=0;i<nums.length;i++){
            if(prefixSumm[i] - nums[i] == prefixSumm[nums.length-1]-prefixSumm[i]){
                return i;
            }
        }
        return  -1;
    }
}
