package com.hedian.cp4stack.cp423linkedQueue;

import com.hedian.cp2.no232singlylist.Node;
import com.hedian.cp4stack.cp422seqQueue.MyQueue;

public class LinkedQueue<T> implements MyQueue<T> {

    private Node<T> head;

    private Node<T> rear;

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void enqueue(T x) {

    }

    @Override
    public T dequeue() {
        return null;
    }
}
