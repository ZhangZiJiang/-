package com.zj.medium;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @program algorithm
 * @description: 面试题 04.05. 合法二叉搜索树
 * <p>
 * 实现一个函数，检查一棵二叉树是否为二叉搜索树。
 * <p>
 * 示例 1:
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * 输入:
 * 5
 * / \
 * 1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/legal-binary-search-tree-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: zhangbo
 * @create: 2021/01/14 17:18
 */
public class LegalBinarySearchTreeLcci {
    public static void main(String[] args) {
        Solution solution = new LegalBinarySearchTreeLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {

        int a = 0;
        int count = 0;
        int record = 0;

        public boolean isValidBST(TreeNode root) {
            this.helper(root);
            return record <= 0;
        }

        /**
         * 又是这个搜索二叉树的中序遍历
         * 这道题还有优化的地方
         *
         * @param root
         * @return
         */
        private void helper(TreeNode root) {

            if (root == null) {
                return;
            }

            if (root.left != null) {
                helper(root.left);
            }

            if (count != 0 && a >= root.val) {
                record++;
            }
            a = root.val;
            count++;

            if (root.right != null) {
                helper(root.right);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 思路很简单
     * 中序遍历是有顺序的
     * 因为存在数组中在比较会耗时
     * 那我们可以当获取到一个值，就去比较这个值和上个值的大小
     * 当然为了不报错必须知道哪个是第一次添加的，所以我做了个 count 当a更新时，count++ 告诉a值更新了，可以比较了
     */


    /**
     *
     *         不是最优解
     *         ArrayList<Integer> ret = new ArrayList<>();
     *         public boolean isValidBST(TreeNode root) {
     *             this.helper(root);
     *             for (int i = 0; i < ret.size() - 1; i++) {
     *                 if(ret.get(i) >= ret.get(i + 1)){
     *                     return false;
     *                 }
     *             }
     *             return true;
     *         }
     *
     *         private void helper(TreeNode root) {
     *             if(root == null){
     *                 return;
     *             }
     *
     *             if(root.left != null){
     *                 helper(root.left);
     *             }
     *
     *             ret.add(root.val);
     *
     *             if(root.right != null){
     *                 helper(root.right);
     *             }
     *
     *         }
     */
}
