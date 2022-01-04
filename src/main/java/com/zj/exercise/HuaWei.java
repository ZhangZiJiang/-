package com.zj.exercise;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @program algorithm
 * @description:
 * @author: zhangbo
 * @create: 2021/01/23 22:57
 */
public class HuaWei {

    public static void main(String[] args) {

        System.out.println((int) 'z');
        HuaWei huaWei = new HuaWei();
        System.out.println(huaWei.helper("sdff"));

    }

    private String helper(String str) {
        if (str == null) {
            return null;
        }

        char[] a = new char[str.length()];
        str.getChars(0, str.length(), a, 0);


        //97-122
        ArrayList<Integer> list = new ArrayList(24);
        for (int i = 0; i < 25; i++) {
            list.add(0);
        }

        for (int i = 0; i < a.length; i++) {
            list.add(0);
            Integer val = list.get(a[i] - 97);
            list.add(a[i] - 97, ++val);
        }

        int mark = 0;
        StringBuilder ret = new StringBuilder();
        //找到最多数量
        for (int i = 0; i < 25; i++) {
            if (list.get(i) > mark) {
                mark = list.get(i);
            }
        }

        for (int i = 0; i < 25; i++) {
            if (list.get(i) == mark) {
                for (int j = 0; j < mark; j++) {
                    ret.append((char) (i + 97));
                }
            }
        }

        return ret.toString().length() == str.length() ? null : ret.toString();
    }
}
