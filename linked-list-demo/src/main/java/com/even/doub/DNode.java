package com.even.doub;

/**
 * Created by Administrator on 2018/12/17 0017.
 *
 * @author even
 * 双链表节点
 */

public class DNode<T> {
    /**
     * 元素
     */
    public  T data;
    /**
     * 元素前继指针
     * 元素后续指针
     */
    public DNode<T> prev,next;

    public DNode(T data, DNode<T> prev, DNode<T> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public DNode(T data) {
        this(data, null, null);
    }

    public DNode() {
    }

    @Override
    public String toString()
    {
        return this.data.toString();
    }
}
