package com.even;

import java.util.*;

/**
 * Created by Administrator on 2019/1/3 0003.
 *
 * @author even
 */
public class Test {
     /**
      *机器节点IP前缀
      */
    private static final String IP_PREFIX = "192.168.0.";
    /**
     * 每台真实机器节点上保存的记录条数
     */
    Map<String, Integer> map = new HashMap<>();
    /**
     * 真实物理节点
     */

    List<Node> realNodes = new ArrayList<>();
    @org.junit.Test
    public void ConHashTest(){

        HashFunction hashFunction = new HashFunctionImpl();
        for (int i = 1; i <= 10; i++) {
            // 每台真实机器节点上保存的记录条数初始为0
            map.put(IP_PREFIX + i, 0);
            Node  node= Node.builder().ip(IP_PREFIX + i)
                     .name("node" + i)
                     .build();
            realNodes.add(node);
        }
        ConsistentHash consistentHash = new ConsistentHash(hashFunction,100,realNodes);
        // 将10000条记录尽可能均匀的存储到10台机器节点
        for (int i = 0; i < 10000; i++) {
            // 产生随机一个字符串当做一条记录，可以是其它更复杂的业务对象,比如随机字符串相当于对象的业务唯一标识
            String data = UUID.randomUUID().toString() + i;
            // 通过记录找到真实机器节点
            Node  node = consistentHash.get(data);
            // 这里可以通过其它工具将记录存储真实机器节点上，比如MemoryCache等
            // ...
            // 每台真实机器节点上保存的记录条数加1
            map.put(node.getIp(), map.get(node.getIp()) + 1);
        }
        // 打印每台真实机器节点保存的记录条数
        for (int i = 1; i <= 10; i++) {
            System.out.println(IP_PREFIX + i + "节点记录条数：" + map.get("192.168.0." + i));
        }


    }
}
