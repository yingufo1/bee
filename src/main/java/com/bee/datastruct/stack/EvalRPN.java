package com.bee.datastruct.stack;

import java.util.Stack;

/**
 * 剑指 Offer II 036. 后缀表达式:https://leetcode.cn/problems/8Zf90G/
 *
 * @author yangying
 * @version 1.0
 * @since 2022/5/24
 **/

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack();
        int num1;
        int num2;
        for(String token:tokens){
            if(isOperator(token)){
                num1 = s.pop();
                num2 = s.pop();
                int num = 0;
                switch (token){
                    case "+":num = num2 + num1;break;
                    case "-":num = num2 - num1;break;
                    case "*":num = num2 * num1;break;
                    case "/":num = num2 / num1;break;
                }
                s.push(num);
            }else{
                s.push(Integer.parseInt(token));
            }
        }
        return s.pop();
    }

    private boolean isOperator(String token){
        return token.equals("+")||token.equals("-")||token.equals("*")||token.equals("/");
    }
}
