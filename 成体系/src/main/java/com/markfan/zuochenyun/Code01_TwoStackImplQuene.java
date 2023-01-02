package com.markfan.zuochenyun;

import java.util.Stack;

/**
 * 双栈实现队列的功能
 * @author luofan
 */
public class Code01_TwoStackImplQuene {

    public static class TwoStackQuene{
        private Stack pushStack;
        private Stack popStack;

        public TwoStackQuene() {
            pushStack = new Stack();
            popStack = new Stack();
        }

        public void push(Object value){
            pushStack.push(value);
            pushToPop();
        }

        public Object poll(){
            if(pushStack.empty()&&popStack.empty()){
                throw new RuntimeException("队列空了");
            }
            pushToPop();
            return popStack.pop();
        }

        public Object peek(){
            if(pushStack.empty()&&popStack.empty()){
                throw new RuntimeException("队列空了");
            }
            pushToPop();
            return popStack.peek();
        }
        // 只有当pop栈空了的时候才可以往里放数据
        private void pushToPop() {
            if (popStack.isEmpty()) {
                while(!pushStack.empty()){
                    popStack.push(pushStack.pop());
                }
            }
        }
    }

}
