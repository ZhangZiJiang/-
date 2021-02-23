package com.zj.exercise;

import java.util.Arrays;

/**
 * @program algorithm
 * @description:
 * @author: zhangbo
 * @create: 2021/02/23 10:35
 */
public class ZingFront {

    public static void main(String[] args) {
        ZingFront front = new ZingFront();
        int[] nums = new int[]{10, 7, 5, 4};
        System.out.println(Arrays.toString(front.one(nums)));
        String str = "1111111111111115";
        System.out.println(str);
        System.out.println(front.two(str));

        System.out.println(front.three(2, 2));
    }

    /**
     * 1,先选出最大值；
     * 2,分配人员；
     * <p>
     * 循环12个月 * 10年即可
     * 注解：索引值0,1,2,3分别代表ABCD
     * 题目中没有明确当最大组的人数相同怎么分，这里按照A B C D的顺序选择的。
     *
     * @param nums
     * @return
     */
    private int[] one(int[] nums) {
        int max = nums[0];

        for (int i = 0; i < 120; i++) {
            //选出最大值
            for (int j = 0; j < nums.length; j++) {
                if (max < nums[j]) {
                    max = nums[j];
                }
            }

            //将最大值分配给其他三个小组
            for (int j = 0; j < nums.length; j++) {
                if (max == nums[j]) {
                    nums[j] -= 3;
                } else {
                    nums[j]++;
                }
            }

        }
        return nums;
    }

    static final String OK = "OK";
    static final String ERROR = "error";

    private String two(String code) {
        //先检查长度是否等于16位
        if (code.length() != 16) {
            return ERROR;
        }

        //先转化为char数组
        char[] chars = code.toCharArray();
        //偶数和
        int even = 0;
        //奇数和
        int odd = 0;

        //逆序遍历
        for (int i = chars.length - 1; i >= 0; i--) {
            //校验是否是小写字母和数字
            int num = getNumByLetter(chars[i]);
            if (num == -1) {
                return ERROR;
            }
            //处理偶数位
            if ((i & 1) == 0) {
                even += ((num << 1) > 9 ? ((num << 1) - 9) : (num << 1));
            } else {
                //奇数位
                odd += num;
            }

        }

        //如果被10整除返回ok
        return ((even + odd) % 10) == 0 ? OK : ERROR;

    }

    private static int getNumByLetter(char letter) {
        int ret = -1;
        //根据ASCII码判断
        if (letter >= 97 && letter <= 122) {
            ret = (letter - 96) % 9;
        } else if (letter >= 48 && letter <= 57) {
            ret = letter - 48;
        }
        return ret;
    }


    /**
     * 暴力求解
     *
     * @param n
     * @param m
     * @return
     */
    private int three(int n, int m) {
        int ret = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= (m >> 1); j++) {
                for (int k = 0; k <= (m / 5); k++) {
                    for (int l = 0; l <= (m / 10); l++) {
                        if ((i + j * 2 + k * 5 + l * 10) == m && (i + j + k + l) == n) {
                            ret++;
                        }
                    }
                }
            }
        }
        return ret;
    }

}
