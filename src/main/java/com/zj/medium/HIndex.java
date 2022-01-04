package com.zj.medium;

import java.util.Arrays;

/**
 * @program algorithm
 * @description:
 * @author: zhangbo
 * @create: 2021/02/17 10:07
 */
public class HIndex {
    public static void main(String[] args) {
        Solution solution = new HIndex().new Solution();
        int[] citations = new int[]{11,15};

//        int[] citations = new int[]{3, 0, 6, 1, 5, 4};
        System.out.println(solution.hIndex(citations));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int hIndex(int[] citations) {
            return helper(citations);
        }

        private int helper(int[] citations) {
            if (citations.length == 0) {
                return 0;
            }
            if(citations.length == 1 && citations[0] != 0){
                return 1;
            }
            Arrays.sort(citations);

            int ret = citations[0];
            int size = citations.length;
            for (int i = 0; i < size; i++) {
                if ((size - i) >= citations[i] && ret < citations[i]) {
                    ret = citations[i];
                }
                if((size - i) < citations[i] && ret < (size - i)){
                    ret = size - i;
                }
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
