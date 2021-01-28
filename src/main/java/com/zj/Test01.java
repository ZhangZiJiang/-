package com.zj;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @program algorithm
 * @description:
 * @author: zhangbo
 * @create: 2021/01/25 18:06
 */
public class Test01 {


    //1000有序链表 合并成一个

    private LinkedList<Integer> helper(ArrayList<LinkedList<Integer>> array) {

        if (array.size() == 0) {
            return null;
        }

        int num = 0;
        int listSize = array.get(0).size();


        LinkedList<Integer> ret = new LinkedList<>();
        for (int a = 0; a < listSize; a++) {
            int[] arr = new int[array.size()];
            for (int i = 0; i < array.size(); i++) {
                LinkedList<Integer> list = array.get(i);

                if (listSize < list.size()) {
                    listSize = list.size();
                }

                if (list.get(num) != null) {
                    arr[i] = list.get(num);
                }

            }

            for (int i = 0; i < arr.length; i++) {
                for (int j = i; j < arr.length - i - 1; j++) {
                    if (arr[i] < arr[j]) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
            num++;
            for (int i = 0; i < arr.length; i++) {
                ret.add(arr[i]);
            }

        }

        return ret;

    }
}
