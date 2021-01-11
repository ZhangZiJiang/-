package com.zj.medium;


/**
 * @program algorithm
 * @description: 该函数目前所解决的问题是：
 * 将搜索二叉树（二叉排序树）后序遍历的数组posArr，请根据posArr，重建出整棵树，返回新建树的头结点。
 * @author: zhangbo
 * @create: 2021/01/07 11:33
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        int[] porArr = new int[0];
        TreeNode treeNode = solution.process1(porArr, 0, porArr.length - 1);
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

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }


    }


    class Solution {
        /**
         * 最简单的方法，但是效率最低，将后序遍历的数组转化为搜索二叉树
         * @param porArr
         * @param L
         * @param R
         * @return
         */
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


        /**
         * 最优解 采用二分法
         * @param porArr
         * @param L
         * @param R
         * @return
         */
        public TreeNode process2(int[] porArr, int L, int R) {
            if (L > R) {
                return null;
            }

            TreeNode node = new TreeNode(porArr[R]);
            if (L == R) {
                return node;
            }

//            int M = L - 1;
//            for (int i = L; M < R; i++) {
//                if (porArr[i] < porArr[R]) {
//                    M = i;
//                }
//            }



            int M = L - 1;
            int left = L;
            int right = R - 1;
            int mid = left + ((right - left) >> 1);

            /**
             * 使用二分法 使用left 和 right 进行判断
             * 如果相等或者小于的话就结束二分 ，说明已经找到想要的值了
             */
            while (left <= right){
                //做个判断 取的中点和最后边的值比较
                if(porArr[mid] < porArr[R]){
                    /**
                     * 为真的话
                     * 说明 你想找的那个分界点在右部分，
                     * 再继续拿右边的进行比较
                     */
                    /**
                     * M = mid;
                     * 为什么要有这句话，
                     * 因为当拿右边的话，我们的M值已经变化了
                     * 所以要更新 M 的值
                     */
                    M = mid;
                    // 更新左边的值
                    left = mid + 1;
                }else {
                    /**
                     * 如果为假的话
                     * 说明 你想找的那个分界点在左部分，
                     *  再继续拿左边的进行比较
                     */
                    // 更新右边的值
                    right = mid - 1;
                }
            }

            node.left = process2(porArr, L, M);
            node.right = process2(porArr, M + 1, R - 1);

            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    /**
     * 这道算法题的步骤：
     * 步骤一：非法判断，
     * 步骤二：拿出头结点，
     * 步骤三：左右节点相等情况判断
     * 步骤四：确定当前根节点，使用循环找出左右子树的分界点的下标值，这里的循环可以优化到 二分查找
     * 步骤五：使用递归分别处理左右子树
     *
     * 二分查找的步骤：
     * 步骤一：获取要二分查找的左右边界；
     * 步骤二：获取中间点 （我给它称之为二分点）一般二分点为：(L + (R - L) >> 1)
     * 步骤三：循环压缩 二分点，直到压缩的数组 R <= L 这个作为循环条件
     * 步骤四：判断 二分点 与 右的大小关系，
     *       如果右 < 二分点：循环右边
     *       如果右 >= 二分点：循环左边
     */

}
