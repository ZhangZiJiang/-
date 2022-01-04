package com.zj.easy;

/**
 * @program algorithm
 * @description: 665. 非递减数列
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中任意的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 示例 2:
 *
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 *  
 *
 * 提示：
 *
 * 1 <= n <= 10 ^ 4
 * - 10 ^ 5 <= nums[i] <= 10 ^ 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-decreasing-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: zhangbo
 * @create: 2021/02/19 10:01
 */
public class NonDecreasingArray {
    public static void main(String[] args) {
        Solution solution = new NonDecreasingArray().new Solution();
//        int[] arr = new int[]{0,4,2,3};
        int[] arr = new int[]{3,4,2,3};
//        int[] arr = new int[]{4, 2, 3};
//        int[] arr = new int[]{1, 8, 9, 5, 15, 14};
//        int[] arr = new int[]{5,7,1,8};
//        int[] arr = new int[]{5,2,1,8};
        System.out.println(solution.checkPossibility(arr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkPossibility(int[] nums) {
            return helper(nums);
        }

        /**
         * 判断异常标准：nums[i] > nums[i + 1]
         * {0,4,2,3} 索引1：数值错误，改成0 or 2
         *
         * {5,7,1,8} 索引2：数值错误，改成7 or 8
         *
         * {3,4,5,2,3} 索引3，4：数值错误，失败
         * 可以看到 前三种都是后边的值对比前值有错误，然后进行修改
         * {4, 2, 3}
         * 这个是索引0：数值错误，
         * 可以看到这个是错误的值和后面的值比较时，有错误，
         * 那我们针对这两种情况进行分析
         *
         * 跟前面的比较，因为前面的是排好序的，后面的没排序修改的话容易出问题
         *
         * @param nums
         * @return
         */
        private boolean helper(int[] nums) {

            if (nums.length <= 1) {
                return true;
            }
            int count = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[i - 1]) {
                    if (i == 1 || nums[i] >= nums[i - 2]) {
                        nums[i - 1] = nums[i];
                    } else {
                        nums[i] = nums[i - 1];
                    }
                    count ++;
                }
            }
            return count <= 1;
        }



    }
//leetcode submit region end(Prohibit modification and deletion)

}
