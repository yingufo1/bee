package com.bee.datastruct.array.prefixsum;

/**
 * 剑指 Offer II 013. 二维子矩阵的和:https://leetcode.cn/problems/O4NDxx/
 *
 * @author yangying
 * @version 1.0
 * @since 2022/5/20
 **/

public class NumMatrix {
    private int[][] sumMatrix;

    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        sumMatrix = new int[row][col+1];
        for (int i = 0; i < row; i++) {
            int sum = 0;
            for (int j = 0; j < col; j++) {
                sum = sum + matrix[i][j];
                sumMatrix[i][j+1] = sum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <=row2; i++) {
            sum = sumMatrix[i][col2+1] - sumMatrix[i][col1]+ sum;
        }

        return sum;
    }
}
