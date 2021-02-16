package com.zj.hard;

import java.util.Arrays;


/**
 * @program algorithm
 * @description: 41. 缺失的第一个正数
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 *  
 *
 * 进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,0]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 示例 3：
 *
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 300
 * -231 <= nums[i] <= 231 - 1
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: zhangbo
 * @create: 2021/02/16 20:16
 */
public class FirstMissingPositive{
    public static void main(String[] args) {
        Solution solution = new FirstMissingPositive().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstMissingPositive(int[] nums) {
            return helper(nums);
        }
        private int helper(int[] nums){
            if(nums.length == 0){
                return 1;
            }
            Arrays.sort(nums);
            int mark = 1;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] == mark){
                    mark++;
                }
            }
            return mark;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
