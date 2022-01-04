package com.zj.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @program algorithm
 * @description:
 * @author: zhangbo
 * @create: 2021/02/15 10:46
 */
public class FindAllDuplicatesInAnArray {
    public static void main(String[] args) {
        Solution solution = new FindAllDuplicatesInAnArray().new Solution();
        int[] nums = new int[]{4,8,7,7,8,2,3,1};
        System.out.println(solution.findDuplicates(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            return helper1(nums);
        }

        /**
         * 输入输出的空间不属于额外空间，
         * 可以在输入数组中用数字的正负来表示该位置所对应数字是否已经出现过。
         * 遍历输入数组，给对应位置的数字取相反数，如果已经是负数，说明前面已经出现过，直接放入输出数组。
         * @param nums
         * @return
         */
        private List<Integer> helper1(int[] nums) {
            if (nums.length == 0) {
                return new ArrayList<>();
            }

            ArrayList<Integer> ret = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {

                nums[Math.abs(nums[i]) - 1] = - nums[Math.abs(nums[i]) - 1];

                if((nums[Math.abs(nums[i]) - 1]) > 0){
                    ret.add(Math.abs(nums[i]));
                }
            }
            return ret;
        }


        /**
         * 桶排序
         * @param nums
         * @return
         */
        private List<Integer> helper(int[] nums) {

            if (nums.length == 0) {
                return new ArrayList<>();
            }

            int[] arr = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                arr[nums[i] - 1] = arr[nums[i] - 1] + 1;
            }

            ArrayList<Integer> ret = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] == 2){
                    ret.add(i + 1);
                }
            }

            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
