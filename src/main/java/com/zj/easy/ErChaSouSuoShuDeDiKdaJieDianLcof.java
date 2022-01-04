package com.zj.easy;

import java.util.ArrayList;

/**
 * @program algorithm
 * @description:
 * @author: zhangbo
 * @create: 2021/01/11 09:27
 */
public class ErChaSouSuoShuDeDiKdaJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeDiKdaJieDianLcof().new Solution();
        int[] arr = {2,1,4,3};
        TreeNode treeNode = solution.process1(arr, 0, arr.length - 1);
        System.out.println(solution.kthLargest(treeNode, 1));
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


//    Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        private int val = 0;
        private int count = 0;
        /**
         * 使用中序遍历
         *
         * @param root
         * @param k
         * @return
         */
        public int kthLargest(TreeNode root, int k) {

            this.helper(root, k);
            return val;
        }

        /**
         * 我们继续想，那如果我们遍历到我们想要的值，是不是就可以结束遍历了呢，这样就能节省更多的时间了
         * 没错！
         * 但是有个问题，我不知道树的中序数组的长度，按照中序从小到大的原理，我就没办法知道它是第几大的；
         * 怎么解决这个问题呢？
         * 没错，如果将中序的升序，变成降序，我们不就知道了嘛！
         * 那现在的问题就是怎么把树进行降序排列呢？
         * 没错，就是遍历顺序是 <p> 右，中，左 <p/>
         *
         * 那这样就没必要存储在数组中了，因为你已经知道 并直接拿到 你想要的值了，就没必要在存起来了
         *
         * @param root
         * @param k
         */
        public void helper(TreeNode root, int k){

            //右
            if(root.right != null){
                helper(root.right, k);
            }

            if(++count == k ){
                //中
                val = root.val;
                return;
            }


            //左
            if(root.left != null){
                helper(root.left, k);
            }



        }


        /**
         * <p> 不是最优解 <p/>
         * 这是对于搜索二叉树的中序遍历
         * 但这种方法并不是最优解，当只要添加到 k 的位置，
         * 实际上就已经可以得到我们想要的值了，所以到这里就可以停止遍历并返回该值了
         * @param root
         * @param list
         */
        public void orderTree(TreeNode root, ArrayList<Integer> list) {

            if (root == null) {
                return;
            }

            //左
            if(root.left != null){
                orderTree(root.left, list);
            }
            //中
            list.add(root.val);

            //右
            if(root.right != null){
                orderTree(root.right, list);
            }

        }




        public TreeNode process1(int[] porArr, int L, int R) {
            /**
             * 步骤一：判断数组是否合法
             * 首先要判断L > R, 说明数组不只是空了，这个数组已经有问题了
             * 已经无法描述该问题了
             * <p> 这里边 还有另外的判断，在递归的时候，我们需要判断是否还有左右子树时，会走这个逻辑 <p/>
             */
            if (L > R) {
                return null;
            }
            /**
             * 步骤二：找出头结点
             * 继续，既然数组合法，那么考虑一下这个数组，我们首先最容易判断的是头结点的位置，也就是 porArr[R] ，
             * 所以我们将这个值记录在 TreeNode 里边；
             *
             * 可以说明两个 问题：
             * 1，说明这个数组只有一个元素，那就没必要进行排序了，直接返回。
             * 2，说明这个数组已经是最小子节点了。不需要继续向下走了。
             * 然后直接返回头结点
             */
            //这句话另外的意思是
            // 将头结点拿出
            TreeNode node = new TreeNode(porArr[R]);
            if (L == R) {
                return node;
            }

            /**
             * 步骤三：找出左子树和右子树；
             * 既然上边两种情况都不符合，说明数的度大于1，
             * 怎么找出左子树和右子树
             * 所以下面是找出左子树和右子树的那个分界点
             */
            /**
             * 这里为什么是 L - 1 呢？
             * 因为 当只有左子树时，等于L 会少算一个值
             */
            int M = L - 1;
            for (int i = L; i < R; i++) {
                if (porArr[i] < porArr[R]) {
                    M = i;
                }
            }

            /**
             * 步骤四：递归，继续向下找树
             */
            node.left = process1(porArr, L, M);
            node.right = process1(porArr, M + 1, R - 1);

            return node;
        }
    }




        /**
         * 问题一：为什么左和右的操作不用 add ？
         * 因为使用递归到最后，左和右最终会变成 中节点的。
         */

//leetcode submit region end(Prohibit modification and deletion)

}
