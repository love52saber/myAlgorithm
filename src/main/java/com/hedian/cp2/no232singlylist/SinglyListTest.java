package com.hedian.cp2.no232singlylist;

import org.junit.Test;

public class SinglyListTest {

    @Test
    public void testInsert() {
        SinglyList<Integer> list = new SinglyList<>();
        list.insert(1);
        System.out.println(list);
        list.insert(2);
        System.out.println(list);
        list.reverse();
        System.out.println(list);
    }
}
