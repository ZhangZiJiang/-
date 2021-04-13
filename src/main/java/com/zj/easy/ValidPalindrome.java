package com.zj.easy;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @program: algorithm
 * @description:
 * @author: Zhang Bo
 * @create: 2021-04-02 16:20
 **/
public class ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
        System.out.println(solution.helper("race a car"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            return helper(s);
        }

        public boolean helper(String s) {
            int l = 0;
            int r = s.length() - 1;
            while (l < r) {
                while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                    ++l;
                }
                while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                    --r;
                }
                if (l < r) {
                    if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                        return false;
                    }
                    ++l;
                    --r;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
