package com.zj.medium;

/**
 * @program algorithm
 * @description: 字节高频面试题
 * 给你一个随机函数f，等概率返回1~5中的一个数字，
 * 这是你唯一一个可以使用的随机机制，如何实现等概率返回1~7的一个数字
 * <p>
 * <p>
 * 给你一个随机函数f，等概率返回a~b中的一个数字，
 * 这是你唯一一个可以使用的随机机制，如何实现登改路返回c~d中的一个数字
 * @author: zhangbo
 * @create: 2021/01/10 11:35
 */
public class Example003 {


    // 这个结构是唯一的随机机制
    // 你只能初始化并使用，不可修改
    public static class RandomBox {
        private final int min;
        private final int max;

        // 初始化时请一定不要让min == max
        public RandomBox(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public int random() {
            return min + (int) (Math.random() * (max - min + 1));
        }

        public int min() {
            return min;
        }

        public int max() {
            return max;
        }
    }


    /**
     * 步骤一：首先将随机数 减小到 0 ~ 任意值 上，
     * 步骤二：判断这个范围内的数 是奇数还是偶数，
     * 步骤三：根据奇偶判断，并返回0，1；
     *
     * @param randomBox
     * @return
     */
    public static int rand01(RandomBox randomBox) {
        int min = randomBox.min();
        int max = randomBox.max();

        int size = max - min + 1;
        int randNum = randomBox.random() - min;
        int mid = size >> 1;

        // 判断奇数还是偶数，如果为奇数，并且得到中间值就重新计算随机值
        while (randNum == mid && ((size & 1) == 1)) {
            randNum = randomBox.random() - min;
        }
        return randNum < mid ? 0 : 1;
    }


    public static int randomAny(RandomBox randomBox, int min, int max) {
        if (min == max) {
            return min;
        }
        int size = max - min + 1;
        int bitNum = 1;
        int border = 1;

        do {
            border = border << bitNum - 1;
            bitNum++;
        } while (border < size);

        int rand = 0;
        do {
            for (int i = 1; i <= bitNum; i++) {
                rand += (rand01(randomBox) << i);
            }

        } while (rand > size);
        return rand + min;

    }


}
