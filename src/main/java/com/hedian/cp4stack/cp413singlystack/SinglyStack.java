package com.hedian.cp4stack.cp413singlystack;

import com.hedian.cp2.no232singlylist.SinglyList;
import com.hedian.cp4stack.cp412seqstack.MyStack;


public class SinglyStack<T> implements MyStack<T> {

    protected SinglyList<T> element;

    public SinglyStack() {
        element = new SinglyList<>();
    }

    @Override
    public boolean isEmpty() {
        return this.element.size()==0;
    }

    @Override
    public void push(T x) {
        this.element.insert(0, x);
    }

    @Override
    public T pop() {
        return this.element.remove(0);
    }

    @Override
    public T get() {
        return this.element.get(0);
    }

    @Override
    public String toString() {
        return this.element.toString();
    }
}
