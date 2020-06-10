package com.hedian.cp3.cp3221string;

import org.junit.Test;

public class MyString_test {

    @Test
    public void test01() {
        String str = "GTGTGCTGGTGTGTGCFAA";
        int gtgtgcf = str.indexOf("GTGTGCF");
        System.out.println(gtgtgcf);
    }

    @Test
    public void test02() {
        MyString s1 = new MyString("GTGTGCTGGTGTGTGCFAA");
        MyString s2 = new MyString("GTGTGCF");
        int i = s1.indexofByBf2(s2);
        System.out.println(i);
    }

    @Test
    public void test03() {
        MyString s1 = new MyString("GTGTGCTGGTGTGTGCFAA");
        int i = s1.indexofByKMT2(new MyString("GTGTGCF"));
        System.out.println(i);
    }
}
