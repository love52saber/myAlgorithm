package com.hedian.cp2.no11singlylist;

public class SinglyList<T> {

    //头指针
    private Node<T> head;

    //头指针
    private int size;

    public SinglyList() {
        this.head = new Node<>();
        this.size = 0;
    }

    public SinglyList(T[] values) {
        super();
        Node<T> rearNode = this.head;
        for (T value : values) {
            Node<T> newNode = new Node<T>(null,value);
            rearNode.next = newNode;
            rearNode = newNode;
            size++;
        }
    }

    public int size() {
        return this.size;
    }

    //存取
    public T get(int index) {
        if (index < 0 || index > this.size()) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> rearNode = this.head.next;
        for (int i = 0; i < index; i++) {
            rearNode = rearNode.next;
        }
        return rearNode.data;
    }

    public void set(int index,T t) {
        if (index < 0 || index > this.size()) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> toSetNode = this.head.next;
        for (int i = 0; i < index; i++) {
            toSetNode = toSetNode.next;
        }
        toSetNode.data = t;
    }

    //遍历
    @Override
    public String toString() {
        String str = this.getClass().getName() + "(";
        Node<T> p = this.head.next;
        while (p != null) {
            str += p.data.toString();
            p = p.next;
        }
        return str + ")";
    }

    //增
    public int insert(int index, T t) {
        Node<T> currentNode = this.head.next;
        Node<T> frontNode = this.head.next;
        Node<T> backNode = this.head.next;
        for (int i = 0; i < index; i++) {
            frontNode = currentNode;
            currentNode = currentNode.next;
            backNode = currentNode.next;
        }
        return 0;
    }

}
