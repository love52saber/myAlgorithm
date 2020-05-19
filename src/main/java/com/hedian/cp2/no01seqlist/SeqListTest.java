package com.hedian.cp2.no01seqlist;

import org.junit.Test;

public class SeqListTest {

    @Test
    public void testInsert() {
        SeqList<Integer> list = new SeqList<>();
        list.insert(1);
        list.insert(2);
        System.out.println(list);
    }

    @Test
    public void testJosephus() {
        Josephus josephus = new Josephus(5, 0, 2);
        josephus.calcuLastOne();
    }
}
