package com.even.binarytree;

import com.even.binarytree.BinaryNode;

/**
 * Created by Administrator on 2018/12/19 0019.
 *
 * @author even
 *
 */
public interface ITree<T> {
    /**
     * 判断空
     * @return
     */
    boolean isEmpty();

    /**
     * 二叉树的节点个数
     * @return
     */
    int size();

    /**
     * 二叉树高度
     * @return
     */
    int height();

    /**
     * 先根次序遍历
     *
     * @return
     */
    String preOrder();

    /**
     * 中根次序遍历
     */
    String inOrder();

    /**
     * 后根次序遍历
     */
    String postOrder();

    /**
     * 层次遍历
     */
    String levelOrder();

    /**
     * 将data 插入
     * @return
     */
    void insert(T data);


    /**
     * 删除
     */
    void remove(T data);

    /**
     * 查找最大值
     * @return
     */
    T findMin();

    /**
     * 查找最小值
     * @return
     */
    T findMax();

    /**
     * 根据值找到结点
     * @param data
     * @return
     */
    BinaryNode findNode(T data);

    /**
     * 是否包含某个值
     * @param data
     * @return
     */
    boolean contains(T data) throws Exception;


    /**
     * 清空
     */
    void clear();

}
