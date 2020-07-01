package com.hedian.cp4stack.cp423linkedQueue;

import com.hedian.cp2.no232singlylist.Node;
import com.hedian.cp4stack.cp422seqQueue.MyQueue;

public class LinkedQueue<T> implements MyQueue<T> {

    private Node<T> front;

    private Node<T> rear;

    public LinkedQueue() {
        this.front = null;
        this.rear = this.front;
    }

    @Override
    public boolean isEmpty() {
        return front == null && rear == null;
    }

    @Override
    public void enqueue(T x) {
        Node<T> newRear = new Node<T>(null, x);
        if (front == null) {
            this.front = newRear;
        } else {
            this.rear.next = newRear;
        }
        this.rear = newRear;
    }

    @Override
    public T dequeue() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException("队列为空");
        }
        Node<T> dequeuedNode = this.front;
        this.front = this.front.next;
        return dequeuedNode.data;
    }

    @Override
    public T get() {
        return this.front == null ? null : this.front.data;
    }

    @Override
    public String toString()                     //返回队列所有元素的描述字符串，形式为“(,)”
    {                                            //算法同不带头结点的单链表
        String str = "(";
        for (Node<T> p = this.front; p != null; p = p.next) {
            str += p.data.toString();
            if (p.next != null)
                str += ", ";                               //不是最后一个结点时后加分隔符
        }
        return str + ")";                                    //空表返回()
    }
}
