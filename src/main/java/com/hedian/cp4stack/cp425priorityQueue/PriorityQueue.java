package com.hedian.cp4stack.cp425priorityQueue;

import com.hedian.cp2.no232singlylist.Node;
import com.hedian.cp2.no232sortedsinglylist.SortedSinglyList;
import com.hedian.cp4stack.cp422seqQueue.MyQueue;
import com.hedian.cp4stack.cp423linkedQueue.LinkedQueue;

public class PriorityQueue<T extends Comparable<? super T>> extends LinkedQueue<T> {

    @Override
    public void enqueue(T x) {
        Node<T> currentNode = head.next;
        Node<T> frontNode = head;
        while (currentNode != null && currentNode.data.compareTo(x) < 0) {
            currentNode = currentNode.next;
            frontNode = frontNode.next;
        }
        frontNode.next = new Node<>(currentNode, x);
    }


    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.enqueue(1);
        queue.enqueue(4);
        queue.enqueue(3);
        System.out.println(queue);
    }
}
