package com.bee.algorithms.dynamicprogramming.doubleseq;/** * 剑指 Offer II 095. 最长公共子序列:https://leetcode.cn/problems/qJnOS7/ * * @author yangying * @version 1.0 * @since 2022/6/3 **/public class LongestCommonSubsequence {    public int longestCommonSubsequence(String text1, String text2) {        int m = text1.length();        int n = text2.length();        int[][] dp = new int[m + 1][n + 1];        for (int i = 0; i < m; i++) {            for (int j = 0; j < n; j++) {                 if(text1.charAt(i) == text2.charAt(j)){                     dp[i+1][j+1] = dp[i][j]+1;                 }else {                     dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);                 }            }        }        return dp[m][n];    }}