package operation;

/**
 * 单链表实现 队列&栈
 */
public class LinkedListQueneAndStack {
    public static class Node<V> {
        public V value;
        public Node<V> next;

        public Node(V v) {
            this.value = v;
            this.next = null;
        }
    }

    public static class MyQuene<V> {

        private Node<V> head;
        private Node<V> tail;
        private int size;

        public MyQuene() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        private void offer(V value) {
            Node<V> cur = new Node<V>(value);
            // 假如第一个进来 链表为空 首节点 和 尾节点 都指向第一个
            if (cur == null) {
                head = cur;
                tail = cur;
            } else {
                // 再进来当前值的都会是尾节点，尾巴就是当前值 总结 每进来一个 尾节点都会指向进来的节点 且进来的点为尾节点
                cur.next = tail;
                tail = cur;
            }
            size++;
        }

        private V poll() {
            V ans = null;
            if (head != null) {
                ans = head.value;
                head = head.next;
                // 不用关注head的后指针  jvm会回收  C/C++自己回收
                size--;
            }
            // 当头节点已经为null  尾节点保持和头节点一致  防止尾节点还有指向 出现脏数据
            if (head == null) {
                tail = null;
            }
            return ans;
        }


        private V peek() {
            V ans = null;
            if (head != null) {
                ans = head.value;
            }
            return ans;
        }
    }

    public static class MyStack<V> {
        public int size;
        public Node<V> head;

        public MyStack() {
            this.size = 0;
            head = null;
        }


        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void push(V value) {
            Node<V> cur = new Node<>(value);
            if (head == null) {
                head = cur;
            } else {
                cur.next = head;
                head = cur;
            }
            size++;
        }


        public V pop() {
            V ans = null;
            if (head != null) {
                ans = head.value;
                head = head.next;
                size--;
            }
            return ans;
        }
    }

}
