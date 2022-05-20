package com.bee.datastruct.array.prefixsum;

import java.util.HashMap;
import java.util.Map;

/**
 * 指Offer 011:https://leetcode.cn/problems/A1NYOS/
 *
 * @author yangying
 * @version 1.0.0
 * @since 1.0.0 2022/5/20 11:44
 */
public class FindMaxLength {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        int maxLength = 0;
        int sum = 0;
        sumToIndex.put(0,-1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (sumToIndex.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - sumToIndex.get(sum));
            } else {
                sumToIndex.put(sum, i);
            }
        }
        return maxLength;
    }
}
