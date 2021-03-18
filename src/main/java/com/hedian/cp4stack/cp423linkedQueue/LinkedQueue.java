package com.hedian.cp4stack.cp423linkedQueue;

import com.hedian.cp2.no232singlylist.Node;
import com.hedian.cp4stack.cp422seqQueue.MyQueue;

import java.util.LinkedList;

public class LinkedQueue<T> implements MyQueue<T> {

    protected Node<T> head;

    protected Node<T> rear;

    public LinkedQueue() {
        head = new Node<>();
        rear = head;
    }


    @Override
    public boolean isEmpty() {
        return head == rear;
    }

    @Override
    public void enqueue(T x) {
//        Node<T> tmp = rear;
//        tmp.next = new Node<>(null, x);
        rear.next = new Node<>(null, x);
        rear = rear.next;
    }

    @Override
    public T dequeue() {
        T data = head.next.data;
        head = head.next.next;
        return data;
    }

    @Override
    public T get() {
        return head.data;
    }

    public static void main(String[] args) {
        LinkedQueue<String> queue = new LinkedQueue<>();
        queue.enqueue("1");
        queue.enqueue("2");
        System.out.println(queue);
        String str = queue.dequeue();
        System.out.println(queue);
        System.out.println(str);
    }
}
