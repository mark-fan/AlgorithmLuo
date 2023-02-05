package operation;

public class ReserveList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }


    public static class DoubleNode {
        public int value;
        public DoubleNode next;
        public DoubleNode last;

        public DoubleNode(int value) {
            this.value = value;
        }
    }


    public static void main(String[] args) {

    }

    /**
     * 翻转单链表
     *
     * @param head
     * @return
     */
    public static Node reserveLinkedList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 翻转双链表
     *
     * @param head
     * @return
     */
    public static DoubleNode reserveDoubleLinkedList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

}
