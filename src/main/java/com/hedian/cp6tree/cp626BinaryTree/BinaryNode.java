package com.hedian.cp6tree.cp626BinaryTree;

public class BinaryNode<T> {

    public T data;

    public BinaryNode<T> left;

    public BinaryNode<T> right;

    public BinaryNode() {
        this.data = null;
        this.left = null;
        this.right = null;
    }

    public BinaryNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
