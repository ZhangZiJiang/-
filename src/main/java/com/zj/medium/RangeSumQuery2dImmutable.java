package com.zj.medium;

/**
 * @program algorithm
 * @description: 304. 二维区域和检索 - 矩阵不可变
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
 * <p>
 * <p>
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给定 matrix = [
 * [3, 0, 1, 4, 2],
 * [5, 6, 3, 2, 1],
 * [1, 2, 0, 1, 5],
 * [4, 1, 0, 1, 7],
 * [1, 0, 3, 0, 5]
 * ]
 * <p>
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-2d-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: zhangbo
 * @create: 2021/03/16 00:10
 */
public class RangeSumQuery2dImmutable {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};

        NumMatrix solution = new RangeSumQuery2dImmutable().new NumMatrix(matrix);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumMatrix {
        private int[][] sums;
        private int[][] matrix;

        public NumMatrix(int[][] matrix) {
            sums = new int[matrix.length][matrix[0].length];
            this.matrix = matrix;

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (i == 0 && j == 0) {
                        sums[0][0] = matrix[0][0];
                    } else if (i == 0) {
                        sums[i][j] = sums[i][j - 1] + matrix[i][j];
                    } else if (j == 0) {
                        sums[i][j] = sums[i - 1][j] + matrix[i][j];
                    } else {
                        sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + matrix[i][j];
                    }


                }

            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (row1 == 0 && col1 == 0) {
                return sums[row2][col2];
            } else if (col1 == 0) {
                return sums[row2][col2] - sums[row1 - 1][col2];
            } else if (row1 == 0) {
                return sums[row2][col2] - sums[row2][col1 - 1];
            }
            return sums[row2][col2] - sums[row1 - 1][col2] - sums[row2][col1 - 1] + sums[row1 - 1][col1 - 1];
        }


    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
