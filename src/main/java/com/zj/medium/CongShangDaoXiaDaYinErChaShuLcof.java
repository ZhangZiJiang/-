package com.zj.medium;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;


/**
 * @program algorithm
 * @description:  剑指 Offer 32 - I. 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 *  
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 *
 * [3,9,20,15,7]
 *  
 *
 * 提示：
 *
 * 节点总数 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: zhangbo
 * @create: 2021/01/12 17:17
 */
public class CongShangDaoXiaDaYinErChaShuLcof{
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuLcof().new Solution();
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

    public class TreeNode{

        int val;
        TreeNode right;
        TreeNode left;
        TreeNode(int x){
            this.val = x;
        }
    }
    class Solution {

        List<Integer> ret = new ArrayList<>();


        public int[] levelOrder(TreeNode root) {
            return helperBFS(root);
        }

        /**
         * 所以这里采用了 BFS 完成树的层次遍历
         * @param root
         * @return
         */
        public int[] helperBFS(TreeNode root){

            if(root == null){
                return new int[0];
            }

            ArrayList<Integer> list = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()){

                TreeNode poll = queue.poll();
                list.add(poll.val);
                if(poll.left != null){
                    queue.add(poll.left);
                }
                if(poll.right != null){
                    queue.add(poll.right);
                }
            }
            return list.stream().mapToInt(Integer::intValue).toArray();
        }

//        /**
//         * 这里使用 深度优先 显然是错的
//         * @param root
//         * @return
//         */
//        public List<Integer> helper(TreeNode root){
//
//            if(root == null){
//                return ret;
//            }
//            ret.add(root.val);
//            //记住递归他的子树，！！！！！
//            if(root.left != null){
//                helper(root.left);
//            }
//
//            if(root.right != null){
//                helper(root.right);
//            }
//
//            return ret;
//        }

    }



//leetcode submit region end(Prohibit modification and deletion)


    /**
     * 这里逐渐清楚了 深度优先（DFS） 和 广度优先（BFS） 的区别在哪里了
     * 这道题实际上就是实现广度优先，在二叉树中，广度优先又被称作是 层序遍历
     * 而 深度优先 在二叉树中是 先序，后序，和中序遍历。
     */

    /**
     * 总结一下广度优先，即层序遍历的步骤总结
     *
     * 步骤一：检验 tree 是否为null 是直接返回出去
     * 步骤二：将根节点存入队列中；
     * 步骤三：根据队列是否为空，循环这个队列 先将队列存储到数组并删除队列，再将有子树就存在队列里边循环遍历
     */
}
