package com.zj.base;

/**
 * @program algorithm
 * @description: 归并排序
 * @author: zhangbo
 * @create: 2021/01/25 12:33
 */
public class MergeSort {


    private void sort(int[] arr) {
        int mid = arr.length >> 1;

        int[] sortArr = new int[arr.length];

        int i = 0;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j < arr.length) {
            if (arr[i] <= arr[j]) {
                sortArr[k] = arr[i];
                i++;
            } else {
                sortArr[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i <= mid) sortArr[k++] = arr[i++];
        while (j < arr.length) sortArr[k++] = arr[j++];
    }


    private void mergeSort(int[] arr, int left, int mid, int right, int[] temp) {

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j < right) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j < right) temp[k++] = arr[j++];

        //将新数组全部拷贝到原数组中
        k = 0;
        while (left <= right) arr[left++] = temp[k++];

    }

    private void merge(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + (right - left) >> 1 );

            merge(arr, left, mid, temp);
            merge(arr, mid + 1, right, temp);
            mergeSort(arr, left, mid, right, temp);
        }
    }
}
