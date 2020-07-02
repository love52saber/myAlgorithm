package com.hedian.cp5MutiArray.cp51MutiArray;

public interface MyMatrix {
    //构造方法
    public int get(int i, int j);                //返回矩阵第i行第j列元素值
    public void set(int i, int j, int value);    //设置矩阵第i行第j列的元素值为value
    //String toString();
//    public void add(Matrix mm);                //矩阵相加，this+=mat，各对应元素相加；改变this矩阵
}
