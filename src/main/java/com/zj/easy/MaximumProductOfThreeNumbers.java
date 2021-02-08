package com.zj.easy;

import java.util.Arrays;

/**
 * @program algorithm
 * @description: 628. 三个数的最大乘积
 * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：6
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：24
 * 示例 3：
 *
 * 输入：nums = [-1,-2,-3]
 * 输出：-6
 *  
 *
 * 提示：
 *
 * 3 <= nums.length <= 104
 * -1000 <= nums[i] <= 1000
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-three-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: zhangbo
 * @create: 2021/02/08 13:35
 */
public class MaximumProductOfThreeNumbers {
    public static void main(String[] args) {
        Solution solution = new MaximumProductOfThreeNumbers().new Solution();
        int[] temp = new int[]{1,3,5,-7,2,4,-6,8};
        solution.maximumProduct(temp);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumProduct(int[] nums) {
            return helper(nums);

        }

        private int helper(int[] nums) {
            if (nums.length < 1) return Integer.MIN_VALUE;
            if (nums.length <= 3) {
                return nums.length == 2 ? nums[0] * nums[1] : nums[0] * nums[1] * nums[2];
            }

            sort(nums, 0, nums.length - 1);
            System.out.println(Arrays.toString(nums));
            int n = nums.length;
            return Math.max(nums[0]*nums[1]*nums[n - 1], nums[n - 1]*nums[n - 2]*nums[n - 3]);
        }


        private void sort(int[] nums, int left, int right, int mid) {

            int[] newNums = new int[ right - left + 1];
            int L = left;
            int R = mid + 1;
            int p = 0;

            while (L <= mid && R <= right) {
                if(nums[L] < nums[R]){
                    newNums[p++] = nums[L++];
                } else {
                    newNums[p++] = nums[R++];
                }
            }


            while (L <= mid){
                newNums[p++] = nums[L++];
            }
            while (R <= right) {
                newNums[p++] = nums[R++];
            }

            // 把新数组中的数覆盖nums数组
            for (int k2 = 0; k2 < newNums.length; k2++) {
                nums[k2 + left] = newNums[k2];
            }

        }

        private void sort(int[] arr, int left, int right){
            int mid = left + ((right - left) >> 1) ;
            if (left < right) {
                sort(arr, left, mid);
                sort(arr, mid + 1, right);
                sort(arr, left, right, mid);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
