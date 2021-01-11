package com.zj.medium;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @program algorithm
 * @description: 今日头条题目：
 * <p>
 * 数组为 {3, 2, 2, 3, 1}, 查询为(0, 3, 2) .
 * 意思是在数组下标 0~3这个范围上，有几个2？ 返回2.
 * 假设给你一个数组 arr，对这个数组的查询非常频繁
 * 请返回所有查询的结果
 * @author: zhangbo
 * @create: 2021/01/09 00:40
 */
public class Example002 {
    public static void main(String[] args) {

    }


    public Integer searchArr(int[] arr, int L, int R, int num) {
        HashMap<Integer, ArrayList<Integer>> map = this.getNewMap(arr);

        Integer a = this.countLess(map.get(num), L);
        Integer b = this.countLess(map.get(num), R);


        return b - a;


    }


    /**
     * 将数组排序，并存到 map 中
     *
     * @param arr
     * @return
     */
    public HashMap<Integer, ArrayList<Integer>> getNewMap(int[] arr) {
        HashMap<Integer, ArrayList<Integer>> retMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (retMap.containsKey(arr[i])) {
                retMap.get(arr[i]).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                retMap.put(arr[i], list);
            }

        }
        return retMap;
    }


    /**
     * 在有序数组中查询小于 limit ，使用的二分法
     *
     * @param arr
     * @param limit
     * @return 返回的是数组的下标
     */
    public Integer countLess(ArrayList<Integer> arr, int limit) {

        /**
         * 步骤一：定义左右数组<p>下标<p/>边界
         *
         */
        int left = 0;
        int right = arr.size() - 1;

        /**
         * 步骤二：定义返回值
         * 必须定义 -1 非常巧妙的定义方式
         *
         */
        int mostRight = -1;


        /**
         * 步骤三：循环找值
         */
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr.get(mid) < limit) {
                mostRight = mid;
                left = mid - 1;
            } else {
                right = mid + 1;
            }
        }


        /**
         * 步骤四：加一返回；
         * 设置成 -1 的原因：
         * 1，当数组中全是大于 limit 的值 那就会 加一 返回 0
         * 2，当数组中全是小于 limit 的值 那就会 加一 返回 数组的全部即数组的长度（size）
         */
        return mostRight + 1;
    }


    /**
     * 这道题的整体流程：
     * 步骤一：将整个数组遍历一遍，并将值作为 key ，下标作为 value 依次存到 HashMap<Integer, ArrayList<Integer>> 类型的 map 中
     * 步骤二：用 map 查找你想要的值 例如: (0, 3, 2)
     *          这里有个小技巧 我们要找 0 <= x <= 3 这个范围区间的
     *          实际上我们可以用二分法 找 x <= 0 和 x <= 3 进行相减 就可得到该区间的数量。
     */



    /**
     * 题目： 在有序的数组中，找到小于 limit 值的个数 并使用二分法
     * 步骤一：定义左右数组<p>下标<p/>边界
     * 步骤二：定义返回值
     * 步骤三：循环找值
     *      3.1：循环 --- 循环条件(left <= right)
     *      3.2：定义 二分点=left + ((right - left) >> 1);
     *      3.3：判断 二分点 与 limit 的大小
     * 步骤四：加一返回
     */
}
