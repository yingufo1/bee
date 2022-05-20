package com.bee.datastruct.array.doublepoint;

/**
 * https://leetcode.cn/problems/ZVAVXX/
 *
 * @author yangying
 * @version 1.0.0
 * @since 1.0.0 2022/5/20 10:19
 */
public class NumSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        /**
         * 双指针left和right，开始都指向起始下标0，如果两个指针之间的子数组乘积大于k，则移动left。如果子数组乘积小于等于k则移动right。知道两个指针都移动到数组尾部
         */
        int left = 0;
        int count = 0;
        long product = 1;
        for (int right = 0; right < nums.length; ++right) {
            product *= nums[right];
            while (left <= right && product >= k) {
                product /= nums[left];
                left++;
            }
            count += left <= right ? right - left + 1 : 0;
        }
        return count;
    }

    public static void main(String[] args) {
        NumSubarrayProductLessThanK numSubarrayProductLessThanK = new NumSubarrayProductLessThanK();
        int count = numSubarrayProductLessThanK.numSubarrayProductLessThanK(new int[] {10, 5, 2, 6}, 100);
        System.out.println(count);
    }
}
