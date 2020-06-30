package com.hedian.cp4stack.cp412seqstack;

import com.hedian.cp2.no01seqlist.SeqList;

/**
 * @author gjyang
 */
public class SeqStack<T> implements MyStack<T>{
    
    private SeqList<T> element;
    
    @Override
    public boolean isEmpty() {
        return this.element.isEmpty();
    }

    @Override
    public void push(T x) {
        this.element.insert(x);
    }

    @Override
    public T pop() {
        return this.element.remove(element.size()-1);
    }

    @Override
    public T get() {
        return this.element.get(this.element.size()-1);
    }
}
