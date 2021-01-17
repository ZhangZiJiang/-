package com.zj.medium;

/**
 * @program algorithm
 * @description:
 * @author: zhangbo
 * @create: 2021/01/17 20:05
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
