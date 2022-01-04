package com.zj.easy;

/**
 * @program algorithm
 * @description: 485. 最大连续1的个数
 * <p>
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 * <p>
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * 思路：遍历数组：
 * 定义doing 每当遇到1就记录
 * 定义 finish 和doing作比较 比doing小就更新
 * @author: zhangbo
 * @create: 2021/02/04 09:30
 */
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        Solution solution = new MaxConsecutiveOnes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            return doublePointer(nums);
        }

        private int helper(int[] nums) {
            if (nums.length == 0) return 0;
            int size = nums.length;
            int finish = 0;
            int doing = 0;

            for (int i = 0; i < size; i++) {
                if (nums[i] == 1) {
                    doing++;
                }
                if (finish < doing) {
                    finish = doing;
                }
                if (nums[i] == 0) {
                    doing = 0;
                }
            }

            return finish;
        }


        /**
         * 双指针法
         *
         * @param nums
         * @return
         */
        private int doublePointer(int[] nums) {
            if (nums.length == 0) return 0;

            int num = 0;
            int slow = 0;
            int fast = 0;
            while (fast < nums.length) {
                if (nums[fast] == 0) {
                    num = Math.max((fast - slow), num);
                    slow = fast + 1;
                }
                fast++;
            }

            num = Math.max(fast - slow, num);

            return num;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
