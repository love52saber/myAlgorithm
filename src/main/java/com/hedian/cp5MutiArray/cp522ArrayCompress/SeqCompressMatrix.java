package com.hedian.cp5MutiArray.cp522ArrayCompress;

import com.hedian.cp2.no01seqlist.SeqList;
import com.hedian.cp5MutiArray.cp51MutiArray.MyMatrix;

public class SeqCompressMatrix implements MyMatrix {

    private int rows;

    private int cols;

    private SeqList<Triple> elements;

    public SeqCompressMatrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.elements = new SeqList<>();
    }

    public SeqCompressMatrix(int rows, int cols, Triple[] triples) {
        this(rows, cols);
        for (int i = 0; i < triples.length; i++) {
            this.set(triples[i]);
        }
    }

    private void set(Triple triple) {
        this.set(triple.row, triple.col, triple.number);
    }

    @Override
    public int get(int i, int j) {
        if (i<0 || i>=rows || j<0 || j>=cols)
            throw new IndexOutOfBoundsException("矩阵元素的行或列序号越界");
        int t = 0;
        while (t < this.elements.size()) {
            Triple triple = this.elements.get(t);
            if (triple.row == i && triple.col == j) {
                return triple.number;
            }
            if (triple.row > i || triple.row == i && triple.col > j) {
                break;
            }
        }
        return 0;
    }

    @Override
    public void set(int i, int j, int value) {
        int temp = 0;
        SeqList<Triple> elements = this.elements;
        Triple newTriple = new Triple(i, j, value);
        while (temp < this.elements.size()) {
            Triple triple = elements.get(temp);
            if (newTriple.compareTo(triple) < 0) {
                break;
            } else if (newTriple.compareTo(triple) == 0) {
                this.elements.set(i, newTriple);
                return;
            } else {
                temp++;
            }
        }
        this.elements.insert(temp, newTriple);
    }

    public void add(SeqCompressMatrix newMatrix) {
        if (this.rows != newMatrix.rows || this.cols != newMatrix.cols) {
            throw new IllegalArgumentException("不能相加");
        }
        int i = 0;
        int j = 0;
        while (i < this.elements.size() && j < newMatrix.elements.size()) {
            Triple triple = this.elements.get(i);
            Triple newTriple = newMatrix.elements.get(j);
            if (triple.compareTo(newTriple) < 0) {
                i++;
            } else if (triple.compareTo(newTriple) == 0) {
                triple.add(newTriple);
                i++;
                j++;
            } else {
                j++;
            }
        }
        while (j < newMatrix.elements.size()) {
            this.elements.insert(newMatrix.elements.get(j));
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("矩阵:\n");
        int k = 0;
        Triple triple = this.elements.get(k);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                if (triple.row == i && triple.col == j) {
                    sb.append(String.format("%4d", triple.number));
                    if (k < this.elements.size() - 1) {
                        triple = this.elements.get(++k);
                    }
                } else {
                    sb.append(String.format("%4d", 0));
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
