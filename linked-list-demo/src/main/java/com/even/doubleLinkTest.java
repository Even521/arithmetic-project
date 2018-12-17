package com.even;

import com.even.doub.HeadDoubleILinkedList;
import org.junit.jupiter.api.Test;

/**
 * Created by Administrator on 2018/12/17 0017.
 *
 * @author even
 */
public class doubleLinkTest {
    @Test
    public void doubleLinkTest(){
        String[] letters={"A","B","C","D","Z","E","F"};
//        String[] letters={"A"};
        HeadDoubleILinkedList<String> list=new HeadDoubleILinkedList<>(letters);

        System.out.println("list.get(3)->"+list.get(3));
        System.out.println("list:"+list.toString());

        System.out.println("list.add(4,Y)—>"+list.add(0,"Y"));
        System.out.println("list:"+list.toString());
        System.out.println("list.add(Z)—>"+list.add("Z"));
        System.out.println("list:"+list.toString());


        System.out.println("list.contains(Z)->"+list.contains("Z"));
        System.out.println("list.set(4,P)-->"+list.set(4,"P"));
        System.out.println("list:"+list.toString());


        System.out.println("list.remove(6)-->"+list.remove(6));
//        System.out.println("list.remove(Z)->"+list.removeAll("Z"));
        System.out.println("list:"+list.tostring());
    }
}
