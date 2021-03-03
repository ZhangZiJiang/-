package com.zj.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: algorithm
 * @description: 59. 螺旋矩阵 II
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
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
            int l = 0;
            int r = arr[0].length - 1;
            int u = 0;
            int d = arr.length - 1;
            while (l <= r && u <= d) {
                for (int i = l; i <= r; i++) {
                    arr[u][i] = num++;
                }
                u++;
                for (int i = u; i <= d; i++) {
                    arr[i][r] = num++;
                }
                r--;
                for (int i = r; i >= l && u <= d; i--) {
                    arr[d][i] = num++;
                }
                d--;
                for (int i = d; i >= u && l <= r; i--) {
                    arr[i][l] = num++;
                }
                l++;
            }
            return arr;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
