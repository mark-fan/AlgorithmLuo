package operation;

import java.util.TreeMap;

public class HashMapAndTreeMap {


    public static class Node{
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }


    public static void main(String[] args) {
        // O(logN)
        // TreeMap key必须是可以比较的  若是自己使用对象  就自己定义如何比较  定义比较器
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(0,"我是谁");
        map.put(2,"我是谁");
        map.put(3,"我是谁");
        map.put(5,"我是谁");
        map.put(9,"我是谁");
        System.out.println(map.containsKey(3));
        System.out.println(map.containsKey(4));
        System.out.println(map.firstKey());
        System.out.println(map.lastKey());
        System.out.println(map.lastEntry());
        System.out.println(map.ceilingKey(3));

    }
}
