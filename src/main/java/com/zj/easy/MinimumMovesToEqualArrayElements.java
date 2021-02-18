package com.zj.easy;

/**
 * @program algorithm
 * @description: 453. 最小操作次数使数组元素相等
 * 给定一个长度为 n 的 非空 整数数组，每次操作将会使 n - 1 个元素增加 1。找出让数组所有元素相等的最小操作次数。
 *
 *  
 *
 * 示例：
 *
 * 输入：
 * [1,2,3]
 * 输出：
 * 3
 * 解释：
 * 只需要3次操作（注意每次操作会增加两个元素的值）：
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: zhangbo
 * @create: 2021/02/18 11:19
 */
public class MinimumMovesToEqualArrayElements {
    public static void main(String[] args) {
        Solution solution = new MinimumMovesToEqualArrayElements().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minMoves(int[] nums) {
            return helper(nums);
        }

        /**
         * 动态规划
         * @param nums
         * @return
         */
        private int helper(int[] nums) {
            int moves = 0, min = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                min = Math.min(min, nums[i]);
            }
            for (int i = 0; i < nums.length; i++) {
                moves += nums[i] - min;
            }
            return moves;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}