package com.zj.easy;


/**
 * @program algorithm   414. 第三大的数
 * @description:    414. 第三大的数
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 * 示例 2：
 * <p>
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 * 示例 3：
 * <p>
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * 解释：注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *  
 * <p>
 * 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/third-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: zhangbo
 * @create: 2021/02/05 20:57
 */
public class ThirdMaximumNumber {
    public static void main(String[] args) {
        Solution solution = new ThirdMaximumNumber().new Solution();
//        int[] a = new int[]{1, -2147483648, 1};
        int[] a = new int[]{1, 1, 2};
        System.out.println(solution.thirdMax(a));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int thirdMax(int[] nums) {
            return helper(nums);
        }

        private int helper(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            if (nums.length == 2) {
                return Math.max(nums[0], nums[1]);
            }

            int first = Integer.MIN_VALUE;
            int second = Integer.MIN_VALUE;
            int third = Integer.MIN_VALUE;
            int flag = 0;
            boolean fValue = true;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == Integer.MIN_VALUE && fValue) {
                    flag++;
                    fValue = false;
                }
                if (first < nums[i]) {
                    flag++;
                    third = second;
                    second = first;
                    first = nums[i];

                } else if (second < nums[i] && first != nums[i]) {
                    flag++;
                    third = second;
                    second = nums[i];

                } else if (third < nums[i] && second != nums[i] && first != nums[i]) {
                    flag++;
                    third = nums[i];

                }

            }

            return flag >= 3?third:first;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
