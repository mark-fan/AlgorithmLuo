package com.markfan.zuochenyun;

import java.util.LinkedList;

/**
 * 使用双队列实现栈的功能
 * @author luofan
 */
public class Code01_TwoQueneImplStack {

    public static class TwoQueneStack {
        private LinkedList<Object> quene;
        private LinkedList help;

        public TwoQueneStack() {
            quene = new LinkedList<>();
            help = new LinkedList<>();
        }

        public void push(Object value) {
            quene.offer(value);
        }

        public Object poll() {
            //队列中剩下一个之前都把数据塞到help中去
            while (quene.size() > 1) {
                help.offer(quene.poll());
            }
            Object ans = quene.poll();
            LinkedList temp = quene;
            quene = help;
            help = temp;
            return ans;
        }

        public Object peek() {
            while (quene.size() > 1) {
                help.offer(quene.poll());
            }
            Object ans = quene.poll();
            //peek 就把最后的数据拿到再塞到help队列中去
            help.offer(ans);
            LinkedList temp = quene;
            quene = help;
            help = temp;
            return ans;
        }
    }

    public static void main(String[] args) {
        TwoQueneStack twoQueneStack = new TwoQueneStack();
        twoQueneStack.push(1);
        twoQueneStack.push(2);
        twoQueneStack.push(3);
        System.out.println(twoQueneStack.poll());
    }


}
