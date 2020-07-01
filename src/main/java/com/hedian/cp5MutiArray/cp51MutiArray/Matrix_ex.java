package com.hedian.cp5MutiArray.cp51MutiArray;

public class Matrix_ex {

    public static void main(String[] args) {
        int m1[][]={{1,2,3},{4,5,6,7,8},{9,10,11}};
        Matrix mata=new Matrix(3,4,m1);                    //矩阵对象，初值不足时自动补0，忽略多余元素
        System.out.print(mata);
        int m2[][] = {{1, 2, 3, 4}, {5, 6, 7}, {8, 9, 10}};
        Matrix mata2=new Matrix(3,4,m2);
        mata.add(mata2);
        System.out.println(mata);
    }
}
