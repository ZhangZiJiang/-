package com.zj.medium;

import java.util.Arrays;

/**
 * @program algorithm
 * @description: 238. 除自身以外数组的乘积
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *  
 * <p>
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 * <p>
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: zhangbo
 * @create: 2021/03/17 23:51
 */
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Solution solution = new ProductOfArrayExceptSelf().new Solution();
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(solution.productExceptSelf(nums)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            return helper(nums);
        }

        private int[] helper(int[] nums) {

            int length = nums.length;
            if (length == 0) {
                return new int[0];
            }

            int[] muls = new int[length];
            muls[0] = 1;

            for (int i = 1; i < length; i++) {
                muls[i] = muls[i - 1] * nums[i - 1];
            }

            int after = 1;
            for (int i = length - 2; i >= 0; i--) {
                after = after * nums[i + 1];
                muls[i] = muls[i] * after;
            }

            return muls;

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
