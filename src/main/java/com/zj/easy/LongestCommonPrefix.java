package com.zj.easy;

/**
 * @program: algorithm
 * @description:
 * @author: Zhang Bo
 * @create: 2021-04-13 16:03
 **/
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        String[] strs = {"flower","flower","flower","flower"};
        System.out.println(solution.longestCommonPrefix(strs));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            } else {
                return helper(strs, 0, strs.length - 1);
            }
        }

        public String helper(String[] strs, int start, int end) {
            if (start == end) {
                return strs[start];
            } else {
                int mid = (end - start) / 2 + start;
                String l = helper(strs, start, mid);
                String r = helper(strs, mid + 1, end);
                return pub(l, r);
            }
        }

        public String pub(String a, String b) {
            int i = 0;
            String ret = "";
            int length = Math.min(a.length(), b.length());

            while (i < length && a.charAt(i) == b.charAt(i)) {
                ret += a.charAt(i);
                i++;
            }
            return ret;
        }


        /**
         * 分而治之的算法思想
         * 当使用>>时，负奇数值和 / 2不同
         */
    }
}
