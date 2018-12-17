package com.even.service;

import com.even.service.impl.LinkedStackServiceImpl;
import com.even.service.impl.SeqStackServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

/**
 * Created by Administrator on 2018/12/17 0017.
 *
 * @author even
 */
public class TestDemo {

    /**
     * 顺序栈测试
     */
    @Test
    public void  seqStackServiceImplTest(){
        SeqStackServiceImpl<String> s=new SeqStackServiceImpl<>();
        s.push("A1");
        s.push("A2");
        s.push("A3");
        s.push("A4");
        s.push("A5");
        s.push("A6");
        s.push("A7");
        s.push("A8");
        s.push("A9");
        s.push("A10");
        s.push("A11");
        int l=s.size();
        System.out.println("大小size->"+( s.size()));
        System.out.println("栈顶s.peek->"+s.peek());
        IntStream.range(0, l).mapToObj(i -> "出栈顺序s.pop->" + s.pop()).forEachOrdered(System.out::println);
    }
    @Test
    public void linkedStackTest(){
        LinkedStackServiceImpl<Integer> s=new LinkedStackServiceImpl<>();
        s.push(1);
        s.push(2);
        s.push(3);
        int length=s.size();
        IntStream.range(0,length).mapToObj(i->"出栈顺序s.pop->"+s.pop()).forEachOrdered(System.out::println);
    }
}
