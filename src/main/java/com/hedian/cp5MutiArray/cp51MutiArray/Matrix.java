package com.hedian.cp5MutiArray.cp51MutiArray;

public class Matrix implements MyMatrix {

    private int[][] elements;

    public Matrix() {
        this(8);
    }

    public Matrix(int m, int n) {
        elements = new int[m][n];
    }

    public Matrix(int n) {
        elements = new int[n][n];
    }

    public Matrix(int m, int n, int mat[][]) {
        this(m, n);
        for (int i = 0; i < mat.length && i < m; i++) {
            for (int j = 0; j < mat[i].length && j < n; j++) {
                this.elements[i][j] = mat[i][j];
            }
        }
    }

    @Override
    public int get(int i, int j) {
        return elements[i][j];
    }

    @Override
    public void set(int i, int j, int x) {
        elements[i][j] = x;
    }

    @Override
    public void add(Matrix mm) {
        if (this.elements.length!=mm.elements.length || this.elements[0].length!=mm.elements[0].length)
            throw new IllegalArgumentException("两个矩阵阶数不同，不能相加");
        for (int i = 0; i < this.elements.length; i++) {
            for (int j = 0; j < this.elements[i].length; j++) {
                this.elements[i][j] += mm.get(i, j);
            }
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < this.elements.length; i++) {
            sb.append("(");
            for (int j = 0; j < this.elements[i].length; j++) {
                sb.append(this.elements[i][j]+" ,");
            }
            sb.append(")\n");
        }
        return sb.toString();
    }
}
