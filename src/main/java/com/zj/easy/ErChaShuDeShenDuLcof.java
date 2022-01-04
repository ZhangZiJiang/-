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

        /**
         * 总结一下吧，一开始就想到了使用后序遍历，
         * 并且肯定要定义两个变量来分别记录左右的自己的深度，
         * 问题是当深度加一的时候，我们在哪加这个1，
         * 刚开始我在左右都加了1，这显然是不对的，就会造成重复加1 的情况
         * 然后我就认为这条路不行
         * 然而我错了。。。
         * 其实整体思路没问题，用后序遍历 BFS 是可以解答出来的，
         * 那这个1 加在哪呢
         * 没错，加在返回上，判断左右谁大，然后在返回前去加这个1。
         * @param root
         * @return
         */
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
