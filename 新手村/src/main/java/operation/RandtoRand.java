package operation;


/**
 * 随机数=== 对数器
 */
public class RandtoRand {
    public static void main(String[] args) {
        double random = Math.random();//[0,1)
        int times = 100000000;
        int count = 0;
        for (int i = 0; i < times; i++) {
            if (Math.random() < 0.3) {
                count++;
            }
        }
        System.out.println((double) count / (double) times);


        System.out.println("```````````````````````````");

        count = 0;
        for (int i = 0; i < times; i++) {
            if (Math.random() * 8 < 4) {
                count++;
            }
        }
        System.out.println((double) count / (double) times);

        System.out.println("======================");

        count = 0;
        double x = 0.6;
        for (int i = 0; i < times; i++) {
            if (xToXPower2() < x) {
                count++;
            }
        }
        System.out.println((double) count / (double) times);

    }


    public static double xToXPower2() {
        return Math.max(Math.random(), Math.random());
    }

    public static double xToXPower3() {
        return Math.max(Math.random(), Math.max(Math.random(), Math.random()));
    }
}
