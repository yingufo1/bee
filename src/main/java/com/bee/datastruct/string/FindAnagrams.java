package com.bee.datastruct.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer II 015. 字符串中的所有变位词：https://leetcode.cn/problems/VabMRr/
 *
 * @author yangying
 * @version 1.0
 * @since 2022/5/21
 **/

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        if (m > n) {
            return res;
        }

        int[] cnts = new int[26];
        int[] cntp = new int[26];
        for (int i = 0; i < m; i++) {
            ++cntp[p.charAt(i) - 'a'];
            ++cnts[s.charAt(i) - 'a'];
        }

        if (Arrays.equals(cntp, cnts)) {
            res.add(0);
        }

        for (int i = m; i < n; i++) {
            ++cnts[s.charAt(i) - 'a'];
            --cnts[s.charAt(i - m) - 'a'];
            if (Arrays.equals(cntp, cnts)) {
                res.add(i - m + 1);
            }
        }
        return res;
    }

}
