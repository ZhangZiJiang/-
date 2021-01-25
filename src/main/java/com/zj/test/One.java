package com.zj.test;

import java.util.HashMap;

/**
 * @program algorithm
 * @description: 给定一个整数数组 nums 和一个目标值 k，
 * 请实现一个方法判断 nums 中是否存在某个片段（即若干个相连元素）之和等于 k。
 * 要求时间复杂度为 O(n)。
 * public boolean checkSum(int[] nums, int k) {
 * // Write your code here.
 * }
 * @author: zhangbo
 * @create: 2021/01/18 17:52
 */
public class One {


    public static void main(String[] args) {

        int[] nums = new int[]{4, 6, 3, 2, 4, 2, 8, 4, 6, 3, 2, 4, 2, 8, 4, 6, 3, 2, 4, 2, 8, 4, 6, 3, 2, 4, 2, 8
                , 4, 6, 3, 2, 4, 2, 8, 4, 6, 3, 2, 4, 2, 8, 4, 6, 3, 2, 4, 2, 8, 4, 6, 3, 2, 4, 2, 8, 4};
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
//            System.out.println(checkSum(nums, 7));
            checkSum(nums, 7);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static boolean checkSum(int[] nums, int k) {
        // Write your code here.
        return helper3(nums, k);
    }
    private static boolean helper3(int[] nums, int k) {
        if (nums.length == 0) {
            return false;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int lNum = 0;
            if(nums[left] < k) {
                for (int j = left; j <= nums.length - 1; j++) {
                    lNum += nums[j];
                    if (lNum == k) {
                        return true;
                    } else if (lNum > k) {
                        break;
                    }
                }
            }
            left++;

            int rNum = 0;
            if(nums[right] < k){
                for (int j = right; j >= 0; j--) {
                    rNum += nums[j];
                    if (rNum == k) {
                        return true;
                    } else if (rNum > k) {
                        break;
                    }
                }
            }
            right--;
        }
        return false;
    }

    private static boolean helper1(int[] nums, int k) {
        if (nums.length == 0) {
            return false;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            int all = k;
            if (nums[i] < k) {
                for (int j = i; j >= 0; j--) {
                    all -= nums[j];
                    if (all == 0) {
                        return true;
                    } else if (all < 0) {
                        break;
                    }
                }
            }
        }
        return false;
    }


    private static boolean helper2(int[] nums, int k) {
        if (nums.length == 0) {
            return false;
        }

        int sub = nums.length - 1;
        int center = sub >> 1;
        for (int i = 0; i <= center; i++) {

            //左查找
            int lNum = 0;
            if(nums[i] < k) {
                for (int j = i; j <= sub; j++) {
                    lNum += nums[j];
                    if (lNum == k) {
                        return true;
                    } else if (lNum > k) {
                        break;
                    }
                }
            }

            //右查找
            int rNum = 0;
            if(nums[sub - i] < k){
                for (int j = sub - i; j >= 0; j--) {
                    rNum += nums[j];
                    if (rNum == k) {
                        return true;
                    } else if (rNum > k) {
                        break;
                    }
                }
            }

        }
        return false;
    }



}
