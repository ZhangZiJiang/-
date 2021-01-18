package com.zj.medium;

import java.util.Arrays;
import java.util.Queue;

/**
 * @program algorithm
 * @description: 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
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
            return helper(inorder, postorder);
        }

        /**
         * 这里有个很重要的定理
         * 左右子树的位置可以通过中序遍历的位置推出后和前的位置
         * 这种方法很显然不是最优解
         * @param in
         * @param pos
         * @return
         */
        public TreeNode helper(int[] in, int[] pos){
            int inSize = in.length;
            int posSize = pos.length;
            if(inSize == 0 || posSize == 0){
                return null;
            }
            //通过后序遍历找到根节点；
            int rootVal = pos[posSize - 1];

            //记录二叉树的节点
            TreeNode root = new TreeNode(rootVal);
            //循环中序遍历，找到中序数组中的根节点位置
            int rootPosition = -1;
            for (int i = 0; i < inSize; i++) {
                if(rootVal == in[i]){
                    rootPosition = i;
                    break;
                }
            }

            //分解并使用递归获取左子树
            int[] lIn = Arrays.copyOfRange(in, 0, rootPosition);
            int[] lPos = Arrays.copyOfRange(pos, 0, rootPosition);
            root.left = helper(lIn, lPos);

            //分解并使用递归获取右子树
            int[] rIn = Arrays.copyOfRange(in, rootPosition + 1, inSize);
            int[] rPos = Arrays.copyOfRange(pos, rootPosition, posSize - 1);
            root.right = helper(rIn, rPos);

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
