package com.zj.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program algorithm
 * @description: 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * <p>
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * <p>
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * 输出:
 * [5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: zhangbo
 * @create: 2021/02/14 11:19
 */
public class FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        Solution solution = new FindAllNumbersDisappearedInAnArray().new Solution();
        int[] barrel = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(solution.findDisappearedNumbers(barrel));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {

            return helper1(nums);
        }

        /**
         * 所有正数作为数组下标，对应值变为负值，仍为正说明从未出现过
         * @param nums
         * @return
         */
        private List<Integer> helper1(int[] nums) {
            if (nums.length == 0) {
                return new ArrayList<>();
            }

            for (int i = 0; i < nums.length; i++) {
                int abs = Math.abs(nums[i]);
                if (nums[(abs - 1)] > 0) {
                    nums[(abs - 1)] = -nums[(abs - 1)];
                }
            }
            List<Integer> ret = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                if(nums[i] > 0){
                    ret.add(i + 1);
                }
            }
            return ret;
        }

        /**
         * 桶排 时间复杂度 o(n) 但是使用了额外空间
         *
         * @param nums
         * @return
         */
        private List<Integer> helper(int[] nums) {
            if (nums.length == 0) {
                return new ArrayList<>();
            }

            int[] barrel = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                barrel[--nums[i]]++;
            }

            List<Integer> ret = new ArrayList<>();

            for (int i = 0; i < barrel.length; i++) {
                if (barrel[i] == 0) {
                    ret.add(i + 1);
                }
            }

            return ret;
        }



    }
//leetcode submit region end(Prohibit modification and deletion)

}
