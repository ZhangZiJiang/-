package com.zj.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: algorithm
 * @description: 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: Zhang Bo
 * @create: 2021-03-02 12:58
 **/
public class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            return helper(matrix);
        }

        private List<Integer> helper(int[][] matrix) {
            List<Integer> ret = new ArrayList<>();
            int rowMax = matrix[0].length - 1;
            int cellMax = matrix.length - 1;
            int rowMin = 0;
            int cellMin = 0;

            //行指针
            int r = 0;
            //列指针
            int c = 0;

            while (rowMax == rowMin || cellMax == cellMin) {
                //行，从左向右
                while (r <= rowMax) {
                    ret.add(matrix[r][rowMin]);
                    r++;
                }
                rowMin++;

                //列，从上向下
                while (c <= cellMax) {
                    ret.add(matrix[rowMin][c]);
                    c++;
                }
                rowMin++;


                //行，从右向左
                while (r >= rowMin) {
                    ret.add(matrix[r][rowMax]);
                    r--;
                }
                rowMax--;

                //列，从下向上
                while (c >= cellMin) {
                    ret.add(matrix[rowMax][c]);
                }
                cellMax--;
            }

            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
