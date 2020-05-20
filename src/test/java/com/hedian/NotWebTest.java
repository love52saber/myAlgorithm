package com.hedian;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NotWebTest {

    @Test
    public void test01() {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        List<Integer> list2 = new ArrayList(list);
        list.remove(1);
        System.out.println(list);
        System.out.println(list2);
    }

    @Test
    public void test02() {
        List<Integer> list = new ArrayList();
        list.add(65, 1);
        System.out.println(list);
    }

    @Test
    public void test03() {
        List<Integer> list = new LinkedList<>();
        list.add(65, 1);
        System.out.println(list);
    }
}
