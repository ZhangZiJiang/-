package com.zj.easy;

/**
 * @program algorithm
 * @description: 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * <p>
 * 例如：
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: zhangbo
 * @create: 2021/01/11 22:01
 */
public class ErChaShuDeShenDuLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaShuDeShenDuLcof().new Solution();
//        int[] arr = {2,4,3,6,9,8,5};
//        TreeNode treeNode = solution.process1(arr, 0, arr.length - 1);
//        System.out.println(solution.helper(treeNode));
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
        TreeNode right;
        TreeNode left;

        TreeNode(int x) {
            this.val = x;
        }
    }


    class Solution {


        public int maxDepth(TreeNode root) {
            return helper(root);
        }

        private int helper(TreeNode root) {

            if (root == null) {
                return 0;
            }


            int L = helper(root.left);

            int R = helper(root.right);

            return (L > R ? L : R) + 1 ;

        }





    }


//leetcode submit region end(Prohibit modification and deletion)

}
