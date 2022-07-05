package com.bee.datastruct.array.prefixsum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 剑指Offer 010:https://leetcode.cn/problems/QTMn0o/
 *
 * @author yangying
 * @version 1.0.0
 * @since 1.0.0 2022/5/20 11:18
 */
public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        // 保存连续数组之和出现的次数，key是连续数组之和，value是次数
        Map<Integer, Integer> sumToCount = new HashMap<>();
        int count = 0;
        sumToCount.put(0, 1);
        int sum = 0;
        for (int num : nums) {
            sum += num;
            count += sumToCount.getOrDefault(sum - k, 0);
            sumToCount.put(sum, sumToCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
