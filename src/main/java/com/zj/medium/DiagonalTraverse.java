package com.zj.medium;

import java.util.Arrays;

/**
 * @program: algorithm
 * @description: 498. 对角线遍历
 * 498. 对角线遍历
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * <p>
 * 输出:  [1,2,4,7,5,3,6,8,9]
 * <p>
 * 解释:
 * <p>
 *  
 * <p>
 * 说明:
 * <p>
 * 给定矩阵中的元素总数不会超过 100000 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diagonal-traverse
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: Zhang Bo
 * @create: 2021-03-04 12:43
 **/
public class DiagonalTraverse {
    public static void main(String[] args) {
        Solution solution = new DiagonalTraverse().new Solution();
        int[][] arr = new int[][]{
                {1, 2, 3}
        };

        System.out.println(Arrays.toString(solution.findDiagonalOrder(arr)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findDiagonalOrder(int[][] matrix) {
            return helper(matrix);
        }

        /**
         * @description: 方法一：暴力遍历
         * @param: helper
         * @return: int[]
         * @author: zhangbo
         * @date: 2021/3/4
         */
        private int[] helper(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return new int[]{};
            }
            int[] arr = new int[matrix.length * matrix[0].length];
            //true 表示斜向上循环，false 表示斜向下循环
            boolean flag = false;
            //arr的索引
            int num = 0;
            int count = matrix[0].length + matrix.length - 1;
            int r = matrix.length - 1;
            int c = matrix[0].length - 1;

            arr[num++] = matrix[0][0];
            for (int i = 1; i <= count; i++) {
                if (flag) {

                    if (i < r) {
                        for (int j = i; j >= 0; j--) {
                            arr[num++] = matrix[j][i - j];
                        }
                    } else {
                        for (int j = r; i - j <= c; j--) {
                            arr[num++] = matrix[j][i - j];
                        }
                    }
                    flag = false;
                } else {


                    if (i <= c) {
                        for (int j = 0; j <= Math.min(r,i); j++) {
                            arr[num++] = matrix[j][i - j];
                        }
                    } else {
                        for (int j = i - c; j <= r; j++) {
                            arr[num++] = matrix[j][i - j];
                        }
                    }
                    flag = true;
                }
            }

            return arr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
