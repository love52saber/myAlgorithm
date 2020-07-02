package com.hedian.cp5MutiArray.cp522ArrayCompress;

import com.hedian.cp2.no2411polyx.Addible;

import java.util.Objects;

public class Triple implements Addible<Triple>,Comparable<Triple> {

    public int row;

    public int col;

    public int number;

    public Triple() {
    }

    public Triple(int row, int col, int number) {
        this.row = row;
        this.col = col;
        this.number = number;
    }

    @Override
    public boolean addiable(Triple triple) {
        return this.row == triple.row && this.col == triple.col;
    }

    @Override
    public void add(Triple triple) {
        if (!this.addiable(triple)) {
            throw new IllegalArgumentException("不能相加");
        }
        this.number += triple.number;
    }

    @Override
    public boolean removable() {
        return false;
    }

    @Override
    public int compareTo(Triple triple) {
        //当前三元组对象小
        if (this.row < triple.row || this.row == triple.row && this.col < triple.col) {
            return -1;
        }
        //相等，与equals()方法含义不同
        if (this.row == triple.row && this.col == triple.col) {
            return 0;
        }
        //当前三元组对象大
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triple triple = (Triple) o;
        return row == triple.row &&
                col == triple.col;
    }

}
