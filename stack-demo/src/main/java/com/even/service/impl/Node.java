package com.even.service.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Administrator on 2018/12/17 0017.
 *
 * @author even
 * 单向链表节点
 */
@AllArgsConstructor
@NoArgsConstructor
public class Node<T> {
    /**
     * 元素
     */
    public T data;
    /**
     * 下一个节点
     */
    public Node<T> next;

    /**
     * data构造方法
     * @param data
     */
    public Node(T data){
        this.data=data;
    }


}
