package com.hedian.cp4stack.cp412seqstack;

import com.hedian.cp2.no01seqlist.SeqList;

/**
 * @author gjyang
 */
public class SeqStack<T> implements MyStack<T>{

    private SeqList<T> elements;

    public SeqStack() {
    }

    public SeqStack(int size) {
        elements = new SeqList<>(64);
    }

    @Override
    public boolean isEmpty() {
        return elements.size() == 0;
    }

    @Override
    public void push(T x) {
        this.elements.insert(x);
    }

    @Override
    public T pop() {
        return elements.remove(elements.size() - 1);
    }

    @Override
    public T get() {
        return elements.get(elements.size());
    }
}
