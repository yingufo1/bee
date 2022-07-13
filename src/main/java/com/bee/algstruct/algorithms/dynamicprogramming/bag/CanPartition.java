package com.bee.algstruct.algorithms.dynamicprogramming.bag;/** * 剑指 Offer II 101. 分割等和子集:https://leetcode.cn/problems/NUPfPr/ * * @author yangying * @version 1.0 * @since 2022/6/5 **/public class CanPartition {    public boolean canPartition(int[] nums) {        int n = nums.length;        if (n < 2) {            return false;        }        int sum = 0, maxNum = 0;        for (int num : nums) {            sum += num;            maxNum = Math.max(maxNum, num);        }        if (sum % 2 != 0) {            return false;        }        int target = sum / 2;        if (maxNum > target) {            return false;        }        boolean[] dp = new boolean[target + 1];        dp[0] = true;        for (int num : nums) {            for (int j = target; j >= num; --j) {                dp[j] |= dp[j - num];            }        }        return dp[target];    }}