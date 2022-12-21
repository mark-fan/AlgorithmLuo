package leecode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author luofan
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String firstLine = sc.nextLine();
            List<String> inputList = new ArrayList<>();
            for (int i = 0; i < Integer.valueOf(firstLine); i++) {
                inputList.add(sc.nextLine());
            }
            List<List<String>> objects = new ArrayList<>();
            for (int i = 0; i < inputList.size(); i++) {
                ArrayList<String> strings = new ArrayList<>();
                for (int j = i+1; j < inputList.size(); j++) {
                    if(containRepeat(inputList.get(i),inputList.get(j))){
                        String[] s = inputList.get(i).split(",");
                        String[] s1 = inputList.get(j).split(",");
                        strings.addAll(Arrays.asList(s));
                        strings.addAll(Arrays.asList(s1));

                        List<String> collect = strings.stream().sorted(Comparator.comparingInt(value -> Integer.valueOf(value))).distinct().collect(Collectors.toList());
                        objects.add(collect);
                    }
                }
                String[] s = inputList.get(i).split(",");
                strings.addAll(Arrays.asList(s));
                List<String> collect = strings.stream().sorted(Comparator.comparingInt(value -> Integer.valueOf(value))).distinct().collect(Collectors.toList());
                objects.add(collect);


            }
            System.out.println(objects);
        }
    }


    public static boolean containRepeat(String str, String str1) {
        String[] arr1 = str.split(",");
        String[] arr2 = str1.split(",");
        if(arr1.length==0||arr2.length==0){
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i].equals(arr2[j])) {
                    return true;
                }
            }
        }
        return false;
    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        Map<Integer, Integer> datamode = new HashMap<>();
//        while(sc.hasNextLine()){
//            String firstLine = sc.nextLine();
//            String[] s = firstLine.split(" ");
//            int kuan = Integer.parseInt(s[0]);
//            int chang = Integer.parseInt(s[1]);
//            int yaoqiu = Integer.parseInt(s[2]);
//            int target = Integer.parseInt(s[3]);
//
//            for (int i = 0; i < kuan; i++) {
//                String[] s1 = sc.nextLine().split(" ");
//                for (int j = 0; j < s1.length; j++) {
//                    datamode.put(j,datamode.getOrDefault(j,0)+Integer.valueOf(s1[j]));
//                }
//            }
//            System.out.println(datamode);
//           int n = chang;
//            int k = yaoqiu;
//            int[] sum = new int[n];
//            sum[0] = datamode.get(0);
//            for (int i = 1; i < n; i++) {
//                sum[i] = sum[i-1] + datamode.get(i);
//            }
//            k--;
//            int[] res = new int[n - k];
//            for (int i = k; i < n; i++) {
//                res[i-k] = sum[i]-sum[i-k]+datamode.get(i-k);
//            }
//            for (int i = 0; i < res.length; i++) {
//                System.out.println(res[i]);
//
//            }
//            int jieguo = 1;
//            for (int i = 0; i < res.length; i++) {
//                if( res[i]  >= target){
//                    jieguo++;
//                }
//
//            }
//
//            System.out.println(jieguo);
//        }
//
//    }
}
