package com.bee.others;

import java.util.Queue;

/**
 * //TODO：文件描述
 *
 * @author yangying
 * @version 1.0.0
 * @since 1.0.0
 * 2022/6/20 17:24
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int dp = nums[0];
        int pre =0;
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            dp = Math.max(pre, dp);
        }

        return dp;
    }
}