package com.hedian.cp2.no01seqlist;

public class SeqList<T> {

    protected Object[] elements;
    protected int length;

    public SeqList(int length) {
        this.elements = new Object[length];
        this.length = 0;
    }
    public SeqList() {
        this(64);
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public int size() {
        return this.length;
    }

    public T get(int i) {
        if (i >= 0 && i < this.length) {
            return (T) this.elements[i];
        }
        return null;
    }

    public void set(int i, T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        if (i >= 0 && i < this.length) {
            this.elements[i] = t;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        String str = this.getClass().getName() + "(";
        for (int i = 0; i < this.length; i++) {
            str += this.elements[i].toString();
        }
        return str + ")";
    }

    //


}
