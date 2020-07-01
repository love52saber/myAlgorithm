package com.hedian.cp4stack.cp425priorityQueue;

import com.hedian.cp2.no232sortedsinglylist.SortedSinglyList;
import com.hedian.cp4stack.cp422seqQueue.MyQueue;

public class PriorityQueue<T extends Comparable<? super T>> implements MyQueue<T> {

    private SortedSinglyList<T> list;

    public PriorityQueue(SortedSinglyList<T> list) {
        this.list = list;
    }

    @Override
    public boolean isEmpty() {
        return list.size()==0;
    }

    @Override
    public void enqueue(T x) {
        list.insert(x);
    }

    @Override
    public T dequeue() {
        return list.remove(0);
    }

    @Override
    public T get() {
        return list.get(0);
    }
}
