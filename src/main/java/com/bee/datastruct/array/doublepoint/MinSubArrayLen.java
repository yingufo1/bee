package com.bee.datastruct.array.doublepoint;

/**
 * https://leetcode.cn/problems/2VG8Kg/
 *
 * @author yangying
 * @version 1.0.0
 * @since 1.0.0 2022/5/19 14:13
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (left <= right && sum >= target) {
                minLen = Math.min(right - left + 1, minLen);
                sum -= nums[left++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
        int minLen = minSubArrayLen.minSubArrayLen(7, new int[] {2, 3, 1, 2, 4, 3});
        System.out.println(minLen);
    }
}
