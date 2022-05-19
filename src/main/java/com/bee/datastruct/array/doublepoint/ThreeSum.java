package com.bee.datastruct.array.doublepoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/1fGaJU/
 *
 * @author yangying
 * @version 1.0.0
 * @since 1.0.0
 * 2022/5/19 10:12
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        if (nums.length >= 3) {
            Arrays.sort(nums);
            while (i < nums.length - 2) {
                twoSum(nums, i, res);
                int temp = nums[i];
                while (temp == nums[i] && i < nums.length - 1) {
                    i++;
                }
            }
        }
        return res;
    }

    /**
     * 从已排序的数字数组中找出和等于nums[i]的数字，并保存在res中
     *
     * @param sortedNums 已排序的数组
     * @param i          目标和下标
     * @param res        结果存储
     */
    private void twoSum(int[] sortedNums, int i, List<List<Integer>> res) {
        int j = i + 1;
        int k = sortedNums.length - 1;
        while (j < k) {
            if (sortedNums[j] + sortedNums[i] + sortedNums[k] == 0) {
                res.add(Arrays.asList(sortedNums[i], sortedNums[j], sortedNums[k]));
                int temp = sortedNums[j];
                while (temp == sortedNums[j] && j < k) {
                    j++;
                }
            } else if (sortedNums[j] + sortedNums[i] + sortedNums[k] > 0) {
                k--;
            } else {
                j++;
            }
        }
    }
}
