package com.even.redblacktree;

/**
 * Created by Administrator on 2019/1/3 0003.
 *
 * @author even
 * 红黑树具有以下性质：
 * (1) 每个结点是红色或是黑色
 * (2) 根结点是黑色的
 * (3) 如果一个结点是红色的，则它的两个儿子都是黑色的
 * (4) 对于每个结点，从该结点到其子孙结点的所有路径上包含相同数目的黑结点
 * 通过红黑树的性质，可以保证所有基于红黑树的实现都能保证操作的运行时间为对数级别（范围查找除外。它所需的额外时间和返回的键的数量成正比）
 */
public class RedBlackTree<T> {
    /**
     * 根节点
     */
    private RedBlackNode root;
    private static final boolean RED = false;
    private static final boolean BLACK = true;

    /**
     *  节点左旋方法,将当前节点变为其右子树的左子树
     */
    private void leftRotate(RedBlackNode x){
        //将当前节点的右子数存储起来
        RedBlackNode y=x.getRight();
        x.setRight(y.getLeft());


    }
}
