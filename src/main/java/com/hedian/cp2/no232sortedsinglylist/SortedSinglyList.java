package com.hedian.cp2.no232sortedsinglylist;

import com.hedian.cp2.no232singlylist.Node;
import com.hedian.cp2.no232singlylist.SinglyList;

public class SortedSinglyList<T extends Comparable<? super T>> extends SinglyList<T> {

    public SortedSinglyList() {
        super();
    }

    public SortedSinglyList(T[] values) {
        super();
        for (T value : values) {
            this.insert(value);
        }
    }

    //存 异常
    //取 父类
    //增
    @Override
    public int insert(T t) {
        Node<T> frontNode = this.head;
        Node<T> currentNode = this.head.next;
        int index = 0;
        while (currentNode != null && currentNode.data.compareTo(t) < 0) {
            frontNode = frontNode.next;
            currentNode = currentNode.next;
            index++;
        }
        frontNode.next = new Node<>(currentNode, t);
        this.size++;
        return index;
    }
    //删

    @Override
    public T remove(int index) {
        return null;
    }
}
