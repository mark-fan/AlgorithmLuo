package codeing;

import java.util.ArrayList;
import java.util.List;

/**
 * 自除数 是指可以被它包含的每一位数整除的数。
 *
 * 例如，128 是一个 自除数 ，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * 自除数 不允许包含 0 。
 *
 * 给定两个整数 left 和 right ，返回一个列表，列表的元素是范围 [left, right] 内所有的 自除数
 * 思路：
 * 根据自除数的定义，如果一个整数不包含 00 且能被它包含的每一位数整除，则该整数是自除数。判断一个整数是否为自除数的方法是遍历整数的每一位，判断每一位数是否为 00 以及是否可以整除该整数。
 *
 * 遍历整数的每一位的方法是，每次将当前整数对 1010 取模即可得到当前整数的最后一位，然后将整数除以 1010。重复该操作，直到当前整数变成 00 时即遍历了整数的每一位
 * ----  来自官方
 * @author luofan
 */
public class SelfDividingNumbers {
    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(1, 20));
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (check(i)) {
                integers.add(i);
            }
        }
        return integers;
    }

    private static boolean check(int i) {
        int n = i;
        while (n > 0) {
            int r = n % 10;
            if (r == 0 || i % r != 0) {
                return false;
            }
            n /= 10;
        }
        return true;
    }
}
