package operation;

public class num {

    public static void print32(int i) {
        for (int j = 31; j >= 0; j--) {
            System.out.print((i & (1 << j)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        print32(1);
//
//        int a = Integer.MIN_VALUE;
//        int b = ~a + 1;
//        System.out.println(a);
//        System.out.println(b);
//
//        print32(a);
//        print32(~a);
//        print32(b);
//        print32(0);
//        print32(~0);
//        print32(~0 + 1);
//        String string = Integer.toBinaryString(133);
//        System.out.println("二进制：" + string);
//        String string1 = Integer.valueOf(string, 2).toString();
//        System.out.println("十进制" + string1);

        int a = 6;
        int b = 4;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a=" + a + ";b=" + b);
        // 以上交换内存位置必须不一致 不然自身异或为0;

        /**
         * 一个数组中 有一种数出现了奇数次 其他数都出现了偶数次 怎么找出并打印这种数
         */
        int[] aa = {1, 2, 1, 3, 2, 2, 4, 3, 3, 4, 2};
        int temp = 0;
        for (int i = 0; i < aa.length; i++) {
            temp ^= aa[i];
        }
        System.out.println(temp);

        System.out.println(4^9);

        /**
         * 整型最右侧的1找出来
         */
        // 取反加1 再异或


    }

    /**
     * 输出2进制1的个数
     */
    public static int bit1Count(int N) {
        int count = 0;
        while (N != 0) {
            int rightOne = N & ((~N) + 1);
            count++;
            N ^= rightOne;
        }
        return count;
    }

}
