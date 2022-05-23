package com.bee.datastruct.string;

import java.util.Arrays;

/**
 * 剑指 Offer II 014. 字符串中的变位词:https://leetcode.cn/problems/MPnaiL/
 *
 * @author yangying
 * @version 1.0
 * @since 2022/5/21
 **/

public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n < m) {
            return false;
        }
        int[] cnt1 = new int[26];//代表s1在26个小写字母中每个字母出现次数
        int[] cnt2 = new int[26];//代表s2中与s1相同长度的子串在26个小写字母表中每个字母出现次数

        for (int i = 0; i < n; i++) {
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }

        for (int i = n; i < m; i++) {
            --cnt2[s2.charAt(i - n) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }
}
