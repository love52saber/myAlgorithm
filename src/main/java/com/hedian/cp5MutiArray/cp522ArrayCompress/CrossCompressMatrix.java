package com.hedian.cp5MutiArray.cp522ArrayCompress;

import com.hedian.cp5MutiArray.cp51MutiArray.Matrix;
import com.hedian.cp5MutiArray.cp51MutiArray.MyMatrix;

import java.util.Currency;

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
    //
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
        if (this.rowheads[i] == null || this.rowheads[i].triple.col > j) {
            //行头插入或空行插入
            newCrossNode.right = this.rowheads[i];
            this.rowheads[i] = newCrossNode;
        } else {
            //非头插入非空行
            CrossNode frontNode = null;
            CrossNode currentNode = this.rowheads[0];
            while (currentNode != null) {
                //> 下一节点
                //== set
                //< 新增节点
                if (newCrossNode.triple.col < currentNode.triple.col) {
                    frontNode.right = newCrossNode;
                    newCrossNode.right = currentNode;
                    break;
                } else if (newCrossNode.triple.col == currentNode.triple.col) {
                    CrossNode rightNode = currentNode.right;
                    newCrossNode.right = rightNode;
                    frontNode.right = newCrossNode;
                    break;
                }
                frontNode = currentNode;
                currentNode = currentNode.right;
            }
            frontNode.right = new CrossNode(newTriple, null, null);
        }
        //列
        CrossNode colhead = this.colheads[j];
        if (colhead == null || colhead.triple.row > i) {
            //头插入
            newCrossNode.down = colhead;
            colhead = newCrossNode;
        } else {
            //非头插入
            CrossNode frontNode = null;
            CrossNode currentNode = colhead;
            while (currentNode != null && currentNode.triple.row <= newCrossNode.triple.row) {
                frontNode = currentNode;
                currentNode = currentNode.down;
            }
            frontNode.down = newCrossNode;
            newCrossNode.down = currentNode;
        }
    }

    @Override
    public String toString()                               //返回稀疏矩阵三元组十字链表和稀疏矩阵字符串
    {
        String str="三元组十字链表\n";
        str+="三元组行的单链表：";
        for (int i=0; i<this.rowheads.length; i++)
        {
            str+="(";
            for (CrossNode p=this.rowheads[i];  p!=null;  p=p.right)
            {
                str += p.triple.toString();
                if (p.right!=null)
                    str+=",";
            }
            str += ")";
            if (i<this.rowheads.length-1)
                str += ", ";
        }
        str+="\n三元组列的单链表：";
        for (int i=0; i<this.colheads.length; i++)
        {
            str+="(";
            for (CrossNode p=this.colheads[i];  p!=null;  p=p.down)
            {
                str += p.triple.toString();
                if (p.down!=null)
                    str+=",";
            }
            str += ")";
            if (i<this.colheads.length-1)
                str += ", ";
        }

        str+="\n稀疏矩阵"+this.getClass().getName()+"（"+rows+"×"+cols+"）：\n";
        for (int i=0; i<this.rows; i++)
        {
            CrossNode p=this.rowheads[i];
            for (int j=0; j<this.cols; j++)
                if (p!=null && j==p.triple.col)            //有i==p.data.row
                {
                    str += String.format("%4d",p.triple.number);
                    p = p.right;
                }
                else
                    str +=String.format("%4d",0);
            str += "\n";
        }
        return str;
    }

}
