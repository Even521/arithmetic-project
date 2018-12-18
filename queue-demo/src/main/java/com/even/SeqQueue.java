package com.even;

import java.io.Serializable;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Queue;


/**
 * Created by Administrator on 2018/12/18 0018.
 *
 * @author even
 * 顺序队列 数组
 * 只是伪代码，便于理解队列基本实现原理，并没有实现线程安全不能用于实际应用中。
 */
public class SeqQueue<T> implements IQueue<T>, Serializable {
    /**
     * 数组默认初始值10
     */
    private static final int DEFAULT=10;
    /**
     * 数组
     */
    private T data[];
    /**
     * 队头元素下标值
     */
    private int front;
    /**
     * 指向下一个入队的下标
     */
    private int rear;
    /**
     * 队列大小
     */
    private int size;

    public SeqQueue(){
        data=(T[]) new Object[DEFAULT];
        front=rear=0;
    }
    public SeqQueue(int capacity){
        data= (T[]) new Object[capacity];
        front=rear=0;
    }
    @Override
    public int size() {
        return size;
    }

    /**
     * 当front==rear时，队列为null
     * @return
     */
    @Override
    public boolean isEmpty() {
        return front==rear;
    }

    /**
     * 元素入队,成功true否则为false
     * @param data
     * @return
     */
    @Override
    public boolean add(T data) {
        //判断队列是否满队，满了则要扩容
        if(this.isFull()){
           this.ensureCapacity(this.data.length*2+1);
        }
        insertData(data);
        return true;
    }
    /**
     * 扩容的方法
     * @param capacity
     */
    public void ensureCapacity(int capacity) {
        //如果需要拓展的容量比现在数组的容量还小,则无需扩容
        if (capacity<size) {
            return;
        }
        T[] old = data;
        data= Arrays.copyOf(old,capacity);
        //恢复front,rear指向
        this.front=0;
        this.rear=0;
    }

    @Override
    public boolean offer(T data) {
        if (data==null) {
            throw new NullPointerException("The data can\'t be null");
        }
        //队满抛出异常
        if (isFull()){
            throw new IllegalArgumentException("The capacity of SeqQueue has reached its maximum");
        }

        //添加data
        insertData(data);
        return true;

    }
    /**
     * 判断队列是否满
     * 求余法
     */
    private boolean isFull(){
        return this.front==(this.rear+1)%this.data.length;
    }

    private void insertData(T data){
        this.data[this.rear]=data;
        //更新rear指向下一个空元素的位置
        this.rear=(this.rear+1)%this.data.length;
        size++;
    }

    /**
     * 返回队头元素,不执行删除操作,若队列为空,返回null
     * @return
     */
    @Override
    public T peek() {
        return data[front];
    }

    /**
     * 返回队头元素,不执行删除操作,若队列为空,抛出异常:NoSuchElementException
     * @return
     */
    @Override
    public T element() {
        if(isEmpty()){
            throw new NoSuchElementException("The SeqQueue is empty");
        }
        return peek();
    }
    /**
     * 出队,执行删除操作,返回队头元素,若队列为空,返回null
     * @return
     */
    @Override
    public T poll() {
        T temp=this.data[this.front];
        this.front=(this.front+1)%this.data.length;
        size--;
        return temp;
    }
    /**
     * 出队,执行删除操作,若队列为空,抛出异常:NoSuchElementException
     * @return
     */
    @Override
    public T remove() {
        if (isEmpty()){
            throw new NoSuchElementException("The SeqQueue is empty");
        }
        return poll();
    }

    /**
     * 清空队列
     */
    @Override
    public void clearQueue() {
        for (int i=this.front; i!=this.rear ; i=(i+1)%this.data.length) {
           data[i] = null;
        }
        //复位
        this.front=this.rear=0;
        size=0;
    }
}
