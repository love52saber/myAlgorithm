package com.hedian.cp3.cp3221string;

import org.junit.Test;

public class MyString_test {

    @Test
    public void test01() {
        MyString s1 = new MyString("123");
        char[] chars = new char[]{'3', '2', '1'};
        MyString s2 = new MyString(chars);
        MyString s3 = new MyString(s1);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }

    @Test
    public void test02() {
        MyString s1 = new MyString("abcdef");
        MyString s2 = new MyString("cd");
        int i = s1.indexofByBf(s2);
        System.out.println(i);
    }

    @Test
    public void test03() {
        MyString s1 = new MyString("GTGTGCTGGTGTGTGCFAA");
        int i = s1.indexofByKMT(new MyString("GTGTGCF"));
        System.out.println(i);
    }
}
