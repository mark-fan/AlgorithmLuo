package com.markfan.zuochenyun;

/**
 * @author luofan
 */
public class NodeTest {

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
     * 链表实现栈：只有一个头指针 更加方法上下移动即可
     * 链表实现队列 使用头尾两个指针
     *
     * 数组实现栈：一个数组加一个index控制
     * 数组实现队列：* goole常考题 *  循环数组形成队列
     */

    public class DoubleEndsQuene<T>{
        public Node<T> head;
        public Node<T> tail;




        public class Node<T>{
            public T value;
            public Node next;

            public Node(T value) {
                this.value = value;
            }
        }

    }










}
