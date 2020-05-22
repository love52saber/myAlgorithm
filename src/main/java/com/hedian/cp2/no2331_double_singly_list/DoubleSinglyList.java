package com.hedian.cp2.no2331_double_singly_list;

public class DoubleSinglyList<T> {

    protected DoubleNode<T> head;

    protected  int size;

    public DoubleSinglyList() {
        head = new DoubleNode<>(null, null, null);
        this.size = 0;
    }

    public DoubleSinglyList(T[] values) {
        this();
        DoubleNode<T> frontNode = head;
        for (int i = 0; i < values.length; i++) {
            frontNode.next = new DoubleNode<>(values[i], frontNode, null);
            frontNode = frontNode.next;
            this.size++;
        }
    }

    //存
    //取
    //遍历
    //增
}
