package com.zj.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @program algorithm
 * @description:
 * @author: zhangbo
 * @create: 2021/01/20 21:17
 */
public class Four {

    public static void main(String[] args) {

    }
    static int[][] twoSum(int[] numbers) {

        int mark = 0;

        if(numbers.length == 0){
            return new int[0][0];
        }

        int[][] ret = new int[2][50];
//        ArrayList<int[2]>

        HashMap<Integer, Integer> map = new HashMap<>();
        int size = numbers.length;
        for (int i = 0; i < size; i++) {
            map.put(numbers[i], i);
        }
        for (int i = 0; i < size; i++) {
            int key = 100 - numbers[i];
            if(map.containsKey(key)){
                //存储 i, 和 map.get(key);
                ret[mark][0] = i;
                ret[mark][1] = map.get(key);
                mark++;
            }
        }
        return ret;

    }


    /**
     * 满足条件 intervals[i][0] <= intervals[i][1]。
     * @param intervals
     * @return
     */
    static int[][] merge(int[][] intervals) {
        if(intervals.length == 0 || intervals[0].length == 0){
            return new int[0][0];
        }
        int row = intervals[0][0];
        int col = intervals[1][0];

        int[][] ret = new int[row][col];
        int size = intervals[2].length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if(intervals[2][i] < intervals[2][j]){
                    int mark = intervals[2][i];
                    intervals[2][i] = intervals[2][j];
                    intervals[2][j] = mark;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            if(i < (size >> 1)){
                ret[i][0] = intervals[2][i];
            } else {
                ret[i][1] = intervals[2][i];
            }

        }

        return ret;
    }
}
