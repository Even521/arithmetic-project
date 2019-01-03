package com.even.binarytree;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Created by Administrator on 2018/12/19 0019.
 *
 * @author even
 * 二叉树节点
 */
@NoArgsConstructor
@AllArgsConstructor
public class BinaryNode<T> {
    /**
     * 左节点
     */
   public BinaryNode<T> left;
    /**
     * 又节点
     */
   public BinaryNode<T> right;
    /**
     * 元素
     */
   public T data;

    /**
     * data构造方法
     * @param data
     */
   public BinaryNode(T data) {
        this.data = data;
    }

    /**
     * 判断是否是叶子节点
     * @return
     */
    public boolean isLeaf(){
        return this.left==null&&this.right==null;
    }
}
