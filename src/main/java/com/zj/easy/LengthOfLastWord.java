package com.zj.easy;

/**
 * @program: algorithm
 * @description: 58. 最后一个单词的长度
 * <p>
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "Hello World"
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：s = " "
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅有英文字母和空格 ' ' 组成
 * @author: Zhang Bo
 * @create: 2021-05-28 16:27
 **/
public class LengthOfLastWord {
    public static void main(String[] args) {
        Solution solution = new LengthOfLastWord().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLastWord(String s) {
            return helper(s);
        }

        private int helper(String s) {

            int len = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) != ' ') {
                    len++;
                }
                if (s.charAt(i) == ' ' && len != 0) {
                    return len;
                }
            }
            return len;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    /**
     *          写了个寂寞，这个是返回最大的单词
     *         private int helper(String s) {
     *             // 之前的max值
     *             int oldMax = 0;
     *             // 新筛选的max
     *             int max = 0;
     *             for (int i = 0; i < s.length(); i++) {
     *                 if (s.charAt(i) != ' ') {
     *                     max++;
     *                 }
     *                 if (s.charAt(i) == ' ') {
     *                     oldMax = Math.max(max, oldMax);
     *                     max = 0;
     *                 }
     *                 if (oldMax >= s.length() - 1 - i) {
     *                     return oldMax;
     *                 }
     *             }
     *             return oldMax;
     *         }
     *     }
     *
     *
     *
     */
}
