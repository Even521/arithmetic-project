package com.even;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

/**
 * Created by Administrator on 2018/12/18 0018.
 *
 * @author even
 */
public class SeqQueueTest {
    @Test
    public void seqQueueTest(){
        SeqQueue<String> stringSeqQueue=new SeqQueue<>();
        stringSeqQueue.offer("A");
        stringSeqQueue.offer("B");
        stringSeqQueue.offer("C");

        System.out.println("队列大小-> "+stringSeqQueue.size());
        IntStream.range(0,stringSeqQueue.size())
                .mapToObj(
                        i->stringSeqQueue.poll()).forEach(
                           System.out::println
        );
    }
}
