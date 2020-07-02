package com.hedian.cp5MutiArray.cp522ArrayCompress;

import com.hedian.cp5MutiArray.cp51MutiArray.Matrix;
import com.hedian.cp5MutiArray.cp51MutiArray.MyMatrix;

public class CrossCompressMatrix implements MyMatrix {

    private int rows;

    private int cols;

    private CrossNode[] rowheads;

    private CrossNode[] colheads;

    public CrossCompressMatrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.rowheads = new CrossNode[this.rows];
        this.colheads = new CrossNode[this.cols];
    }

    public CrossCompressMatrix(int rows, int cols, Triple[] elements) {
        this(rows, cols);
        for (int i = 0; i < elements.length; i++) {
            this.set(elements[i]);
        }
    }

    private void set(Triple element) {
        this.set(element.row, element.col, element.number);
    }

    @Override
    public int get(int i, int j) {
        return 0;
    }

    @Override
    public void set(int i, int j, int value) {
        if (value == 0) {
            return;                                        //不存储值为0元素}
        }
        if (i >= this.rows || j >= this.cols) {
            throw new IllegalArgumentException("三元组的行或列序号越界");
        }
        Triple newTriple = new Triple(i, j, value);
        CrossNode newCrossNode = new CrossNode(newTriple, null, null);
        //行
        if (this.rowheads == null) {
            //行头插入
            this.rowheads[i] = new CrossNode(newTriple, this.rowheads[i], null);
        } else {
            //非头插入
            CrossNode currentNode = this.rowheads[0];
            while (currentNode != null) {
                if (currentNode.triple.compareTo(newTriple) > 0) {

                }
                currentNode = currentNode.right;
            }
        }
    }
}
