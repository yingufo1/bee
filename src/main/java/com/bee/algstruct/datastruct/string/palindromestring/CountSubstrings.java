package com.bee.algstruct.datastruct.string.palindromestring;

/**
 * 剑指 Offer II 020. 回文子字符串的个数:https://leetcode.cn/problems/a7VOhD/
 *
 * @author yangying
 * @version 1.0
 * @since 2022/5/22
 **/

public class CountSubstrings {
    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; ++i) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CountSubstrings c = new CountSubstrings();
        int ans = c.countSubstrings("aaaaa");
        System.out.println(ans);
    }
}
