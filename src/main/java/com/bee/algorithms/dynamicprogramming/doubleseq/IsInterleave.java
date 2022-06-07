package com.bee.algorithms.dynamicprogramming.doubleseq;/** * 剑指 Offer II 096. 字符串交织:https://leetcode.cn/problems/IY6buf/ * * @author yangying * @version 1.0 * @since 2022/6/3 **/public class IsInterleave {    public boolean isInterleave(String s1, String s2, String s3) {        int m = s1.length();        int n = s2.length();        if (s3.length() != m + n) {            return false;        }        int[][] dp = new int[m + 1][n + 1];        for (int i = 0; i < m; i++) {            for (int j = 0; j < n; j++) {                if(s1.charAt(i+1) == s3.charAt(i+j+2)&&s1.charAt(i+1) == s2.charAt(i+2)){                    dp[i+1][j] = 1;                    dp[i][j+1] = 1;                }                if(s1.charAt(i+1) == s3.charAt(i+j+2)){                    dp[i+1][j] = 1;                }                if(s1.charAt(j+1) == s3.charAt(i+j+2)){                    dp[i][j+1] = 1;                }            }        }        return dp[m + 1][n + 1] ==1;    }}