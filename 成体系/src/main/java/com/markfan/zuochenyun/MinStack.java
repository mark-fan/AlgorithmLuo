package com.markfan.zuochenyun;

import java.util.Stack;

/**
 * @author luofan
 */
public class MinStack {
    Stack noramlStack = new Stack<Integer>();
    Stack minStack = new Stack<Integer>();

    public void push(int num) {
        // 正常stack 正常加
        noramlStack.push(num);
        //每次push 最新的值 同步加 同步弹出  怎么拿到最小的值？
        if (minStack == null || Integer.parseInt(minStack.peek().toString())> num) {
            minStack.push(num);
        }else{
            minStack.push(minStack.peek());
        }
    }

    public Object pop(){
        minStack.pop();
        return noramlStack.pop();
    }

    public Object popMin(){
        noramlStack.pop();
        return minStack.pop();
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.push(7);
        System.out.println(minStack.popMin());
    }

}
