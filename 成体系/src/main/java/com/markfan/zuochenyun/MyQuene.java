package com.markfan.zuochenyun;

/**
 * 给一个limit长度的数组建立队列长度
 * @author luofan
 */
public class MyQuene {
    private int[] arr;
    private int pushi;//添加数据的位置
    private int popi; //删除数据的位置
    private int size; //控制队列大小 是否可以添加删除数据
    private int limit;

    public MyQuene(int limit) {
        this.arr = new int[limit];
        this.pushi = 0;
        this.popi = 0;
        this.size = 0;
        this.limit = limit;
    }

    public void pushI(int num) {
        if (size >= limit) {
            throw new RuntimeException("队列满了，不能再加了");
        }
        size++;
        arr[pushi] = num;
        pushi = runIndex(pushi);
    }


    public int popi() {
        if(size == 0){
            throw new RuntimeException("队列空了，不能再拿了");
        }
        size--;
        int res = arr[popi];
        popi = runIndex(popi);
        return res;
    }

    // 假如到了最大的时候就跳到0
    private int runIndex(int cycleNum) {
        return cycleNum < limit ? cycleNum + 1 : 0;
    }

}
