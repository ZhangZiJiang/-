package com.zj.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program algorithm
 * @description:
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: zhangbo
 * @create: 2020/11/17 15:45
 */
public class One {

    /**
     * 方法一： 暴力求解法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {

        int[] ret = new int[2];
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j > i; j--) {
                if (nums[i] + nums[j] == target) {
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
            }
        }
        return ret;
    }


    /**
     * 方法二：方法一的时间复杂度为o(n)，不管怎么取值，都必须把每个值进行遍历相加 比较，
     *
     * 反向思维先求出 target - i 的值，在取出 与hashMap 作比较
     * 这样做 一样
     * 然后再加上 hashMap
     *
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {

        int[] ret = new int[2];
        int length = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if(map.containsKey(target - nums[i])){
                ret[0] = i;
                ret[1] = map.get(target - nums[i]);
                return ret;
            }
            map.put(nums[i] , i);
        }
        return ret;
    }




    public static void main(String[] args) {
        One one = new One();
        System.out.println(Arrays.toString(one.twoSum2(new int[]{3, 2, 4}, 6)));
    }
}
