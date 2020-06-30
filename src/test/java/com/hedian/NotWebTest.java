package com.hedian;

import com.hedian.cp2.no232singlylist.SinglyList;
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

    @Test
    public void test04() {
        List<Integer> list = new LinkedList<>();
        list.add(65, 1);
        System.out.println(list);
    }

    @Test
    public void test05() {
        String str = "1x111";
        int i = str.indexOf('1',1);
        System.out.println(i);
    }

    @Test
    public void test06() {
        List<String> list = new ArrayList<>();
        list.add("1");
        String remove = list.remove(1);
        System.out.println(remove);
    }

    @Test
    public void test07() {
        SinglyList<String> list = new SinglyList<>();
        list.insert("1");
        list.insert("2");
        String remove = list.remove(1);
        System.out.println(remove);
        System.out.println(list);
        String s = list.get(0);
        System.out.println(s);
    }
}
