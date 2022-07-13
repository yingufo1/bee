package com.bee.algstruct.algorithms.dynamicprogramming.singleseq;/** * 剑指 Offer II 091. 粉刷房子：https://leetcode.cn/problems/JEj789/ * * @author yangying * @version 1.0 * @since 2022/6/2 **/public class MinCost {    /**     * 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2]表示第 1 号房子粉刷成绿色的花费，以此类推。     * <p>     * 请计算出粉刷完所有房子最少的花费成本。     * <p>     * 输入: costs = [[17,2,17],[16,16,5],[14,3,19]]     * 输出: 10     *     * @param costs     * @return     */    public int minCost(int[][] costs) {        int n = costs.length;        int[][] dp = new int[n][3];        dp[0] = costs[0];        for (int i = 1; i < n; i++) {            int min = 0;            for (int j = 0; j < 3; j++) {                if (j == 0) {                    min = Math.min(dp[i - 1][1], dp[i - 1][2]);                } else if (j == 1) {                    min = Math.min(dp[i - 1][0], dp[i - 1][2]);                } else {                    min = Math.min(dp[i - 1][0], dp[i - 1][1]);                }                dp[i][j] = costs[i][j] + min;            }        }        int min = Math.min(dp[n - 1][0], dp[n - 1][1]);        min = Math.min(min, dp[n - 1][2]);        return min;    }}