package com.bee.algorithms.search.binary;import java.util.Random;/** * 剑指 Offer II 071. 按权重生成随机数：https://leetcode.cn/problems/cuyjEf/ * * @author yangying * @version 1.0 * @since 2022/5/30 **/public class PickIndex {    private int[] sums;    private int total;    public PickIndex(int[] w) {        sums = new int[w.length];        for (int i = 0; i < w.length; ++i) {            total += w[i];            sums[i] = total;        }    }    public int pickIndex() {        Random random = new Random();        int p = random.nextInt(total);        int left = 0;        int right = sums.length;        while (left <= right) {            int mid = (left + right) / 2;            if (sums[mid] > p) {                if (mid == 0 || (sums[mid - 1] <= p)) {                    return mid;                }                right = mid - 1;            } else {                left = mid + 1;            }        }        return -1;    }}/** * Your Solution object will be instantiated and called as such: * Solution obj = new Solution(w); * int param_1 = obj.pickIndex(); */