package com.even.service.impl;

import com.even.service.StackService;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 顺序栈的实现伪代码 JDK实现Stack是继承Vector
 * @param <T>
 * @author even
 */
public class SeqStackServiceImpl<T> implements StackService<T>,Serializable {
    /**
     * 栈顶指针，-1代表空栈
     */
    private int top=-1;
    /**
     * 初始容量设置10
     */
    private int capacity=10;
    /**
     * 存放元素的素组
     */
    private  T[] array;
    /**
     * 大小
     */
    private int size;

    /**
     * size
     * @return
     */
    public  int size(){
        return size;
    }


    public SeqStackServiceImpl(int capacity){
        array= (T[]) new Object[capacity];
    }

    public SeqStackServiceImpl() {
        array= (T[]) new Object[this.capacity];
    }

    /**
     * 判断栈是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return this.top==-1;
    }

    /**
     * 压入一个元素到栈内
     * @param t
     */
    @Override
    public synchronized void push(T t) {
        //判断容量是否满足
        if (array.length==size){
            ensureCapacity(size*2-1);
        }
        //从栈顶压入一个元素
        array[++top]=t;
        //栈元素个数加1
        size++;
    }

    /**
     * 扩容
     * @param capacity
     */
    public void ensureCapacity(int capacity){
        //如果需要扩展的容量比现在的数组容量还小则无需扩容
        if(capacity<size){
            return;
        }
        //扩容前的数组大小如果已经达到最大(2^30)了
        if (capacity ==  Integer.MAX_VALUE ) {
            //修改阈值为int的最大值(2^31-1)，这样以后就不会扩容了
            size = Integer.MAX_VALUE-1;
        }

        T[] oldArray=array;
        //复制数组
        array=Arrays.copyOf(oldArray,capacity);
    }

    /**
     * 获取栈顶元素的值
     * @return
     */
    @Override
    public  synchronized T peek() {
        //栈为空抛出异常
        if(isEmpty()){
            throw new RuntimeException("this stack empty");
        }
        return array[top];
    }

    @Override
    public  synchronized T pop() {
        if(isEmpty()){
            throw new RuntimeException("Stack empty");
        }
        size--;
        return array[top--];
    }


}
