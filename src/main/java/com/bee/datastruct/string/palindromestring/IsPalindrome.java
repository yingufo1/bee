package com.bee.datastruct.string.palindromestring;

/**
 * 剑指 Offer II 018. 有效的回文：https://leetcode.cn/problems/XltzEq/
 *
 * @author yangying
 * @version 1.0
 * @since 2022/5/22
 **/

public class IsPalindrome {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }
}
