package com.bee.algstruct.datastruct.stack;

import java.util.Stack;

/**
 * 剑指 Offer II 037. 小行星碰撞:https://leetcode.cn/problems/XagZNi/
 *
 * @author yangying
 * @version 1.0
 * @since 2022/5/24
 **/

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        for (int asteroid : asteroids) {
            if (s.isEmpty()||isSameDirect(asteroid,s.peek())){
                s.push(asteroid);
            }else {
                while (!s.isEmpty()&&Math.abs(s.peek())<Math.abs(asteroid)){
                    s.pop();
                }

                if(s.isEmpty()){
                    s.push(asteroid);
                }

                if(!s.isEmpty()&&Math.abs(s.peek())==Math.abs(asteroid)){
                    s.pop();
                }
            }
        }
        int[] ans = new int[s.size()];
        for(int i=s.size()-1;i>=0;i--){
            ans[i] = s.pop();
        }
        return ans;
    }

    private boolean isSameDirect(int a1, int a2) {
        //return a1 > 0 && a2 > 0 || a1 < 0 && a2 < 0;
        return a1*a2>0;
    }
}
