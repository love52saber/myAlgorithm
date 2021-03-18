package com.hedian.cp6tree.cpextraBSTTress;

import com.hedian.cp6tree.cp626BinaryTree.BinaryNode;

public class BSTTreeNode<T extends Comparable<T>> extends BinaryNode<T> {

    public T data;

    public BSTTreeNode<T> left;

    public BSTTreeNode<T> right;

    public BSTTreeNode() {
        this.data = null;
        this.left = null;
        this.right = null;
    }

    public BSTTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public BSTTreeNode(T data, BSTTreeNode<T> left, BSTTreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
