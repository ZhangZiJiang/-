package com.zj.medium;

import com.sun.source.tree.Tree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @program algorithm
 * @description: 剑指 Offer 26. 树的子结构
 * <p>
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * 例如:
 * 给定的树 A:
 * <p>
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 * <p>
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: zhangbo
 * @create: 2021/01/15 15:42
 */
public class ShuDeZiJieGouLcof {
    public static void main(String[] args) {
        Solution solution = new ShuDeZiJieGouLcof().new Solution();
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

        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (A == null || B == null) return false;
            return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }

        /**
         *  终止条件
         * @param A
         * @param B
         * @return
         */
        public boolean dfs(TreeNode A, TreeNode B) {
            if (B == null) return true;
            if (A == null) return false;
            return A.val == B.val && dfs(A.left, B.left) && dfs(A.right, B.right);
        }
//leetcode submit region end(Prohibit modification and deletion)

    }





































































}


/**
 * 思考这道题的方式：
 * 首先对从大到小，从宏到微的方式思考树
 * 1，一般的二叉树都会去从 深度优先DFS 或者是 广度优先BFS
 * 2，深度优先：在考虑先序，中序还是后序；（首先是对这三种都很熟悉，然后要根据题意去考虑这三种哪种方式）
 * 3，判断终止条件；返回值；特例处理
 *
 *
 *
 * 基于以上对二叉树的总结，我们再来看这道题：
 *
 * 1 首先我先考虑的是 层序遍历BFS 是可以解决，但是很慢。。而且我没做出来。。。
 *
 * 2
 * 如果是深度优先呢？是可以解决的
 * 但你要考虑 先 中 后 哪一种的遍历方式
 * 从这道题分析 首先是要每一个 A 的根节点与 B 的根节点去比较 相等才能往下执行比较
 * 所以肯定去使用中序遍历
 *
 * 终止条件
 * 当节点 B 为空：说明树 BB 已匹配完成（越过叶子节点），因此返回 true ；
 * 当节点 A 为空：说明已经越过树 A 叶子节点，即匹配失败，返回 false ；
 * 当节点 A 和 B 的值不同：说明匹配失败，返回 false ；
 *
 * 返回值：
 * 判断 A 和 B 的左子节点是否相等，即 recur(A.left, B.left) ；
 * 判断 A 和 B 的右子节点是否相等，即 recur(A.right, B.right) ；
 *
 *
 * isSubStructure(A, B) 函数：
 *
 * 特例处理： 当 树 A 为空 或 树 BB 为空 时，直接返回 false；
 * 返回值： 若树 B 是树 A 的子结构，则必满足以下三种情况之一，因此用或 || 连接；
 * 以 节点 A 为根节点的子树 包含树 B ，对应 recur(A, B)；
 * 树 B 是 树 A 左子树 的子结构，对应 isSubStructure(A.left, B)；
 * 树 B 是 树 A 右子树 的子结构，对应 isSubStructure(A.right, B)；
 *
 *
 *
 */
