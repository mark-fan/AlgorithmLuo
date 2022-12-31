package com.markfan.zuochenyun;

/**
 * @author luofan
 */
public class NodeTest {
    public static void main(String[] args) {

    }

    /**
     * 翻转单链表
     *
     * @param head
     * @return
     */
    public static Node reverserNode(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return head;
    }

    /**
     * 翻转双链表
     *
     * @param head
     * @return
     */
    public static DoubleNode reverserDoubleNode(DoubleNode head) {
        return null;
    }

    /**
     * 删除链表中的值
     *
     * @param head
     * @param num
     * @return
     */
    public static Node removeNode(Node head, int num) {
        while (head != null) {
            if (head.value != num) {
                break;
            }
            head = head.next;
        }
        //1. head ==null
        //2. head !=null
        Node pre = head;
        Node cur = head;
        while (cur != null) {
            if (cur.value == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    /**
     * 栈
     * 队列
     *
     * 栈：先进后出
     * 队列：先进先出 排队执行
     * 要求： 使用数组 and 链表完成栈 和队列
     *
     */

}
