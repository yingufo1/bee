package com.bee.algstruct.datastruct.array.doublepoint;

/**
 * https://leetcode.cn/problems/two-sum/
 *
 * @author yangying
 * @version 1.0.0
 * @since 1.0.0
 * 2022/5/19 10:11
 */
public class TwoSum {
    public int[] towSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0, j = 1; j < nums.length; j++) {
            if (nums[i] + nums[j] == target) {
                result[0] = i;
                result[j] = j;
                break;
            } else if (j == nums.length - 1) {
                i++;
                j = i;
            }
        }
        return result;
    }
}
