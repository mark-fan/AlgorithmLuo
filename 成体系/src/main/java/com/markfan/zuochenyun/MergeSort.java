package com.markfan.zuochenyun;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author luofan
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] ints = {1, 3, 5, 4, 9, 8, 6, 7};
//        mergeSort1(ints);
        mergeSort2(ints);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }


    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        process(arr, left, mid);
        process(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            help[i++] = arr[p1] >= arr[p2] ? arr[p2++] : arr[p1++];
        }
        //要么p1越界了  要么p2越界了
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[left + j] = help[j];
        }
    }

    //非递归方法
    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int length = arr.length;
        int mergeSize = 1; //merge步长
        while (mergeSize < length) {
            int l = 0;
            while (l < length) {
                // L...M 左组
                int m = l + mergeSize - 1;
                if (m >= length) {
                    break;
                }
                int r = Math.min(m + mergeSize, length - 1);
                merge(arr, l, m, r);
                l = r + 1;
            }
            if (mergeSize > length / 2) {
                break;
            }
            mergeSize <<= 1;
        }

    }
}
