package com.zj.medium;

/**
 * @program algorithm
 * @description: 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * @author: zhangbo
 * @create: 2021/01/10 17:43
 */
public class ErChaSouSuoShuDeHouXuBianLiXuLieLcof {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(new ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution().verifyPostorder(arr));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            return process(postorder, 0, postorder.length - 1);
        }

        public boolean process(int[] arr, int L, int R) {
            int node = L;
            if (L >= R) {
                return true;
            }
            for (int i = L; i <= R - 1; i++) {
                if (arr[i] == arr[R]) {
                    return false;
                }
                if (arr[i] > arr[R]) {
                    break;
                }
                node++;
            }

            for (int i = R - 1; i >= node; i--) {
                if (arr[i] <= arr[R]) {
                    return false;
                }
            }

            return process(arr, L, node - 1) && process(arr, node, R - 1);

        }


    }
}
