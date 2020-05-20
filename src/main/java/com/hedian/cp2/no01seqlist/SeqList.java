package com.hedian.cp2.no01seqlist;

public class SeqList<T> {

    protected Object[] elementContainer;
    protected int elementNum;

    //1.构造
    public SeqList(int elementNum) {
        this.elementContainer = new Object[elementNum];
        this.elementNum = elementNum;
    }
    public SeqList() {
        this(1);
    }
    public SeqList(T[] elements) {
        this(elements.length);
        for (int i = 0; i < elements.length; i++) {
            this.elementContainer[i] = elements[i];
        }
    }

    public boolean isEmpty() {
        return this.elementNum == 0;
    }

    public int size() {
        return this.elementNum;
    }

    //2.存取
    public T get(int i) {
        if (i >= 0 && i < this.elementNum) {
            return (T) this.elementContainer[i];
        }
        return null;
    }

    public void set(int i, T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        if (i >= 0 && i < this.elementNum) {
            this.elementContainer[i] = t;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    //3.遍历
    @Override
    public String toString() {
        String str = this.getClass().getName() + "(";
        for (int i = 0; i < this.elementNum; i++) {
            str += (this.elementContainer[i].toString() + ",");
        }
        return str + ")";
    }

    //4.增
    public int insert(int index,T t) {
        if (index < 0 || index > this.elementContainer.length) {
            throw new IndexOutOfBoundsException();
        }
        if (this.elementNum == elementContainer.length) {
            //扩容
            Object[] newElementContainer = new Object[elementContainer.length * 2];
            for (int i = 0; i < elementContainer.length; i++) {
                newElementContainer[i] = this.elementContainer[i];
            }
            this.elementContainer = newElementContainer;
        }
        for (int j = elementNum-1; j >= index; j--) {
            elementContainer[j + 1] = elementContainer[j];
        }
        elementContainer[index] = t;
        this.elementNum += 1;
        return index;
    }

    //
    public int insert(T t) {
        this.insert(this.elementNum, t);
        return this.elementNum - 1;
    }

    //5 删
    public int remove(int index) {
        if (index < 0 || index > this.elementNum) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < this.elementNum - 1; i++) {
            this.elementContainer[i] = this.elementContainer[i+1];
        }
        this.elementContainer[this.elementNum - 1] = null;
        this.elementNum -= 1;
        return index;
    }

    //6 查询 o(n)
    public int search(T t) {
        for (int i = 0; i < this.elementNum; i++) {
            if (t.equals(this.elementContainer[i])) {
                return i;
            }
        }
        return -1;
    }


}
