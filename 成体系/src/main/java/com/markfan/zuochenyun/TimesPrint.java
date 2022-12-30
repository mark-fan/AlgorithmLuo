package com.markfan.zuochenyun;

import java.util.HashMap;

/**
 * 一组arr数组中 只有一个数字 他出现了奇数次
 * <p>
 * 认识异或运算
 * 知识点：
 * 0^N = N
 * N^N = 0;
 * 抑或运算满足交换律和结合律
 *
 * @author luofan
 */
public class TimesPrint {
    public static void main(String[] args) {
        printTimeNums(new int[]{1, 2, 3, 4, 4, 3, 3, 3, 2, 1, 5});
        exchangeNum(5, 6);
        print1(6);
        printTimeNums(new int[]{1, 2, 3, 4, 4, 3, 2, 1, 5}, 1, 2);
    }

    /**
     * 如何不用额外数 交换两个数
     *
     * @param a
     * @param b
     */
    //异或运算效率高于加减
    public static void exchangeNum(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a);
        System.out.println(b);
    }

    /**
     * 在一个数组中  一个数出现了奇数次 其他数都出现了偶数次 怎么找到并打印这个数字
     */
    public static void printTimeNums(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        System.out.println(eor);
    }

    /**
     * 怎么把int数 最右边的1提取出来
     */
    public static void print1(int a) {
        int i = a & (-a);
        System.out.println(i);
    }


    /**
     * arr中 有两个数出现了奇数次,其他数出现了偶数次  怎么打印这两个数
     */
    public static void printTimeTwoNums(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            // 异或后就剩下两个奇数数  a!=b
            eor ^= arr[i];
        }
        //把最右边的1 提取出来；
        //eor   :001100101011000
        //right :000000000001000
        int right = eor & (~eor + 1);
        int eor1 = 0;
        for (int i = 0; i < arr.length; i++) {
            //eor   :001100101011000
            //right :000000000001000
            //把当前数组中数据的最右为1的数 异或到eor1中
            if ((arr[i] & right) != 1) {
                eor1 ^= arr[i];
            }
        }
        System.out.println(eor1 + "=====" + (eor ^ eor1));
    }


    /**
     * arr中 只有一个数出现了k次,其他数出现了M次, m>1   k<m  怎么打印出现了k次的值；
     */
    public static int printTimeNums(int[] arr, int k, int m) {
        int[] ints = new int[32];
        //ints[0] 表示0位置的1出现了几次
        //ints[1] 表示1位置的1出现了几次
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 32; j++) {
                ints[j] += ((arr[i] >> j) & 1);
            }
        }
        int ans = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] % m != 0) {
                ans |= 1 << i;
            }
        }
        return ans;
    }

    /**
     * 经典哈希
     */
    public static int printTimeNumshash(int[] arr, int k, int m) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
        }
        for (Integer integer : map.keySet()) {
            if(map.get(integer) ==k){
                return integer;
            }
        }
        return -1;
    }
}