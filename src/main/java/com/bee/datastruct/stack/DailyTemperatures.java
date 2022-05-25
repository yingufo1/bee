package com.bee.datastruct.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 剑指 Offer II 038. 每日温度:https://leetcode.cn/problems/iIQa4I/
 *
 * @author yangying
 * @version 1.0
 * @since 2022/5/24
 * [73,74,75,71,69,72,76,73]
 **/

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            System.out.println(i+","+temperatures[i]+","+(s.isEmpty()?-1:s.peek()));
            while (!s.isEmpty() && temperatures[i]>temperatures[s.peek()] ) {
                int j = s.pop();
                ans[j] = i - j;
            }
            s.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        DailyTemperatures d = new DailyTemperatures();
        d.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
    }
}
