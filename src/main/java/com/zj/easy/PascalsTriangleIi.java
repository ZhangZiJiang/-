package com.zj.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @program algorithm
 * @description:   119. 杨辉三角 II
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 *
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: zhangbo
 * @create: 2021/02/22 10:40
 */
public class PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangleIi().new Solution();
        System.out.println(solution.getRow(4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            return helper(rowIndex);
        }

        /**
         * 杨辉三角公式了解一下。。
         * cur * (rowIndex - i) / (i + 1);
         * @param rowIndex
         * @return
         */
        private List<Integer> helper(int rowIndex) {
            List<Integer> res = new ArrayList<>(rowIndex + 1);
            long cur = 1;
            for (int i = 0; i <= rowIndex; i++) {
                res.add((int) cur);
                cur = cur * (rowIndex - i) / (i + 1);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
