package com.hedian.cp4stack.cp422seqQueue;

public class SeqQueue<T> implements MyQueue<T> {

    //只能使用数组
    private Object[] elements;

    private int head;

    private int rear;

    public SeqQueue() {
        this(64);
    }

    public <T> SeqQueue(int size) {
        elements = new Object[size];
        head = 0;
        rear = 0;
    }

    @Override
    public boolean isEmpty() {
        return head == rear;
    }

    @Override
    public void enqueue(T x) {
        if (head == (this.rear + 1) % this.elements.length) {
            //扩容
            int j = 0;
            Object[] newContainer = new Object[this.elements.length * 2];
            for (int i = this.head; i != this.rear ; i = (i + 1)%this.elements.length, j++) {
                newContainer[j] = this.elements[i];
            }
            this.head = 0;
            this.rear = j;
        }
        rear = (rear + 1)%this.elements.length;
        this.elements[rear] = x;
    }

    @Override
    public T dequeue() {
        T headElement = (T) elements[head];
        head = (head + 1) % this.elements.length;
        return headElement;
    }

    @Override
    public T get() {
        return (T) elements[head];
    }
}
