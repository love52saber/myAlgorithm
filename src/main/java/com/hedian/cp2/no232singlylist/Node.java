package com.hedian.cp2.no232singlylist;

public class Node<T> {

    public Node<T> next;

    public T data;

    public Node() {
    }

    public Node(Node<T> next, T data) {
        this.next = next;
        this.data = data;
    }

}
