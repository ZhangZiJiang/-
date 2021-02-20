package com.zj.easy;

import java.util.Arrays;

/**
 * @program algorithm
 * @description: 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: zhangbo
 * @create: 2021/02/20 09:58
 */
public class MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
        int[] nums = new int[]{1, 0, 1};
//        int[] nums = new int[]{0, 1, 0, 3, 12};
//        int[] nums = new int[]{0, 0, 1};
//        int[] nums = new int[]{2,1};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            helper(nums);

        }

        /**
         * 使用 冒泡思想 计算0的次数，将0冒泡出去
         * 还有一种方法计算非0 的次数，这样就没有 int num = i - count;这步操作了
         * @param nums
         */
        private void helper(int[] nums) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    //排除第一次不换
                    if (count != 0) {
                        int num = i - count;
                        nums[num] = nums[i];
                        nums[i] = 0;
                    }
                } else {
                    count++;
                }
            }



        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
