package com.even.service.impl;

import com.even.service.StackService;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/12/17 0017.
 *
 * @author even
 * 栈的链实现方式
 */
public class LinkedStackServiceImpl<T> implements StackService<T>, Serializable {
    /**
     * 栈顶节点
     */
    private Node<T> top;
    private int size;
    public LinkedStackServiceImpl(){
        this.top=new Node<>();
    }
    public int size(){
        return size;
    }

    /**
     * 判断链栈是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return top==null||top.data==null;
    }

    /**
     * 压入一个元素到链栈
     * @param t
     */
    @Override
    public void push(T t) {
     if (t==null){
         throw new NullPointerException("data is null");
     }
     //调用pop()后top可能为null
     if(this.top==null){
         this.top=new Node(t);
     }else if(this.top.data==null){
         this.top.data=t;
     }else {
         Node<T> p=new Node<>(t,this.top);
         //更新栈顶
         top=p;
     }
     size++;

    }

    @Override
    public T peek() {
        if(isEmpty()){
            throw new NullPointerException("Stack empty");
        }
        return  top.data;
    }

    @Override
    public T pop() {
        if(isEmpty()){
            throw new NullPointerException("Stack empty");
        }
        T data=top.data;
        top=top.next;
        size--;
        return data;
    }
}
