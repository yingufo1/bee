package com.bee.algorithms.dynamicprogramming;/** * 剑指 Offer II 088. 爬楼梯的最少成本:https://leetcode.cn/problems/GzCJIP/ * * @author yangying * @version 1.0 * @since 2022/6/2 **/public class MinCostClimbingStairs {    public int minCostClimbingStairs(int[] cost) {        int n = cost.length;        int[] dp = new int[n+1];        dp[0] = dp[1] = cost[0];        for(int i=2;i<=n;i++){            dp[i] = Math.min(dp[i-1]+cost[i-1] , dp[i-2]+cost[i]);        }        return dp[n];    }}