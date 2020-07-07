package com.hedian.cp6tree.cp633TriBinaryTree;

public class TriNode<T> {

    private T data;

    private TriNode<T> left;

    private TriNode<T> right;

    private TriNode<T> parent;

    public TriNode(T data, TriNode<T> left, TriNode<T> right, TriNode<T> parent) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public TriNode(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }


}
