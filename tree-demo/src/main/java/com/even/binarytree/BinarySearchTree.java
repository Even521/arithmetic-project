package com.even.binarytree;


/**
 * Created by Administrator on 2018/12/19 0019.
 *
 * @author even
 */
public class BinarySearchTree<T> implements ITree<T> {


    /**
     * 根节点
     */
    protected BinaryNode<T> root;

    /**
     * 初始根节点为null
     */
    public BinarySearchTree(){
        root =null;
    }

    @Override
    public boolean isEmpty() {
        return root==null;
    }

    @Override
    public int size() {
        return getSize(root);
    }

    /**
     * 递归实现：定义根节点root后，再用subtree实现递归
     * @param subtree
     * @return
     */
    private int getSize(BinaryNode<T> subtree){
        if (subtree==null){
            return 0;
        }
        //对比汉诺塔：H(n)=H(n-1)+1+H(n-1)
        return getSize(subtree.left)+1+getSize(subtree.right);
    }

    @Override
    public int height() {
        return 0;
    }

    /**
     * 递归实现
     * @param subtree
     * @return
     */
    private int getHeight(BinaryNode<T> subtree){
        if (subtree==null){
            return 0;
        }
        else {
            int l=getHeight(subtree.left);
            int r=getHeight(subtree.right);
            return (l>r)?(l+1):(r+1);
        }
    }


    @Override
    public String preOrder() {
        return null;
    }

    @Override
    public String inOrder() {
        return null;
    }

    @Override
    public String postOrder() {
        return null;
    }

    @Override
    public String levelOrder() {
        return null;
    }

    @Override
    public void insert(T data) {

    }

    @Override
    public void remove(T data) {

    }

    @Override
    public T findMin() {
        return null;
    }

    @Override
    public T findMax() {
        return null;
    }

    @Override
    public BinaryNode findNode(T data) {
        return null;
    }

    @Override
    public boolean contains(T data) throws Exception {
        return false;
    }

    @Override
    public void clear() {

    }
}
