package com.hedian.cp6tree.cp633TriBinaryTree;

import com.hedian.cp6tree.cp626BinaryTree.BinaryNode;
import com.hedian.cp6tree.cp626BinaryTree.MyBinaryTree;

public class TribinaryTree<T> implements MyBinaryTree<T> {

    private TriNode<T> root;

    public TribinaryTree() {
        root = null;
    }

    public TribinaryTree(T[] prelist) {
        
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void preOrder() {

    }

    @Override
    public void inOrder() {

    }

    @Override
    public void postOrder() {

    }

    @Override
    public void levelOrder() {

    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public T search(T key) {
        return null;
    }

    @Override
    public BinaryNode<T> getParent(BinaryNode<T> node) {
        return null;
    }

    @Override
    public void insertRoot(T x) {

    }

    @Override
    public BinaryNode<T> insertChild(BinaryNode<T> p, T x, boolean leftChild) {
        return null;
    }

    @Override
    public void removeChild(BinaryNode<T> p, boolean leftChild) {

    }

    @Override
    public void removeAll() {

    }
}
