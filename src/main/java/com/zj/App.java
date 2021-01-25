package com.zj;


import java.util.ArrayList;

/**
 * Hello world!
 */
public class App {


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();
        list.add(1);
        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(arr.length);
    }

}
