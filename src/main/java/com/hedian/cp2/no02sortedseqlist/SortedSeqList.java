package com.hedian.cp2.no02sortedseqlist;

import com.hedian.cp2.no01seqlist.SeqList;

import java.security.Key;

public class SortedSeqList<T extends Comparable<? super T>> extends SeqList<T> {

    public SortedSeqList(int elementNum) {
        super(elementNum);
    }

    public SortedSeqList() {
        super();
    }

    public SortedSeqList(T[] elements) {
        super(elements.length);
        for (T element : elements) {
            this.insert(element);
        }
    }

    @Override
    public void set(int i, T t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int insert(int index, T t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int insert(T t) {
        int addIndex = 0;
        if (this.elementNum == 0 || t.compareTo(this.get(this.elementNum))>1) {
            addIndex = this.elementNum + 1;
        }
        for (int i = 0; i < this.elementNum; i++) {
            if (t.compareTo(this.get(i))>0) {
                //顺序
                addIndex = i;
            }
        }
        super.insert(addIndex, t);
        return addIndex;
    }

    //删
    public T remove(T t) {
        return this.remove(this.search(t));
    }

    //查
    @Override
    public int search(T t) {
        int i = 0;
        while (t.compareTo(this.get(i)) <= 0) {
            if (t.compareTo(this.get(i)) == 0) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
