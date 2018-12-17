package com.even.doub;

import com.even.ILinkedList;

/**
 * Created by Administrator on 2018/12/17 0017.
 *
 * @author even
 */
public class HeadDoubleILinkedList<T> implements ILinkedList<T> {
    /**
     *  不带数据的头结点
     */
    protected DNode<T> head;
    /**
     * 指向尾部的指针
     */
    protected DNode<T> tail;

    /**
     * 初始化头结点
     */
    public HeadDoubleILinkedList(){
        this.head =this.tail= new DNode<>();
    }

    /**
     * 传入一个数组,转换成链表
     * @param array
     */
    public HeadDoubleILinkedList(T[] array)
    {
        this();
        if (array!=null && array.length>0)
        {
            this.head.next = new DNode<T>(array[0]);
            tail =this.head.next;
            tail.prev=this.head;
            int i=1;
            while (i<array.length)
            {
                tail.next=new DNode<T>(array[i++]);
                tail.next.prev=tail;
                tail = tail.next;
            }
        }
    }


    /**
     * 头结点的next为空则表示空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return head.next==null;
    }

    /**
     * 长度计算
     * @return
     */
    @Override
    public int length() {
        int length=0;
        DNode<T> pre=head.next;
        while (pre!=null){
            length++;
            pre=pre.next;
        }
        return length;
    }

    @Override
    public T get(int index) {
        if (index>=0)
        {
            DNode<T> pre=this.whileDNode(index);
            if (pre!=null) {
                return pre.data;
            }
        }
        return null;
    }

    public DNode<T> whileDNode(int index){
        int j=0;
        DNode<T> pre=this.head.next;
        while (pre!=null && j<index)
        {
            j++;
            pre=pre.next;
        }
        return pre;
    }

    @Override
    public T set(int index, T data) {
        T old=null;
        if (index>0&&data!=null){
            DNode<T> pre=this.whileDNode(index);
            if (pre!=null){
                old=pre.data;
                //替换数据
                pre.data=data;
            }
        }
        return old;

    }

    @Override
    public boolean add(int index, T data) {
        if(index<0||data==null){
            throw new NullPointerException("index or data is null");
        }
        int i=0;
        DNode<T> front=this.head;
        //查找要插入结点位置的前一个节点
        while (front.next!=null&&i<index){
            i++;
            front=front.next;
        }
        //创建需要插入的结点,并让其前继指针指向front,后继指针指向front.next
        DNode<T> q = new DNode<T>(data, front, front.next);
        //空双链表插入和尾部插入，无需此操作
        if(front.next != null) {
            //更改front.next的前继指针
            front.next.prev = q;
        }
        //更改front的后继指针
        front.next = q;

        //在尾部插入时需要注意更新tail指向
        if(front==this.tail){
            this.tail=q;
        }
        return true;
    }

    @Override
    public boolean add(T data) {
        if (data==null) {
            return false;
        }
        //创建新结点,并把其前继指针指向tail
        DNode<T> q = new DNode<T>(data, tail, null);
        tail.next=q;
        //更新尾部结点
        this.tail=q;
        return true;

    }

    @Override
    public T remove(int index) {
        int size=length();
        T temp=null;

        if(index<0||index>=size||isEmpty()){
            return temp;
        }

        DNode<T> p=this.head;
        int j=0;
        //头删除/尾删除/中间删除,查找需要删除的结点(要删除的当前结点因此i<=index)
        while (p!=null&&j<=index){
            p=p.next;
            j++;
        }
        //当链表只要一个结点时,无需此步
        if(p.next!=null){
            p.next.prev=p.prev;
        }
        p.prev.next=p.next;
        //如果是尾结点
        if (p==this.tail) {
            //更新未结点的指向
            this.tail = p.prev;
        }
        temp=p.data;

        return temp;
    }

    @Override
    public boolean removeAll(T data) {
        boolean isRemove=false;

        if(data==null||isEmpty()){
            return isRemove;}

        //注意这里的起点,如果起点为this.head,那么情况区别如同前面的根据index的删除实现
        DNode<T> p=this.head.next;

        //头删除/尾删除/中间删除(size>1),查找所有需要删除的结点
        while (p!=null){

            if(data.equals(p.data)){
                if (p==this.tail){
                    //如果是尾结点
                    //更新未结点的指向
                    this.tail=p.prev;
                    p.prev=null;
                    this.tail.next=null;
                }else {
                    //如果是在中间删除,更新前继和后继指针指向
                    p.prev.next=p.next;
                    p.next.prev=p.prev;
                }
                isRemove=true;
                //继续查找
                p=p.next;
            }else {
                p=p.next;
            }

        }
        return isRemove;
    }

    @Override
    public void clear() {
        this.head.next=null;
        this.tail=this.head;
    }

    @Override
    public boolean contains(T data) {
        if(data==null){
            return false;
        }

        DNode<T> p=this.head.next;
        while (p!=null){
            if (data.equals(p.data)){
                return true;
            }else {
                p=p.next;
            }
        }

        return false;
    }

    @Override
    public String tostring() {
        String str="(";
        DNode<T> pre = this.head.next;
        while (pre!=null)
        {
            str += pre.data;
            pre = pre.next;
            if (pre!=null){
                str += ", ";
            }
        }
        return str+")";
    }
}
