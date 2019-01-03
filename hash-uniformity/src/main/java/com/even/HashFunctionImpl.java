package com.even;

/**
 * Created by Administrator on 2019/1/3 0003.
 *
 * @author even
 *
 * （1）String重写的hashCode()方法在一致性Hash算法上的分布不好，KETAMA_HASH是默认的MemCache推荐的一致性Hash算法，而FNV1_32_HASH算法的效率就会高一些。
 * （2）这是一个排序问题，采用红黑树时间复杂度为O(LogN),Java中有对应的实现TreeMap,并且TreeMap本身提供了一个tailMap(K fromKey)方法，支持从红黑树中查找比fromKey大的值的集合，但并不需要遍历整个数据结构。
 */
public class HashFunctionImpl implements HashFunction {
    /**
     *  FNV1_32_HASH算法,不重写hash方法
     * @param key
     * @return
     */
    @Override
    public Integer hash(String key) {
        final int p = 16777619;
        int hash = (int)2166136261L;
        for (int i = 0; i < key.length(); i++){
            hash = (hash ^ key.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        }
        // 如果算出来的值为负数则取其绝对值
        if (hash < 0){
            hash = Math.abs(hash);
        }
        return hash;
    }
}
