package com.zj.easy;

import java.util.Arrays;

/**
 * @program algorithm
 * @description: 645. 错误的集合
 * <p>
 * 集合 s 包含从 1（不是从1开始，可能是倒序） 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，
 * 导致集合 丢失了一个数字 并且 有一个数字重复 。
 * <p>
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * <p>
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2,4]
 * 输出：[2,3]
 * 示例 2：
 * <p>
 * 输入：nums = [1,1]
 * 输出：[1,2]
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 104
 * 1 <= nums[i] <= 104
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-mismatch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: zhangbo
 * @create: 2021/02/13 21:04
 */
public class SetMismatch {
    public static void main(String[] args) {
        Solution solution = new SetMismatch().new Solution();
        int[] ret = new int[]{37,62,43,27,12,66,36,18,39,54,61,65,47,32,23,2,46,8,4,24,29,38,63,39,25,11,45,28,44,52,15,30,21,7,57,49,1,59,58,14,9,40,3,42,56,31,20,41,22,50,13,33,6,10,16,64,53,51,19,17,48,26,34,60,35,5};
        Arrays.sort(ret);
        System.out.println(Arrays.toString(ret));
//        System.out.println(Arrays.toString(solution.findErrorNums(ret)));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] findErrorNums(int[] nums) {

            return helper2(nums);
        }

        /**
         * 先排序
         * @param nums
         * @return
         */
        private int[] helper2(int[] nums) {


            //校验
            if (nums.length == 0) {
                return nums;
            }

            Arrays.sort(nums);
            int[] ret = new int[2];

            int num = 1;
            for (int i = 1; i < nums.length; i++) {

                if(nums[i - 1] == num){
                    num++;
                }

                //比较是否相等
                if (nums[i - 1] == nums[i]) {
                    ret[0] = nums[i - 1];
                }

            }

            if(nums[nums.length - 1] == num){
                num++;
            }
            ret[1] = num;
            return ret;
        }

        /**
         * 不是从1开始 还有可能是倒序排列
         * 思路： 将数组遍历如果不等于 i + 1， 那么将记录
         *
         * @param nums
         * @return
         */
        private int[] helper1(int[] nums) {
            //校验
            if (nums.length == 0) {
                return nums;
            }

            int[] ret = new int[2];

            for (int i = 0; i < nums.length; i++) {
                int num = i + 1;
                if (nums[i] != num) {
                    ret[0] = i;
                    ret[1] = num;
                }
            }

            return ret;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
