package com.zj.easy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @program algorithm
 * @description: 118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * <p>
 * <p>
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: zhangbo
 * @create: 2021/02/21 10:10
 */
public class PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangle().new Solution();
        System.out.println(solution.generate(1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            return helper(numRows);
        }


        private List<List<Integer>> helper(int numRows) {
            List<List<Integer>> ret = new ArrayList<>();


            for (int i = 0; i < numRows; i++) {
                ArrayList<Integer> ele = new ArrayList<>(i);
                for (int j = 0; j <= i; j++) {
                    //存放第一个元素
                    if (j == 0 || j == i) {
                        ele.add(1);
                    } else {
                        ele.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                    }


                }
                ret.add(i, ele);
            }
            return ret;
        }

//        private List<Integer> getEle(int numsRows) {
//
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
