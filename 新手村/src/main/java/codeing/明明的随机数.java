package codeing;

import java.util.Scanner;

/**
 * @author luofan
 */
public class 明明的随机数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 cas
            String a = in.nextLine();
            //十六进制
            System.out.println(Integer.valueOf(a.substring(2), 16));
        }
    }

    public static void convert(){
        int a = 100;
        //十进制转二进制
        System.out.println(Integer.toBinaryString(a));
        //十进制转八进制
        System.out.println(Integer.toOctalString(a));
        //十进制转十六进制
        System.out.println(Integer.toHexString(a));

        //Java更新到1.8 版本以后 其他进制转换为10进制有一个公用方法
        //Integer.valueOf("FFFF",进制数).toString()
        System.out.println(Integer.valueOf("x0aa",16));
    }
}
