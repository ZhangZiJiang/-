package com.zj.medium;

import java.util.Arrays;

/**
 * @program algorithm
 * @description: 396. 旋转函数
 * 给定一个长度为 n 的整数数组 A 。
 *
 * 假设 Bk 是数组 A 顺时针旋转 k 个位置后的数组，我们定义 A 的“旋转函数” F 为：
 *
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1]。
 *
 * 计算F(0), F(1), ..., F(n-1)中的最大值。
 *
 * 注意:
 * 可以认为 n 的值小于 105。
 *
 * 示例:
 *
 * A = [4, 3, 2, 6]
 *
 * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
 *
 * 所以 F(0), F(1), F(2), F(3) 中的最大值是 F(3) = 26 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-function
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: zhangbo
 * @create: 2021/03/01 22:14
 */
public class RotateFunction{
    public static void main(String[] args) {
        Solution solution = new RotateFunction().new Solution();
        int[] A = new int[]{4,3,2,6};
        System.out.println(solution.maxRotateFunction(A));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxRotateFunction(int[] A) {
            return helper(A);
        }

        private int helper(int[] A){
            if(A.length == 0){
                return 0;
            }
            int count = A.length;

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < count; i++) {
                int sum = 0;
                for (int j = count - 1; j > 0; j--) {
                    int temp = A[j];
                    A[j] = A[j - 1];
                    A[j - 1] = temp;
                    sum += (A[j] * j);
                }
                if(max < sum){
                    max = sum;
                }
            }

            return max;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
