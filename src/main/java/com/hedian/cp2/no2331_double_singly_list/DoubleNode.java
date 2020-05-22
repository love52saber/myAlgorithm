package com.hedian.cp2.no2331_double_singly_list;

public class DoubleNode<T> {

    public T data;

    public DoubleNode<T> prev;

    public DoubleNode<T> next;

    public DoubleNode() {
    }

    public DoubleNode(T data, DoubleNode<T> prev, DoubleNode<T> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
