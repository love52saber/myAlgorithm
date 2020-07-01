package com.hedian.cp4stack.cp422seqQueue;

import com.hedian.cp2.no01seqlist.SeqList;
import org.omg.CORBA.Object;

public class SeqQueue<T> implements MyQueue<T> {

    private T[] elements;

    private int front;

    private int rear;

    public SeqQueue() {
        this(64);
    }

    public SeqQueue(int size) {
        this.elements = (T[]) new Object[size];
        front = 0;
        rear = 0;
    }

    @Override
    public boolean isEmpty() {
        return front==rear;
    }

    @Override
    public void enqueue(T x) {
        if (front == (rear + 1) % this.elements.length) {
            //扩容
            T[] newElements = (T[]) new Object[this.elements.length];
            int j = 0;
            for (int i = front; i != this.rear; i = (i+1)%this.elements.length,j++) {
                newElements[j] = this.elements[i];
            }
            front = 0;
            rear = j;
            this.elements = newElements;
        }
        this.elements[rear+1] = x;
        rear = (rear + 1) % this.elements.length;
    }

    @Override
    public T dequeue() {
        if (this.isEmpty()) {
            return null;
        }
        T temp = this.elements[this.front];
        this.front = (this.front + 1) % this.elements.length;
        return temp;
    }

    @Override
    public T get() {
        return this.elements[rear];
    }
}
