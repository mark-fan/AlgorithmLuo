package operation;

import java.util.HashMap;
import java.util.List;

public class MergeUser {


    public static class User{
        public String a;
        public String b;
        public String c;

        public User(String a, String b, String c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static class Node<V>{
        public V v;

        public Node(V v) {
            this.v = v;
        }
    }

    public static class UnionSet<V>{
        public HashMap<V,Node<V>> nodes;
        public HashMap<Node<V>,Node<V>> parents;
        public HashMap<Node<V>,Integer> sizeMap;

        public UnionSet(List<V> nodes) {
            Node<Object> cur = new Node<>(nodes);

        }
    }

}
