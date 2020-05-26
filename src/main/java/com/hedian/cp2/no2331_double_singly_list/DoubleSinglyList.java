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
    public void set(int index, T t) {
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        DoubleNode<T> currentNode = head.next;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        currentNode.data = t;
    }
    //取
    public T get(int index) {
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        DoubleNode<T> currentNode = head.next;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }
    //遍历

    @Override
    public String toString() {
        String str = this.getClass().toString() + "(";
        DoubleNode<T> currentNode = head.next;
        for (int i = 0; i < this.size; i++) {
            str += (currentNode.data + ",");
            currentNode = currentNode.next;
        }
        return str;
    }

    //增
    public int insert(int index, T t) {
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        DoubleNode<T> currentNode = head.next;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        DoubleNode<T> newNode = new DoubleNode<>(t, currentNode.prev, currentNode);
        currentNode.prev.next = newNode;
        currentNode.prev = newNode;
        size++;
        return index;
    }

    //删
    public T remove(int index) {
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        DoubleNode<T> currentNode = head.next;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        currentNode.prev.next = currentNode.next;
        currentNode.next.prev = currentNode.prev;
        return null;
    }
    //查
}
