package com.even.service;

/**
 * 栈(先进后出)
 * @param <T>
 * @author even
 */
public interface StackService<T> {
    /**
     * 判断栈是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 元素入栈
     * @param t
     */
    void push(T t);

    /**
     * h
     * @return
     */
    T peek();

    T pop();

}
