package com.zj.medium;

import java.util.Arrays;

/**
 * @program: algorithm
 * @description: 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：[[1]]
 * @author: Zhang Bo
 * @create: 2021-03-03 12:54
 **/
public class SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
        System.out.println(Arrays.deepToString(solution.generateMatrix(3)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            return helper(n);

        }

        private int[][] helper(int n) {
            int[][] arr = new int[n][n];
            int num = 1;
            int r = 0;
            int c = 0;
            /**
             * 第一次
             * r = 0
             * c = 1
             */
            while (true){
                for (; r < n - c; r++) {
                    arr[c][r] = num++;
                }
                c++;
                r--;
                //r=2

                for (; c < n; c++) {
                    arr[c][r] = num++;
                }
                r--;
                //c=2

                for (; r >= n - c; r--) {
                    arr[c][r] = num++;
                }
                c--;
                //r=0

                for (; c >= n - r; c--) {
                    arr[c][0] = num++;
                }
                r++;
                //c=1
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
