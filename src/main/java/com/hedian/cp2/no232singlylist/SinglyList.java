package com.hedian.cp2.no232singlylist;

public class SinglyList<T> {

    //头指针
    protected Node<T> head;

    //头指针
    protected int size;

    public SinglyList() {
        this.head = new Node<>();
        this.size = 0;
    }

    public SinglyList(T[] values) {
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
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> frontNode = this.head;
        for (int i = 0; i < index; i++) {
            frontNode = frontNode.next;
        }
        frontNode.next = new Node<>(frontNode.next, t);
        size++;
        return index-1;
    }

    public int insert( T t) {
        return this.insert(this.size, t);
    }

    //删
    public T remove(int index) {
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> currentNode = this.head.next;
        Node<T> frontNode = this.head;
        Node<T> backNode = this.head.next;
        for (int i = 0; i < index; i++) {
            frontNode = currentNode;
            currentNode = currentNode.next;
            backNode = currentNode.next != null ? currentNode.next : null;
        }
        frontNode.next = backNode;
        return currentNode.data;
    }

    //删
    public T remove(T t) {
        Node<T> frontNode = this.head;
        Node<T> currentNode = this.head.next;
        while (currentNode != null) {
            if (currentNode.data.equals(t)) {
                frontNode.next = currentNode.next;
            }
            size--;
        }
        return t;
    }

    //查
    public int search(T t) {
        Node<T> currentNode = head;
        int index = 0;
        while (currentNode != null) {
            if (currentNode.data.equals(t)) {
                return index;
            }
            currentNode = currentNode.next;
            index++;
        }
        return -1;
    }

    //包含
    public boolean contains(T t) {
        Node<T> currentNode = head.next;
        while (currentNode != null) {
            if (currentNode.data.equals(t)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    //逆转
    public SinglyList<T> reverse() {
        Node<T> frontNode = null;
        Node<T> currentNode = head.next;
        Node<T> nextNode = null;
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = frontNode;
            frontNode = currentNode;
            currentNode = nextNode;
        }
        head.next = frontNode;
        return this;
    }

}
