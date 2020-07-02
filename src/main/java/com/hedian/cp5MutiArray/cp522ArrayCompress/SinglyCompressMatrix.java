package com.hedian.cp5MutiArray.cp522ArrayCompress;

import com.hedian.cp2.no01seqlist.SeqList;
import com.hedian.cp2.no232singlylist.SinglyList;
import com.hedian.cp5MutiArray.cp51MutiArray.MyMatrix;

public class SinglyCompressMatrix implements MyMatrix {

    private SeqList<SinglyList<Triple>> elements;

    private int rows;

    private int cols;

    public SinglyCompressMatrix(int rows, int columns) {
        this.rows = rows;
        this.cols = columns;
        elements = new SeqList<>(rows);
        for (int i = 0; i < rows; i++) {
            this.elements.set(i,new SinglyList<Triple>());
        }
    }

    public SinglyCompressMatrix(int rows, int cols, Triple[] triples) {
        this(rows, cols);
        for (Triple triple : triples) {
            this.set(triple.row, triple.col, triple.number);
        }
    }

    @Override
    public int get(int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            throw new IndexOutOfBoundsException("矩阵元素的行或列序号越界");
        }
        SinglyList<Triple> row = this.elements.get(i);
        Triple triple = new Triple(i, j, 0);
        return row.search(triple);
    }

    @Override
    public void set(int i, int j, int value) {
        Triple newTriple = new Triple(i, j, value);
        SinglyList<Triple> row = this.elements.get(i);
        int k = 0;
        while (k < row.size()) {
            Triple tempTriple = row.get(k);
            if (tempTriple.col < j) {
                break;
            } else if (tempTriple.col == j) {
                row.set(k, newTriple);
                return;
            } else {
                k++;
            }
        }
        row.insert(k, newTriple);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("矩阵:\n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int number = this.get(i, j);
            }
        }
        return super.toString();
    }
}
