package com.hedian.cp4stack.cp413singlystack;

import com.hedian.cp2.no232singlylist.SinglyList;
import com.hedian.cp4stack.cp412seqstack.MyStack;

/**
 * 链表栈
 * @param <T>
 */
public class SinglyStack<T> implements MyStack<T> {

    private SinglyList<T> elements;

    public SinglyStack() {
        elements = new SinglyList<>();
    }

    @Override
    public boolean isEmpty() {
        return elements.size() == 0;
    }

    @Override
    public void push(T x) {
        elements.insert(0, x);
    }

    @Override
    public T pop() {
        return elements.remove(0);
    }

    @Override
    public T get() {
        return elements.get(0);
    }
}
